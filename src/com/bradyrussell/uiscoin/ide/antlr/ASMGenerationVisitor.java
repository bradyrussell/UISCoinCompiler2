package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;
import com.bradyrussell.uiscoin.ide.symboltable.*;
import org.antlr.v4.runtime.RuleContext;

import java.util.ArrayList;
import java.util.List;

public class ASMGenerationVisitor extends UISCBaseVisitor<String> {
    ////////////////////////
    int LabelIndex = 0;

    ScopeGlobal Global = new ScopeGlobal("GlobalScope", null);
    ScopeLocal CurrentLocalScope = null;

    ScopeBase getCurrentScope() {
        return CurrentLocalScope == null ? Global : CurrentLocalScope;
    }

    void PushLocalScope(String ScopeName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeLocal(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeLocal(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
    }

    ScopeCapture PushLocalScopeCapture(String ScopeName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeCapture(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeCapture(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
        return (ScopeCapture) CurrentLocalScope;
    }

    void PushFunctionScope(PrimitiveType FunctionType, String FunctionName, List<NameAndType> Parameters) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = Global.defineFunction(FunctionName, FunctionType, Parameters);
        } else {
            CurrentLocalScope = CurrentLocalScope.defineFunction(FunctionName, FunctionType, Parameters);
        }
    }

    void PopLocalScope() {
        if (CurrentLocalScope.Parent instanceof ScopeLocal) {
            CurrentLocalScope = (ScopeLocal) CurrentLocalScope.Parent;
            return;
        }
        CurrentLocalScope = null;
    }
    ////////////////////////

    private String getNextLabel(){
        return "L"+LabelIndex++;
    }

    //todo Literal calculation visitor? like 2+5+2 would just return 9? or just add to the visitor if both are literals return the calc'd value

    private static String stripQuotesFromString(String QuotedString) {
        return QuotedString.substring(1, QuotedString.length() - 1);
    }

    // returns asm to cast one type to another, or null if conversion is not allowed
    private static String generateCastAssembly(PrimitiveType From, PrimitiveType To) {
        if (From.equals(To)) return " ";

        StringBuilder asm = new StringBuilder();

        if (From.equals(PrimitiveType.Byte)) {
            if (To.getSize() > 1) { // int32 is the intermediate type
                asm.append("convert8to32 ");
                From = PrimitiveType.Int32;
            }
        }

        if (From.equals(PrimitiveType.Int64)) {
            // int32 is the intermediate type
            asm.append("convert64to32 ");
            From = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Float)) {
            // int32 is the intermediate type
            asm.append("convertfloatto32 ");
            From = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Int32)) {
            switch (To) {
                case Byte -> {
                    asm.append("convert32to8 ");
                    return asm.toString();
                }
                case Int32 -> {
                    return asm.toString();
                }
                case Int64 -> {
                    asm.append("convert32to64 ");
                    return asm.toString();
                }
                case Float -> {
                    asm.append("convert32tofloat ");
                    return asm.toString();
                }
            }
        }

        if(From.equals(PrimitiveType.Void)) {
            System.out.println("Warning: Casting from void could violate type safety!");
            return "";
        }
        System.out.println("Cannot cast from "+From+" to "+To+"!");
        return null;
    }

    private String getCastedBinaryExpression(UISCParser.ExpressionContext LHS, UISCParser.ExpressionContext RHS, String BinaryOperationForIntegers, String BinaryOperationForFloats){
        PrimitiveType lhsType = LHS.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType rhsType = RHS.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if(lhsType == null || rhsType == null) {
            System.out.println("Type null! Cannot determine type: " + lhsType + " and " + rhsType);
            return "TYPE_NULL_" + lhsType + "_AND_" + rhsType + "_ERROR";
        }

        PrimitiveType outputType = PrimitiveType.getWiderType(lhsType, rhsType);

        if (outputType == null) {
            System.out.println("Type mismatch! Cannot combine types " + lhsType + " and " + rhsType);
            return "TYPE_MISMATCH_CANNOT_COMBINE_" + lhsType + "_AND_" + rhsType + "_ERROR";
        }

        return visit(LHS) + " " + generateCastAssembly(lhsType,outputType) + visit(RHS) + " "  + generateCastAssembly(rhsType,outputType) + (outputType.equals(PrimitiveType.Float) ? BinaryOperationForFloats : BinaryOperationForIntegers) + " ";
    }

    @Override
    protected String defaultResult() {
        return "";
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult) {
        if (aggregate.isEmpty()) return nextResult;
        return aggregate + "\n" + nextResult;
    }

    /**
     * Begin Literals
     */

    @Override
    public String visitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx) {
        PrimitiveType typeOfInteger = ASMGenPrimitiveTypeVisitor.deduceTypeOfNumber(ctx.number().getText());
        return ASMUtil.generateComment(typeOfInteger+ " literal "+ctx.getText()) + "push " + (PrimitiveType.Byte.equals(typeOfInteger) ? "[":"") + ctx.number().getText()+ (PrimitiveType.Byte.equals(typeOfInteger) ? "]":"");
    }

    @Override
    public String visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        return ASMUtil.generateComment("String literal "+ctx.getText()) + "push " + ctx.STRING().getText();
    }

    @Override
    public String visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        return ASMUtil.generateComment("Char literal "+ctx.getText()) + "push " + ctx.CHAR().getText().replace("'", "\"");
    }

    @Override
    public String visitBooleanLiteral(UISCParser.BooleanLiteralContext ctx) {
        return ctx.getText();
    }

    /** End Literals */




    /**
     * Begin Initialization
     */

    @Override
    public String visitArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx) {
        PrimitiveType type = PrimitiveType.getByKeyword(ctx.type().getText());
        String strValue = stripQuotesFromString(ctx.STRING().getText());
        int address = getCurrentScope().declareArray(ctx.ID().getText(), type, strValue.length());

        if (address < 0) {
            System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
            return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
        }

        return ASMUtil.generateComment("Array string initialization "+ctx.getText()) + " push \"" + strValue + "\"" + ASMUtil.generateStoreAddress(address)/*" push [" + address + "] put"*/;
    }

    @Override
    public String visitArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx) {
        PrimitiveType symbolType = PrimitiveType.getByKeyword(ctx.type().getText());
        int address = getCurrentScope().declareArray(ctx.ID().getText(), symbolType,Integer.parseInt(ctx.INT().getText()));

        if (address < 0) {
            System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
            return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
        }

        if(ctx.expression() != null) {
            //todo copy rhs array
        }

        return " push "+(symbolType.getSize() * Integer.parseInt(ctx.INT().getText()))+" alloc "+ASMUtil.generateStoreAddress(address);//"push ["+address+"] put";
    }

    @Override
    public String visitVarInitialization(UISCParser.VarInitializationContext ctx) {
        PrimitiveType symbolType = ctx.pointer() != null ? (PrimitiveType.getByKeyword(ctx.type().getText()) == null ? null : PrimitiveType.getByKeyword(ctx.type().getText()).toPointer()) : PrimitiveType.getByKeyword(ctx.type().getText());

        if(symbolType == null) {
            int address = getCurrentScope().declareStruct(ctx.ID().getText(),ctx.type().getText());

            if (address < 0) {
                System.out.println("Struct symbol was already defined in this scope! " + ctx.ID().getText());
                return "STRUCT_SYMBOL_REDEFINITION_" + ctx.ID().getText();
            }

            System.out.println(">>Initialized struct symbol " + ctx.ID().getText() + " of type " + ctx.type().getText() + " with address " + address);
            return getCurrentScope().findStructDefinition(ctx.type().getText()).generateAllocatorASM() + ASMUtil.generateStoreAddress(address);
        }

        if(ctx.constant == null) {

            int address = getCurrentScope().declareSymbol(ctx.ID().getText(), symbolType);

            if (address < 0) {
                System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
            }

            //int address = ((SymbolBase) getCurrentScope().symbolTable.get(ctx.ID().getText())).address;
            System.out.println(">>Initialized symbol " + ctx.ID().getText() + " of type " + symbolType + " with address " + address);

            if (ctx.expression() != null) {
                PrimitiveType rhsType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

                boolean bShouldWiden = false;

                if (!symbolType.equals(rhsType)) {
                    if (rhsType.widensTo(symbolType)) {
                        bShouldWiden = true;
                    } else {
                        System.out.println("Type mismatch! Expected " + symbolType + " found " + rhsType);
                        return "TYPE_MISMATCH_EXPECTED_" + symbolType + "_FOUND_" + rhsType;
                    }
                }

                return visit(ctx.expression()) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbolType) : "") + ASMUtil.generateStoreAddress(address);//" push [" + address + "] put";
            }
            return "";
        } else {
            if(getCurrentScope().findScopeContaining(ctx.ID().getText()) != null) {
                System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
            }

            if (ctx.expression() != null) {
                if(ctx.expression() instanceof UISCParser.NumberLiteralExpressionContext) {
                    UISCParser.NumberLiteralExpressionContext expression = (UISCParser.NumberLiteralExpressionContext) ctx.expression();

                    TypedValue constantValue;

                    if (expression.number().INT() != null) {
                        constantValue = new TypedValue(PrimitiveType.getByKeyword(ctx.type().getText()),Long.parseLong(expression.number().INT().getText()));
                    } else {
                        constantValue = new TypedValue(Float.parseFloat(expression.number().FLOAT().getText()));
                    }

                    getCurrentScope().declareConstantInlineSymbol(ctx.ID().getText(), constantValue);
                    System.out.println(">>Defined constant "+ctx.ID().getText()+" of type "+constantValue.type+" with value "+constantValue);
                    return "";
                } else {
                    System.out.println("Cannot use that rvalue as a constant!");
                    return "INVALID_CONSTANT_RVALUE_"+ctx.ID().getText();
                }
            }
            System.out.println("Must specify constant value!");
            return "INVALID_CONSTANT_"+ctx.ID().getText();
        }
    }

    /** End Initialization */



    /**
     * Begin Statements
     */

    @Override
    public String visitTryCatchStatement(UISCParser.TryCatchStatementContext ctx) {
        StringBuilder tryCatchAsm = new StringBuilder();

        // maybe record depth here so we can drop back to that depth?
        // put inside a virtualscript so returns are caught
        // execute and jumpif over the catch block if returned true

        ScopeCapture captureScope = PushLocalScopeCapture("TryStatement");

        tryCatchAsm.append(visit(ctx.tryStatement()));

        PopLocalScope();

        return ASMUtil.generateComment("Try statement ") + captureScope.generateCaptureASM() + tryCatchAsm.toString();


/*        if(ctx.catchStatement() != null){
            PushLocalScope("CatchStatement");

            PopLocalScope();
        } else {
            // clean up exceptions?
        }
        /// drop back to that depth?*/

        //return tryCatchAsm.toString();
    }

    @Override
    public String visitException(UISCParser.ExceptionContext ctx) {
        return ASMUtil.generateComment("Exception "+ctx.getText()) + visit(ctx.exprList()) + " return ";
    }

    @Override
    public String visitAssignmentStatement(UISCParser.AssignmentStatementContext ctx) {
        if(ctx.lhs == null) {

            ScopeBase scopeContainingStruct = getCurrentScope().findScopeContaining(ctx.lhs_struct.structname.getText());

            if(scopeContainingStruct == null){
                System.out.println("Undefined struct " + ctx.lhs_struct.structname.getText());
                return "STRUCT_NOT_DEFINED_" + ctx.lhs_struct.structname.getText();
            }

            SymbolStruct symbol = (SymbolStruct) scopeContainingStruct.getSymbol(ctx.lhs_struct.structname.getText());

            PrimitiveType fieldType = symbol.struct.getFieldType(ctx.lhs_struct.fieldname.getText());

            if(fieldType == null){
                System.out.println("Undefined field " + ctx.lhs_struct.structname.getText() + "." + ctx.lhs_struct.fieldname.getText());
                return "FIELD_NOT_DEFINED_"+ ctx.lhs_struct.structname.getText() + "." +  ctx.lhs_struct.fieldname.getText();
            }

            PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

            boolean bShouldWiden = false;

            if (!fieldType.equals(rhsType)) {
                if (rhsType.widensTo(symbol.struct.getFieldType(ctx.lhs_struct.fieldname.getText()))) {
                    bShouldWiden = true;
                } else {
                    System.out.println("Type mismatch! Expected " + fieldType + " found " + rhsType);
                    return "TYPE_MISMATCH_EXPECTED_" + fieldType + "_FOUND_" + rhsType + "_ERROR";
                }
            }
                        // value to set                                                                         struct base address                 struct field setter
            return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, fieldType) : "") + " push " + symbol.address + symbol.struct.generateFieldSetterASM(ctx.lhs_struct.fieldname.getText());
        }

        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.lhs.getText());

        if(scopeContaining == null){
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }

        if(scopeContaining.getSymbol(ctx.lhs.getText()) instanceof TypedValue) {
            System.out.println("Assigning to constant " + ctx.ID().getText());
            return "ASSIGN_TO_CONSTANT_" + ctx.ID().getText();
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.lhs.getText());

        if (symbol == null) {
            System.out.println("Undefined symbol " + ctx.lhs.getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }

        PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        boolean bShouldWiden = false;

        if (!symbol.type.equals(rhsType)) {
            if (rhsType.widensTo(symbol.type)) {
                bShouldWiden = true;
            } else {
                System.out.println("Type mismatch! Expected " + symbol.type + " found " + rhsType);
                return "TYPE_MISMATCH_EXPECTED_" + symbol.type + "_FOUND_" + rhsType + "_ERROR";
            }
        }

        if (ctx.arrayIndex == null) {
            //return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") + " push [" + symbol.address + "] put";
            return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") + symbol.generateSetSymbolASM();
        } else {
            PrimitiveType indexType = ctx.arrayIndex.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            return ASMUtil.generateComment("Assignment statement "+ctx.getText()) + visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") +
                    "push "+symbol.address+" "+ // push stack element
                    visit(ctx.arrayIndex) +" "+ generateCastAssembly(indexType, PrimitiveType.Int32) +// push array index auto casted to int

                    (symbol.type.getSize() == 1 ? "" : (symbol.type.getSize()+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                            " multiply"))+
/*
                    " push "+symbol.type.getSize()+ // multiply by sizeof to get beginIndex
                    " multiply "+*/

                    "push "+symbol.type.getSize()+
                    " set ";  // push sizeof

           // return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") + " push " + symbol.address + " " + visit(ctx.arrayIndex) + " push " + /*sizeof type*/symbol.type.getSize() + " set";
        }
    }

    @Override
    public String visitOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx) {
        return null;//todo
    }

    @Override
    public String visitReturnStatement(UISCParser.ReturnStatementContext ctx) {
        PrimitiveType returnedType = ctx.retval.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        RuleContext parent = ctx.parent;
        while (parent != null && !(parent instanceof UISCParser.FunctionDeclarationContext)) parent = parent.parent;
        UISCParser.FunctionDeclarationContext functionDeclaration = (UISCParser.FunctionDeclarationContext)parent;

        if(functionDeclaration == null) {
            System.out.println("Return outside of function declaration " + ctx.getText());
            return "RETURN_OUTSIDE_FUNCTION_" + ctx.getText() + "_ERROR";
        } else {
            PrimitiveType definedReturnType = PrimitiveType.getByKeyword(functionDeclaration.type().getText());
            if(returnedType.widensTo(definedReturnType)) {
                return ASMUtil.generateComment("Return statement "+ctx.getText()) + " "+generateCastAssembly(returnedType,definedReturnType)+visit(ctx.retval);
            } else {
                System.out.println("Type mismatch! Expected " + definedReturnType + " found " + returnedType);
                return "TYPE_MISMATCH_EXPECTED_" + definedReturnType + "_FOUND_" + returnedType + "_ERROR";
            }
        }
    }

    @Override
    public String visitIfStatement(UISCParser.IfStatementContext ctx) {
        String ifBlockLabel = getNextLabel();
        ArrayList<String> elseIfLabels = new ArrayList<>();

        for (UISCParser.ElseifStatementContext elseifStatementContext : ctx.elseifStatement()) {
            elseIfLabels.add(getNextLabel());
        }

        String endLabel = getNextLabel();

        StringBuilder asm = new StringBuilder();

        if(ctx.elseifStatement().size() == 0) { // optimized if no else ifs
            /*
            if()
            condition
            gotoif true
            FALSEBLOCK
            goto end
            :true
            TRUEBLOCK
            :end
             */

            asm.append(visit(ctx.conditional)); // condition
            asm.append(" gotoif ").append(ifBlockLabel).append(" "); // gotoif true
            PushLocalScope("IfStatement_ElseBlock");
            if(ctx.elseStatement() != null) asm.append(visit(ctx.elseStatement())); // falseblock
            PopLocalScope();
            asm.append(" goto ").append(endLabel); // goto end
            asm.append(" :").append(ifBlockLabel).append(" "); // :true
            PushLocalScope("IfStatement_IfBlock");
            asm.append(visit(ctx.ifbody)); // TRUEBLOCK
            PopLocalScope();
            asm.append(" :").append(endLabel); //:end

        } else {
             /*

        if ()
        condition
        gotoif true

        else if()
        condition
        gotoif eliftrue1

        else if()
        condition
        gotoif eliftrue2

        else()
        ELSEBLOCK
        goto end
        :true
        TRUEBLOCK
        goto end

        :eliftrue1
           ELIFTRUE1BLOCK
          goto end

       :eliftrue2
           ELIFTRUE2BLOCK
          goto end

        :end

         */

            asm.append(visit(ctx.conditional)); // condition
            asm.append(" gotoif ").append(ifBlockLabel).append(" "); // gotoif true

            for (int i = 0; i < ctx.elseifStatement().size(); i++) {
                asm.append(visit(ctx.elseifStatement().get(i).conditional)); // elif condition
                asm.append(" gotoif ").append(elseIfLabels.get(i)).append(" "); // goto elif N
            }

            // else
            asm.append(visit(ctx.elseStatement())).append(" goto ").append(endLabel); // ELSEBLOCK goto end

            asm.append(" :").append(ifBlockLabel).append(" "); // :true
            asm.append(visit(ctx.ifbody)); // TRUEBLOCK
            asm.append(" goto ").append(endLabel); // goto end

            for (int i = 0; i < ctx.elseifStatement().size(); i++) {
                PushLocalScope("IfStatement_ElseIfBlock_"+i);
                asm.append(" :").append(elseIfLabels.get(i)).append(" "); // :elifN
                asm.append(visit(ctx.elseifStatement().get(i)));
                if(i < ctx.elseifStatement().size()-1) asm.append(" goto ").append(endLabel); // goto end (skip last)
                PopLocalScope();
            }

            asm.append(" :").append(endLabel); // :end
        }

        return ASMUtil.generateComment("If statement "+ctx.conditional.getText()) + asm.toString();
    }

    @Override
    public String visitUforiStatement(UISCParser.UforiStatementContext ctx) { // loop unrolling
        int ItBegin, ItEnd;

        if(ctx.iterationsEnd != null) {
            ItBegin = Integer.parseInt(ctx.iterations.getText());
            ItEnd = Integer.parseInt(ctx.iterationsEnd.getText());
        } else {
            ItEnd = Integer.parseInt(ctx.iterations.getText());
            ItBegin = 0;
        }

        PushLocalScope("ForIStatement");


      //  int IteratorAddress = getCurrentScope().declareSymbol(ctx.ID().getText(), Type.getByKeyword(ctx.type().getText()));

        StringBuilder forIStatement = new StringBuilder();

        for (int i = ItBegin; i < ItEnd; i++) {
            PushLocalScope("ForIStatement_Inner_"+i);
            getCurrentScope().declareConstantInlineSymbol(ctx.ID().getText(), new TypedValue(PrimitiveType.getByKeyword(ctx.type().getText()),i));
            forIStatement.append(visit(ctx.forbody));
            PopLocalScope();
        }

        PopLocalScope();

        return ASMUtil.generateComment("For I Statement "+ItBegin+", "+ItEnd) + forIStatement.toString();
    }

    @Override
    public String visitUforeachStatement(UISCParser.UforeachStatementContext ctx) { // loop unrolling
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.arrayToLoop.getText());
        if (scopeContaining == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not defined in this scope.");
            return "ARRAY_NOT_DEFINED_" + ctx.ID().getText();
        }

        SymbolArray symbol = (SymbolArray) scopeContaining.getSymbol(ctx.ID().getText());

        if (symbol == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly defined in this scope.");
            return "ARRAY_NOT_PROPERLY_DEFINED_" + ctx.ID().getText();
        }

        PushLocalScope("ForEachStatement_"+ctx.ID().getText());

        StringBuilder forEachStatement = new StringBuilder();

        if(ctx.varDeclaration() instanceof UISCParser.VarInitializationContext) {
            UISCParser.VarInitializationContext varDeclaration = (UISCParser.VarInitializationContext) ctx.varDeclaration();

            PrimitiveType varType = PrimitiveType.getByKeyword(varDeclaration.type().getText());

            if(!symbol.type.widensTo(varType)) { /// todo cast
                System.out.println("The foreach element was not the correct type. " + varDeclaration.getText());
                return "FOREACH_VAR_NOT_CORRECT_TYPE_EXPECTED_" + symbol.type;
            }

            if(varDeclaration.constant != null || varDeclaration.expression() != null || varType == null) {
                System.out.println("The foreach element was not properly defined. It cannot be a constant or assigned a value and must have a type. " + varDeclaration.getText());
                return "FOREACH_VAR_NOT_PROPERLY_DEFINED_" + ctx.ID().getText();
            }

            for (int i = 0; i < symbol.length; i++) {
                PushLocalScope("ForEachStatement_"+ctx.arrayToLoop.getText()+"_Inner_"+i);

                int varAddress = getCurrentScope().declareSymbol(varDeclaration.ID().getText(), varType);
//todo off by one to the right?
                forEachStatement.append( "push "+symbol.address+ // push stack element
                        " push "+i +// push array index
                        " push "+symbol.type.getSize()+ // multiply by sizeof to get beginIndex
                        " multiply push "+symbol.type.getSize()+
                        " get " + generateCastAssembly(symbol.type, varType) + // auto widen to foreach var type
                        ASMUtil.generateStoreAddress(varAddress) // put the array element into the foreach var
                );

                forEachStatement.append(visit(ctx.forbody));

                PopLocalScope();
            }

        }

        PopLocalScope();

        return ASMUtil.generateComment("ForEach Statement "+ctx.arrayToLoop.getText()) + forEachStatement.toString();

    }

    @Override
    public String visitAssertion(UISCParser.AssertionContext ctx) {
        return ASMUtil.generateComment("Assertion "+ctx.getText()) + visit(ctx.expression())+" verify";
    }



    /** End Statements */




    /**
     * Begin Expressions
     */

    @Override
    public String visitComparisonExpression(UISCParser.ComparisonExpressionContext ctx) {
        switch (ctx.op.getText()){
            case "<" ->{
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " lessthan", " lessthan");
            }
            case "<=" ->{
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " lessthanequal", " lessthanequal");
            }
            case ">" ->{
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " greaterthan", " greaterthan");
            }
            case ">=" ->{
                return getCastedBinaryExpression(ctx.lhs, ctx.rhs, " greaterthanequal", " greaterthanequal");
            }
            default -> {
                return "INVALID_COMPARISON_OPERATOR_ERROR";
            }
        }
    }

    @Override
    public String visitAssembly(UISCParser.AssemblyContext ctx) {
        return ASMUtil.generateComment("Raw ASM "+ctx.getText()) + stripQuotesFromString(ctx.STRING().getText());
    }

    @Override
    public String visitModuloExpression(UISCParser.ModuloExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"modulo", "convertfloatto32 swap convertfloatto32 swap modulo convert32tofloat"); // dont think there is float mod
    }

    @Override
    public String visitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());

        if(scopeContaining == null){
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }

        Object uncastedSymbol = scopeContaining.getSymbol(ctx.ID().getText());

        if(uncastedSymbol instanceof TypedValue) {
            System.out.println("Cannot get the address of constant " + ctx.ID().getText());
            return "ADDRESS_OF_CONSTANT_" + ctx.ID().getText();
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;

        if (symbol == null) {
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }
        return ASMUtil.generateComment("Address Of variable "+ctx.getText()) + "push " + symbol.address;
    }

    @Override
    public String visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx) { // this will return number of bytes in array, not number of elements. divide by sizeof
        return ASMUtil.generateComment("Length of "+ctx.getText()) + visit(ctx.expression()) + " len swap drop"; // this removes the value which we took the length of
    }

    @Override
    public String visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx) {
        PrimitiveType sizeOfType = PrimitiveType.getByKeyword(ctx.type().getText());
        if (sizeOfType == null) {
            System.out.println("Invalid type! Cannot determine size of invalid type " + ctx.type().getText());
            return "INVALID_TYPE_" + ctx.type().getText()+"_ERROR";
        }

        return ASMUtil.generateComment("SizeOf "+ctx.getText()) + "push ["+sizeOfType.getSize()+"]";
    }


    @Override
    public String visitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx) {
        if (ctx.op.getText().contains("&")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"bitand", "bitand");
        }
        if (ctx.op.getText().contains("|")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"bitor","bitor");
        }
        if (ctx.op.getText().contains("^")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"bitxor","bitxor");
        }
        if (ctx.op.getText().contains("~")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"bitnot","bitnot");
        }
        return super.visitBitwiseExpression(ctx);
    }

    @Override
    public String visitTernaryExpression(UISCParser.TernaryExpressionContext ctx) {
        String truelabel = getNextLabel();
        String falselabel = getNextLabel();
        return ASMUtil.generateComment("Ternary "+ctx.getText()) + visit(ctx.condition) + " gotoif "+truelabel+" "+ visit(ctx.iffalse) + " goto "+falselabel+" :"+truelabel+" "+visit(ctx.iftrue)+" :"+falselabel;
    }


    @Override
    public String visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        PrimitiveType exprType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope)).fromPointer();
        String castAssembly = generateCastAssembly(exprType, PrimitiveType.Byte);

        if(exprType == PrimitiveType.Void) {
            System.out.println("Warning: ValueAt of non pointer ("+ctx.expression().getText()+") returns unknown type (void)!");
        }

        return ASMUtil.generateComment("Get Value At variable "+ctx.getText()) + visit(ctx.expression())+castAssembly+" pick ";
    }

    @Override
    public String visitCastExpression(UISCParser.CastExpressionContext ctx) {
        PrimitiveType fromType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType toType = PrimitiveType.getByKeyword(ctx.type().getText());
        String castAssembly = generateCastAssembly(fromType, toType);

        if (castAssembly == null) {
            System.out.println("Type mismatch! Cannot cast from " + fromType + " to " + toType);
            return "CANNOT_CAST_FROM_" + fromType + "_TO_" + toType + "_ERROR";
        }

        return ASMUtil.generateComment("Cast "+ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
    }

    @Override
    public String visitEqualityExpression(UISCParser.EqualityExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs," bytesequal" + (ctx.op.getText().contains("!=") ? " not" : "")," bytesequal" + (ctx.op.getText().contains("!=") ? " not" : ""));
        //return visit(ctx.lhs) + " " + visit(ctx.rhs) + " bytesequal" + (ctx.op.getText().contains("!=") ? " not" : "");
    }

    @Override
    public String visitNegateExpression(UISCParser.NegateExpressionContext ctx) {
/*        if(ctx.expression() instanceof UISCParser.NumberLiteralExpressionContext) { // if number literal, negate the literal // todo asm cant handle -INT
            return "push -" + ((UISCParser.NumberLiteralExpressionContext)ctx.expression()).number().getText();
        }*/
        // todo negate fails on byte. fix this and we can remove below
        PrimitiveType fromType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if(PrimitiveType.Byte.equals(fromType)) {
            return visit(ctx.expression()) + " convert8to32 negate convert32to8";
        } else {
            return visit(ctx.expression()) + " negate";
        }
    }

    @Override
    public String visitNotExpression(UISCParser.NotExpressionContext ctx) {
        return visit(ctx.expression()) + " not";
    }

    @Override
    public String visitAddSubExpression(UISCParser.AddSubExpressionContext ctx) {
        if(ctx.lhs instanceof UISCParser.StringLiteralExpressionContext || (ctx.lhs instanceof UISCParser.VariableReferenceExpressionContext && // is this array concat?
                getCurrentScope().findScopeContaining(((UISCParser.VariableReferenceExpressionContext)ctx.lhs).ID().getText()) != null &&
                getCurrentScope().findScopeContaining(((UISCParser.VariableReferenceExpressionContext)ctx.lhs).ID().getText()).getSymbol(((UISCParser.VariableReferenceExpressionContext)ctx.lhs).ID().getText()) instanceof SymbolArray)) {
            // todo this will throw off symbol array lengths, so foreach wouldnt work. dont see how this can work unless the sizes are fixed. maybe use set 0, len*size instead? to force user to create new array long enough
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"push [2] combine", "push [2] combine");
        }

        if (ctx.op.getText().contains("+")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"add", "addfloat");
        }
        if (ctx.op.getText().contains("-")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"subtract","subtractfloat");
        }
        return super.visitAddSubExpression(ctx);
    }

    @Override
    public String visitMultDivExpression(UISCParser.MultDivExpressionContext ctx) {
        if (ctx.op.getText().contains("*")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"multiply","multiplyfloat");
        }
        if (ctx.op.getText().contains("/")) {
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"divide","dividefloat");
        }
        return super.visitMultDivExpression(ctx);
    }

    @Override
    public String visitAndOrExpression(UISCParser.AndOrExpressionContext ctx) {
        if (ctx.lhs instanceof UISCParser.BooleanLiteralExpressionContext) { // optimization. could optimize more by checking if the result of visit is false or true
            if (ctx.op.getText().contains("&&")) {
                return Boolean.parseBoolean(visit(ctx.lhs)) && Boolean.parseBoolean(visit(ctx.rhs)) ? "true" : "false";
            }
            if (ctx.op.getText().contains("||")) {
                return Boolean.parseBoolean(visit(ctx.lhs)) || Boolean.parseBoolean(visit(ctx.rhs)) ? "true" : "false";
            }
        }

        if (ctx.op.getText().contains("&&")) {
            return visit(ctx.lhs) + " " + visit(ctx.rhs) + " " + "and";
        }
        if (ctx.op.getText().contains("||")) {
            return visit(ctx.lhs) + " " + visit(ctx.rhs) + " " + "or";
        }
        return super.visitAndOrExpression(ctx);
    }

    @Override
    public String visitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());

        if(scopeContaining == null){
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }

        Object uncastedSymbol = scopeContaining.getSymbol(ctx.ID().getText());

        if(uncastedSymbol instanceof TypedValue) { // constant
            return ((TypedValue)uncastedSymbol).generateGetSymbolASM();
           //return "push "+((TypedValue)uncastedSymbol);
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;

        if (symbol == null) {
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }
        return ASMUtil.generateComment("Variable reference "+ctx.getText()) + symbol.generateGetSymbolASM();
        //return "push [" + symbol.address + "] pick ";
    }

    @Override
    public String visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) { // todo typecheck
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Function " + ctx.ID().getText() + " was not defined in this scope.");
            return "FUNCTION_NOT_DEFINED_" + ctx.ID().getText();
        }

        ScopeWithSymbol functionSymbol = (ScopeWithSymbol) scopeContaining.getSymbol(ctx.ID().getText());

        if (functionSymbol == null) {
            System.out.println("Function " + ctx.ID().getText() + " was not properly defined in this scope.");
            return "FUNCTION_NOT_PROPERLY_DEFINED_" + ctx.ID().getText();
        }

        int numParamsProvided = ctx.exprList().expression().size();
        if(functionSymbol.Symbol.getNumberOfParameters() != numParamsProvided) {
            System.out.println("Function " + ctx.ID().getText() + " expects "+functionSymbol.Symbol.getNumberOfParameters()+" but only "+numParamsProvided+" were provided.");
            return "FUNCTION_INCORRECT_NUMBER_PARAMETERS_" + ctx.ID().getText()+"_EXPECTED_"+functionSymbol.Symbol.getNumberOfParameters()+"_FOUND_"+numParamsProvided;
        }

        StringBuilder sb = new StringBuilder();

        List<UISCParser.ExpressionContext> expression = ctx.exprList().expression();
        for (int i = 0; i < expression.size(); i++) {
            PrimitiveType providedType = expression.get(i).accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            if(providedType.widensTo(functionSymbol.Symbol.getTypeOfParameter(i))) {
                sb.append(ASMUtil.generateComment("Function parameter "+functionSymbol.Symbol.getNameOfParameter(i)));
                sb.append(visit(expression.get(i))).append(" ").append(generateCastAssembly(providedType, functionSymbol.Symbol.getTypeOfParameter(i)));
                sb.append(ASMUtil.generateStoreAddress(((Symbol)functionSymbol.getSymbol(functionSymbol.Symbol.getNameOfParameter(i))).getSymbolAddress()));
            } else {
                System.out.println("Function " + ctx.ID().getText() + " expects "+functionSymbol.Symbol.getTypeOfParameter(i)+" for parameter "+functionSymbol.Symbol.getNameOfParameter(i)+" but "+providedType+" was provided.");
                return "FUNCTION_INCORRECT_TYPE_PARAMETERS_" + ctx.ID().getText()+"_EXPECTED_"+functionSymbol.Symbol.getTypeOfParameter(i)+"_FOUND_"+providedType;
            }
        }

        // todo check parameter types
        return sb.toString()+ ASMUtil.generateComment("Function call "+ctx.getText()) + // params
                " depth "+//capture whole stack
                //" push ["+ctx.exprList().expression().size()+"] "+ // number of parameters
                functionSymbol.generateGetSymbolASM()+
                //" push [" + functionSymbol.Symbol.address + "] pick"+ // get function bytecode
                "call verify"; // execute and ensure it did not fail
    }

    @Override
    public String visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        // this is always r value
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not defined in this scope.");
            return "ARRAY_NOT_DEFINED_" + ctx.ID().getText();
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.ID().getText());

        if (symbol == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly defined in this scope.");
            return "ARRAY_NOT_PROPERLY_DEFINED_" + ctx.ID().getText();
        }

        int SizeOf = symbol.type.getSize();

        PrimitiveType indexExpressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        String castAssembly = generateCastAssembly(indexExpressionType, PrimitiveType.Int32);

        if(castAssembly == null) {
            System.out.println("Array " + ctx.ID().getText() + " access with unsupported type: "+indexExpressionType);
            return "ARRAY_INDEX_INVALID_TYPE_" + indexExpressionType;
        }

        return ASMUtil.generateComment("Array access "+ctx.getText()) + "push "+symbol.address+" "+ // push stack element
                visit(ctx.expression())+" "+ castAssembly +// push array index auto casted to int
                " push "+
                (SizeOf == 1 ? "" : (SizeOf+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                " multiply"))+
                " push "+SizeOf+
                " get ";  // push sizeof
    }

    @Override
    public String visitStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.structField().structname.getText());
        if (scopeContaining == null) {
            System.out.println("Struct " + ctx.structField().structname.getText() + " was not defined in this scope.");
            return "STRUCT_NOT_DEFINED_" + ctx.structField().structname.getText();
        }

        SymbolStruct symbol = (SymbolStruct) scopeContaining.getSymbol(ctx.structField().structname.getText());

        if (symbol == null) {
            System.out.println("Struct " + ctx.structField().structname.getText() + " was not properly defined in this scope.");
            return "STRUCT_NOT_PROPERLY_DEFINED_" + ctx.structField().structname.getText();
        }

        // todo type check
        // todo cast?
        return " push "+ symbol.address + symbol.struct.generateFieldGetterASM(ctx.structField().fieldname.getText());
    }

    /**
     * End Expressions
     */


    @Override
    public String visitArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx) { // todo could be optimized into a single push. would that be smaller? // todo type check
        if (getCurrentScope().hasSymbol(ctx.ID().getText())) {
            System.out.println("Symbol " + ctx.ID().getText() + " was already defined in this scope!");
            return "ERROR_SYMBOL_REDEFINITION_" + ctx.ID().getText();
        }

        PrimitiveType arrayType = ctx.arrayInitializer().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType expectedType = PrimitiveType.getByKeyword(ctx.type().getText());
        if(arrayType == null || (!arrayType.equals(expectedType) && !arrayType.widensTo(expectedType))) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly initialized: type mismatch expected "+expectedType+" found "+arrayType);
            return "ARRAY_INITIALIZER_TYPE_MISMATCH_" + ctx.ID().getText();
        }

        System.out.println("Warning: ArrayValueInitialization assumes each array initializer expression pushes exactly one value onto the stack.");
        // auto widens using visitArrayInitializer();
        return ASMUtil.generateComment("Array value initialization "+ctx.getText()) + visit(ctx.arrayInitializer()) + " push [" + ctx.arrayInitializer().exprList().expression().size() + "] combine " + ASMUtil.generateStoreAddress(getCurrentScope().declareArray(ctx.ID().getText(), expectedType, ctx.arrayInitializer().exprList().expression().size()));//" push [" + getCurrentScope().declareArray(ctx.ID().getText(), expectedType, ctx.arrayInitializer().exprList().expression().size()) + "] put";
    }

    // this is how we auto widen array initializers
    @Override
    public String visitArrayInitializer(UISCParser.ArrayInitializerContext ctx) {
        if(!(ctx.getParent() instanceof UISCParser.ArrayValueInitializationContext)) {
            System.out.println("Array Initializer is not part of array value initialization!");
            return "ARRAY_INITIALIZER_NOT_EXPECTED_ERROR";
        }
        UISCParser.ArrayValueInitializationContext parent = (UISCParser.ArrayValueInitializationContext) ctx.getParent();

        PrimitiveType castToType = PrimitiveType.getByKeyword(parent.type().getText());
        StringBuilder arrayInitializerAsm = new StringBuilder();

        for (UISCParser.ExpressionContext expressionContext : ctx.exprList().expression()) {
            PrimitiveType type = expressionContext.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            arrayInitializerAsm.append(visit(expressionContext)).append(" ").append(generateCastAssembly(type, castToType)).append(" ");
        }

        return ASMUtil.generateComment("Array initialization "+ctx.getText()) + arrayInitializerAsm.toString();
    }

    @Override
    public String visitStructDeclaration(UISCParser.StructDeclarationContext ctx) {
        ArrayList<NameAndType> Params = new ArrayList<>();

        for (UISCParser.VarDeclarationContext varDeclarationContext : ctx.varDeclaration()) {
            if(varDeclarationContext instanceof UISCParser.VarInitializationContext) {
                UISCParser.VarInitializationContext structField = (UISCParser.VarInitializationContext) varDeclarationContext;
                Params.add(new NameAndType(structField.ID().getText(), PrimitiveType.getByKeyword(structField.type().getText())));
            } else {
                throw new UnsupportedOperationException("Arrays in struct not yet supported.");
            }
        }

        getCurrentScope().defineStruct(ctx.ID().getText(), Params);
        return "";
    }

    @Override
    public String visitFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx) {
        System.out.println(">>Defined function " + ctx.type().getText() + " " + ctx.ID().getText() + " " + ctx.formalParameters().toStringTree().replaceAll("\\[(.*?)\\]", "").replace("(", "").replace(")", ""));

        PrimitiveType fxnType = PrimitiveType.getByKeyword(ctx.type().getText());

        if(!fxnType.equals(PrimitiveType.Void)) {
            Boolean doAllPathsReturn = ctx.block().accept(new ASMGenAllPathsReturnVisitor());
            if(doAllPathsReturn == null || !doAllPathsReturn){
                System.out.println("Not all paths return a value in a non void function! "+ctx.ID().getText());
                return "NOT_ALL_PATHS_RETURN_NONVOID_FUNCTION";
            }
        }

        ArrayList<NameAndType> Parameters = new ArrayList<>();

        for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
            Parameters.add(new NameAndType(formalParameterContext.ID().getText(), PrimitiveType.getByKeyword(formalParameterContext.type().getText())));
        }

        PushFunctionScope(fxnType, ctx.ID().getText(), Parameters);

        for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
            getCurrentScope().declareSymbol(formalParameterContext.ID().getText(), PrimitiveType.getByKeyword(formalParameterContext.type().getText()));
        }

        String functionCode = visit(ctx.block());
        //int NumberOfParameters = getCurrentScope().size(); // we capture all for now so we dont have to deal with ScopeCapture
        int FunctionAddress = ((ScopeWithSymbol) getCurrentScope().findScopeContaining(ctx.ID().getText()).getSymbol(ctx.ID().getText())).Symbol.address;

        PopLocalScope();
        return ASMUtil.generateComment("Function declaration "+ctx.ID().getText()) + "(*) { " + functionCode + "} swap drop "+ASMUtil.generateStoreAddress(FunctionAddress);//push [" + FunctionAddress + "] put";
    }


}
