package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.ide.grammar.Type;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;
import com.bradyrussell.uiscoin.ide.symboltable.*;

import java.util.ArrayList;

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


    void PushFunctionScope(Type FunctionType, String FunctionName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = Global.defineFunction(FunctionName, FunctionType);
        } else {
            CurrentLocalScope = CurrentLocalScope.defineFunction(FunctionName, FunctionType);
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
    private static String generateCastAssembly(Type From, Type To) {
        if (From.equals(To)) return " ";

        StringBuilder asm = new StringBuilder();

        if (From.equals(Type.Byte)) {
            if (To.getSize() > 1) { // int32 is the intermediate type
                asm.append("convert8to32 ");
                From = Type.Int32;
            }
        }

        if (From.equals(Type.Int64)) {
            // int32 is the intermediate type
            asm.append("convert64to32 ");
            From = Type.Int32;
        }

        if (From.equals(Type.Float)) {
            // int32 is the intermediate type
            asm.append("convertfloatto32 ");
            From = Type.Int32;
        }

        if (From.equals(Type.Int32)) {
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
        System.out.println("Cannot cast from "+From+" to "+To+"!");
        return null;
    }

    private String getCastedBinaryExpression(UISCParser.ExpressionContext LHS, UISCParser.ExpressionContext RHS, String BinaryOperationForIntegers, String BinaryOperationForFloats){
        Type lhsType = LHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        Type rhsType = RHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));

        if(lhsType == null || rhsType == null) {
            System.out.println("Type null! Cannot determine type: " + lhsType + " and " + rhsType);
            return "TYPE_NULL_" + lhsType + "_AND_" + rhsType + "_ERROR";
        }

        Type outputType = Type.getWiderType(lhsType, rhsType);

        if (outputType == null) {
            System.out.println("Type mismatch! Cannot combine types " + lhsType + " and " + rhsType);
            return "TYPE_MISMATCH_CANNOT_COMBINE_" + lhsType + "_AND_" + rhsType + "_ERROR";
        }

        return visit(LHS) + " " + generateCastAssembly(lhsType,outputType) + visit(RHS) + " "  + generateCastAssembly(rhsType,outputType) + (outputType.equals(Type.Float) ? BinaryOperationForFloats : BinaryOperationForIntegers) + " ";
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
        Type typeOfInteger = ASMGenTypeVisitor.deduceTypeOfNumber(ctx.number().getText());
        return "push " + (Type.Byte.equals(typeOfInteger) ? "[":"") + ctx.number().getText()+ (Type.Byte.equals(typeOfInteger) ? "]":"");
    }

    @Override
    public String visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        return "push " + ctx.STRING().getText();
    }

    @Override
    public String visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        return "push " + ctx.CHAR().getText().replace("'", "\"");
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
    public String visitVarInitialization(UISCParser.VarInitializationContext ctx) {
        Type symbolType = Type.getByKeyword(ctx.type().getText());

        if(ctx.constant == null) {
            int address = getCurrentScope().declareSymbol(ctx.ID().getText(), symbolType);

            if (address < 0) {
                System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
            }

            //int address = ((SymbolBase) getCurrentScope().symbolTable.get(ctx.ID().getText())).address;
            System.out.println(">>Initialized symbol " + ctx.ID().getText() + " of type " + symbolType + " with address " + address);

            if (ctx.expression() != null) {
                Type rhsType = ctx.expression().accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));

                boolean bShouldWiden = false;

                if (!symbolType.equals(rhsType)) {
                    if (rhsType.widensTo(symbolType)) {
                        bShouldWiden = true;
                    } else {
                        System.out.println("Type mismatch! Expected " + symbolType + " found " + rhsType);
                        return "TYPE_MISMATCH_EXPECTED_" + symbolType + "_FOUND_" + rhsType;
                    }
                }

                return visit(ctx.expression()) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbolType) : "") + " push [" + address + "] put";
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
                        constantValue = new TypedValue(Type.getByKeyword(ctx.type().getText()),Long.parseLong(expression.number().INT().getText()));
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
    public String visitAssignmentStatement(UISCParser.AssignmentStatementContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.lhs.getText());

        if(scopeContaining == null){
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }

        if(scopeContaining.symbolTable.get(ctx.lhs.getText()) instanceof TypedValue) {
            System.out.println("Assigning to constant " + ctx.ID().getText());
            return "ASSIGN_TO_CONSTANT_" + ctx.ID().getText();
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.symbolTable.get(ctx.lhs.getText());

        if (symbol == null) {
            System.out.println("Undefined symbol " + ctx.lhs.getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }

        Type rhsType = ctx.rhs.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));

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
            return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") + " push [" + symbol.address + "] put";
        } else {
            return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") + " push " + symbol.address + " " + visit(ctx.arrayIndex) + " push " + /*sizeof type*/symbol.type.getSize() + " set";
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

        return asm.toString();
    }

    @Override
    public String visitForiStatement(UISCParser.ForiStatementContext ctx) { // loop unrolling
        int Iterations = Integer.parseInt(ctx.iterations.getText());

        PushLocalScope("ForIStatement");


      //  int IteratorAddress = getCurrentScope().declareSymbol(ctx.ID().getText(), Type.getByKeyword(ctx.type().getText()));

        StringBuilder forIStatement = new StringBuilder();

        for (int i = 0; i < Iterations; i++) {
            PushLocalScope("ForIStatement_Inner_"+i);
            getCurrentScope().declareConstantInlineSymbol(ctx.ID().getText(), new TypedValue(Type.getByKeyword(ctx.type().getText()),i));
                // setup iterator variable // todo can we somehow inline the iterator variable?
                //forIStatement.append("push ").append(i).append(" ").append(generateCastAssembly(Type.Int32, Type.getByKeyword(ctx.type().getText()))).append(" push [").append(IteratorAddress).append("] put ");
           // forIStatement.append("push ").append(i).append(" ").append(generateCastAssembly(Type.Int32, Type.getByKeyword(ctx.type().getText()))).append(" push [").append(IteratorAddress).append("] put ");
                forIStatement.append(visit(ctx.forbody));
              //  forIStatement.append(getCurrentScope().getDeallocation()); //todo
            PopLocalScope();
        }

        PopLocalScope();

        return forIStatement.toString();
    }

    @Override
    public String visitForeachStatement(UISCParser.ForeachStatementContext ctx) { // loop unrolling
        return super.visitForeachStatement(ctx);
    }

    @Override
    public String visitAssertion(UISCParser.AssertionContext ctx) {
        return visit(ctx.expression())+" verify";
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
        return stripQuotesFromString(ctx.STRING().getText());
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

        Object uncastedSymbol = scopeContaining.symbolTable.get(ctx.ID().getText());

        if(uncastedSymbol instanceof TypedValue) {
            System.out.println("Cannot get the address of constant " + ctx.ID().getText());
            return "ADDRESS_OF_CONSTANT_" + ctx.ID().getText();
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;

        if (symbol == null) {
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }
        return "push " + symbol.address;
    }

    @Override
    public String visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx) { // this will return number of bytes in array, not number of elements. divide by sizeof
        return visit(ctx.expression()) + " len swap drop"; // this removes the value which we took the length of
    }

    @Override
    public String visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx) {
        Type sizeOfType = Type.getByKeyword(ctx.type().getText());
        if (sizeOfType == null) {
            System.out.println("Invalid type! Cannot determine size of invalid type " + ctx.type().getText());
            return "INVALID_TYPE_" + ctx.type().getText()+"_ERROR";
        }

        return "push ["+sizeOfType.getSize()+"]";
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
        return visit(ctx.condition) + " gotoif "+truelabel+" "+ visit(ctx.iffalse) + " goto "+falselabel+" :"+truelabel+" "+visit(ctx.iftrue)+" :"+falselabel;
    }


    @Override
    public String visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        return visit(ctx.expression())+" pick"; // todo see if this needs casted
    }

    @Override
    public String visitCastExpression(UISCParser.CastExpressionContext ctx) {
        Type fromType = ctx.expression().accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        Type toType = Type.getByKeyword(ctx.type().getText());
        String castAssembly = generateCastAssembly(fromType, toType);

        if (castAssembly == null) {
            System.out.println("Type mismatch! Cannot cast from " + fromType + " to " + toType);
            return "CANNOT_CAST_FROM_" + fromType + "_TO_" + toType + "_ERROR";
        }

        return visit(ctx.expression()) + " " + castAssembly;
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
        Type fromType = ctx.expression().accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));

        if(Type.Byte.equals(fromType)) {
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

        Object uncastedSymbol = scopeContaining.symbolTable.get(ctx.ID().getText());

        if(uncastedSymbol instanceof TypedValue) {
           return "push "+((TypedValue)uncastedSymbol);
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;

        if (symbol == null) {
            System.out.println("Undefined symbol " + ctx.ID().getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.ID().getText();
        }
        return "push [" + symbol.address + "] pick ";
    }

    @Override
    public String visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) { // todo typecheck
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Function " + ctx.ID().getText() + " was not defined in this scope.");
            return "FUNCTION_NOT_DEFINED_" + ctx.ID().getText();
        }

        ScopeWithSymbol functionSymbol = (ScopeWithSymbol) scopeContaining.symbolTable.get(ctx.ID().getText());

        if (functionSymbol == null) {
            System.out.println("Function " + ctx.ID().getText() + " was not properly defined in this scope.");
            return "FUNCTION_NOT_PROPERLY_DEFINED_" + ctx.ID().getText();
        }
        // todo check parameter types
        return visit(ctx.exprList()) + // params
                " push ["+ctx.exprList().expression().size()+"] "+ // number of parameters
                " push [" + functionSymbol.Symbol.address + "] pick"+ // get function bytecode
                " call verify"; // execute and ensure it did not fail
    }

    @Override
    public String visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        // this is always r value
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not defined in this scope.");
            return "ARRAY_NOT_DEFINED_" + ctx.ID().getText();
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.symbolTable.get(ctx.ID().getText());

        if (symbol == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly defined in this scope.");
            return "ARRAY_NOT_PROPERLY_DEFINED_" + ctx.ID().getText();
        }

        int SizeOf = symbol.type.getSize();

        Type indexExpressionType = ctx.expression().accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));

        String castAssembly = generateCastAssembly(indexExpressionType, Type.Int32);

        if(castAssembly == null) {
            System.out.println("Array " + ctx.ID().getText() + " access with unsupported type: "+indexExpressionType);
            return "ARRAY_INDEX_INVALID_TYPE_" + indexExpressionType;
        }

        return "push "+symbol.address+" "+ // push stack element
                visit(ctx.expression())+" "+ castAssembly +// push array index auto casted to int
                " push "+SizeOf+ // multiply by sizeof to get beginIndex
                " multiply push "+SizeOf+
                " get ";  // push sizeof
    }

    /**
     * End Expressions
     */


    @Override
    public String visitArrayValueInitialization(UISCParser.ArrayValueInitializationContext ctx) { // todo could be optimized into a single push. would that be smaller? // todo type check
        if (getCurrentScope().symbolTable.containsKey(ctx.ID().getText())) {
            System.out.println("Symbol " + ctx.ID().getText() + " was already defined in this scope!");
            return "ERROR_SYMBOL_REDEFINITION_" + ctx.ID().getText();
        }

        Type arrayType = ctx.arrayInitializer().accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        Type expectedType = Type.getByKeyword(ctx.type().getText());
        if(arrayType == null || (!arrayType.equals(expectedType) && !arrayType.widensTo(expectedType))) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly initialized: type mismatch expected "+expectedType+" found "+arrayType);
            return "ARRAY_INITIALIZER_TYPE_MISMATCH_" + ctx.ID().getText();
        }

        System.out.println("Warning: ArrayValueInitialization assumes each array initializer expression pushes exactly one value onto the stack.");
        // auto widens using visitArrayInitializer();
        return visit(ctx.arrayInitializer()) + " push [" + ctx.arrayInitializer().exprList().expression().size() + "] combine " + " push [" + getCurrentScope().declareSymbol(ctx.ID().getText(), expectedType) + "] put";
    }

    // this is how we auto widen array initializers
    @Override
    public String visitArrayInitializer(UISCParser.ArrayInitializerContext ctx) {
        if(!(ctx.getParent() instanceof UISCParser.ArrayValueInitializationContext)) {
            System.out.println("Array Initializer is not part of array value initialization!");
            return "ARRAY_INITIALIZER_NOT_EXPECTED_ERROR";
        }
        UISCParser.ArrayValueInitializationContext parent = (UISCParser.ArrayValueInitializationContext) ctx.getParent();

        Type castToType = Type.getByKeyword(parent.type().getText());
        StringBuilder arrayInitializerAsm = new StringBuilder();

        for (UISCParser.ExpressionContext expressionContext : ctx.exprList().expression()) {
            Type type = expressionContext.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
            arrayInitializerAsm.append(visit(expressionContext)).append(" ").append(generateCastAssembly(type, castToType)).append(" ");
        }

        return arrayInitializerAsm.toString();
    }

    @Override
    public String visitFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx) {
        System.out.println(">>Defined function " + ctx.type().getText() + " " + ctx.ID().getText() + " " + ctx.formalParameters().toStringTree().replaceAll("\\[(.*?)\\]", "").replace("(", "").replace(")", ""));

        PushFunctionScope(Type.getByKeyword(ctx.type().getText()), ctx.ID().getText());

        for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
            getCurrentScope().declareSymbol(formalParameterContext.ID().getText(), Type.getByKeyword(formalParameterContext.type().getText()));
        }

        String functionCode = visit(ctx.block());
        int NumberOfParameters = getCurrentScope().symbolTable.size();
        int FunctionAddress = ((ScopeWithSymbol) getCurrentScope().findScopeContaining(ctx.ID().getText()).symbolTable.get(ctx.ID().getText())).Symbol.address;

        PopLocalScope();
        return "(" + NumberOfParameters + ") { " + functionCode + "} push [" + FunctionAddress + "] put";
    }


}
