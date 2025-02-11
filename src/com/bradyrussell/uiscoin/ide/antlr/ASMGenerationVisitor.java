package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.MagicBytes;
import com.bradyrussell.uiscoin.MagicNumbers;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveStructOrArrayType;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;
import com.bradyrussell.uiscoin.ide.symboltable.*;
import org.antlr.v4.runtime.RuleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.bradyrussell.uiscoin.ide.antlr.ASMUtil.generateCastAssembly;

public class ASMGenerationVisitor extends UISCBaseVisitor<String> {
    HashMap<String, Integer> nativeFunctionCallParameters = new HashMap<>();

    ////////////////////////

    int LabelIndex = 0;

    public ScopeGlobal Global = new ScopeGlobal("GlobalScope", null);
    public ScopeLocal CurrentLocalScope = null;

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


    public ASMGenerationVisitor() {
        nativeFunctionCallParameters.put("set", 4); // location, position, length, value
        nativeFunctionCallParameters.put("get", 3); // location, position, length
        nativeFunctionCallParameters.put("copy", 5); // sourceLocation, sourcePosition, destinationLocation, destinationPosition, length
        nativeFunctionCallParameters.put("encrypt", 2);
        nativeFunctionCallParameters.put("decrypt", 2);
        nativeFunctionCallParameters.put("verifySig", 2);
        nativeFunctionCallParameters.put("alloc", 2); // location, size
        nativeFunctionCallParameters.put("zip", 1);
        nativeFunctionCallParameters.put("unzip", 1);
        nativeFunctionCallParameters.put("sha512", 1);
        nativeFunctionCallParameters.put("instruction", 0);
    }

    private String getNextLabel(){
        return "L"+LabelIndex++;
    }

    //todo Literal calculation visitor? like 2+5+2 would just return 9? or just add to the visitor if both are literals return the calc'd value
    /*
    could make a LiteralCalculatorVisitor<TypedValue> that implements +, -, *, etc
     for only literals returns null on expressions etc then everything here tries to run it before doing its calculations
     that way stuff like 5 * 5 would generate 25 in the asm or true & false
     */

    private static String stripQuotesFromString(String QuotedString) {
        return QuotedString.substring(1, QuotedString.length() - 1);
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
        return ASMUtil.generatePushNumberLiteralCast(ctx.number().getText(), null);
        //PrimitiveType typeOfInteger = PrimitiveType.deduceTypeOfNumber(ctx.number().getText());
        //return ASMUtil.generateComment(typeOfInteger+ " literal "+ctx.getText()) + "push " + (PrimitiveType.Byte.equals(typeOfInteger) ? "[":"") + ctx.number().getText()+ (PrimitiveType.Byte.equals(typeOfInteger) ? "]":"");
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
        PrimitiveType byKeyword = PrimitiveType.getByKeyword(ctx.type().getText());

        if(byKeyword == null || !PrimitiveType.ByteArray.equals(byKeyword.toArray())) {
            System.out.println("Cannot string initialize "+byKeyword+" array! " + ctx.ID().getText());
            return "TYPE_MISMATCH_" + ctx.ID().getText();
        }

        String strValue = stripQuotesFromString(ctx.STRING().getText());
        int address = getCurrentScope().declareArray(ctx.ID().getText(), byKeyword.toArray(), strValue.length());

        if (address < 0) {
            System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
            return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
        }

        return ASMUtil.generateComment("Array string initialization "+ctx.getText()) + " push \"" + strValue + "\"" + ASMUtil.generateStoreAddress(address)/*" push [" + address + "] put"*/;
    }

    @Override
    public String visitArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx) {
        if(ctx.type().primitiveType() == null){

            StructDefinition structDefinition = getCurrentScope().findStructDefinition(ctx.type().structType().getText());

            if(structDefinition == null){
                throw new UnsupportedOperationException("Struct type "+ctx.type().structType().getText()+" was not defined in this scope.");
            }

            int address = getCurrentScope().declareArray(ctx.ID().getText(), null, Integer.parseInt(ctx.INT().getText()));

            if (address < 0) {
                System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
            }

            if(ctx.expression() != null) {
                throw new UnsupportedOperationException("Value initializing struct arrays is not supported;");
                /*PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
                if(!symbolType.equals(expressionType)) {
                    System.out.println("Cannot initialize "+symbolType+" array with "+expressionType+"! " + ctx.ID().getText());
                    return "TYPE_MISMATCH_" + ctx.ID().getText();
                }

                return visit(ctx.expression()) +" "+ASMUtil.generateStoreAddress(address);*/
            }

            return ASMUtil.generatePushNumberLiteralCast(Integer.toString(structDefinition.getSize() * Integer.parseInt(ctx.INT().getText())), PrimitiveType.Int32)+" alloc "+ASMUtil.generateStoreAddress(address);//"push ["+address+"] put";
        }

        PrimitiveType symbolType = ctx.type().pointer() == null ? PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()) : PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()).toPointer();

        if(symbolType == null){
            throw new UnsupportedOperationException("Struct array assignment not yet implemented");
        }

        int address = getCurrentScope().declareArray(ctx.ID().getText(), symbolType,Integer.parseInt(ctx.INT().getText()));

        if (address < 0) {
            System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
            return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
        }

        if(ctx.expression() != null) {
            PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            if(!symbolType.equals(expressionType)) {
                System.out.println("Cannot initialize "+symbolType+" array with "+expressionType+"! " + ctx.ID().getText());
                return "TYPE_MISMATCH_" + ctx.ID().getText();
            }

            return visit(ctx.expression()) +" "+ASMUtil.generateStoreAddress(address);
        }

        return ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbolType.getSize() * Integer.parseInt(ctx.INT().getText())),PrimitiveType.Int32)+" alloc "+ASMUtil.generateStoreAddress(address);//"push ["+address+"] put";
    }

    @Override
    public String visitVarInitialization(UISCParser.VarInitializationContext ctx) {

        if(ctx.type().primitiveType() != null){
            PrimitiveType primitiveType = ctx.type().pointer() == null ? PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()) : PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()).toPointer();

            if(ctx.constant == null) {
                int address = getCurrentScope().declareSymbol(ctx.ID().getText(), primitiveType);

                if (address < 0) {
                    System.out.println("Symbol was already defined in this scope! " + ctx.ID().getText());
                    return "SYMBOL_REDEFINITION_" + ctx.ID().getText();
                }

                System.out.println(">>Initialized symbol " + ctx.ID().getText() + " of type " + primitiveType + " with address " + address);

                if (ctx.expression() != null) {
                    PrimitiveType rhsType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

                    if(rhsType == null) throw new UnsupportedOperationException("Could not determine the type of: "+ctx.expression().getText());

                    boolean bShouldWiden = false;

                    if (!primitiveType.equals(rhsType)) {
                        if (rhsType.widensTo(primitiveType)) {
                            bShouldWiden = true;
                        } else {
                            System.out.println("Type mismatch! Expected " + primitiveType + " found " + rhsType);
                            return "TYPE_MISMATCH_EXPECTED_" + primitiveType + "_FOUND_" + rhsType;
                        }
                    }

                    return visit(ctx.expression()) + (bShouldWiden ? " " + generateCastAssembly(rhsType, primitiveType) : "") + ASMUtil.generateStoreAddress(address);
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
                            constantValue = new TypedValue(primitiveType,Long.parseLong(expression.number().INT().getText()));
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

        if(ctx.type().structType() != null){
            if(ctx.type().pointer() != null) {
                throw new UnsupportedOperationException("Struct pointers are not yet implemented.");
            }

            int address = getCurrentScope().declareStruct(ctx.ID().getText(),ctx.type().structType().getText());

            if (address < 0) {
                System.out.println("Struct symbol was already defined in this scope! " + ctx.ID().getText());
                return "STRUCT_SYMBOL_REDEFINITION_" + ctx.ID().getText();
            }

            if(ctx.expression() != null) {
                throw new UnsupportedOperationException("Assigning struct values on initialization is not yet supported.");
            }

            System.out.println(">>Initialized struct symbol " + ctx.ID().getText() + " of type " + ctx.type().structType().getText() + " with address " + address);
            return getCurrentScope().findStructDefinition(ctx.type().getText()).generateAllocatorASM() + ASMUtil.generateStoreAddress(address);
        }

        throw new UnsupportedOperationException("Invalid variable initialization: "+ctx.getText());
    }

    /** End Initialization */


    @Override
    public String visitFunctionCallStatement(UISCParser.FunctionCallStatementContext ctx) {
        if(ctx.expression() instanceof UISCParser.FunctionCallExpressionContext) {
            UISCParser.FunctionCallExpressionContext call = (UISCParser.FunctionCallExpressionContext) ctx.expression();
            ScopeBase scopeContaining = getCurrentScope().findScopeContaining(call.ID().getText());
            if (scopeContaining == null) {
                System.out.println("Function " + call.ID().getText() + " was not defined in this scope.");
                return "FUNCTION_NOT_DEFINED_" + call.ID().getText();
            }

            ScopeWithSymbol functionSymbol = (ScopeWithSymbol) scopeContaining.getSymbol(call.ID().getText());

            if (functionSymbol == null) {
                System.out.println("Function " + call.ID().getText() + " was not properly defined in this scope.");
                return "FUNCTION_NOT_PROPERLY_DEFINED_" + call.ID().getText();
            }

            if(functionSymbol.Symbol.type.equals(PrimitiveType.Void)) {
                return visit(ctx.expression()); // this function call doesnt return a value
            }
            System.out.println("Warning: Result of function call on line "+ctx.start.getLine()+" is ignored.");
            return visit(ctx.expression()) + " drop"; // this function call doesnt use the retval, drop it. like:  add(1,2);
        }

        if(ctx.expression() instanceof UISCParser.NativeCallExpressionContext) {
            UISCParser.NativeCallExpressionContext call = (UISCParser.NativeCallExpressionContext) ctx.expression();
            PrimitiveType nativeCallType = call.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
            if(PrimitiveType.Void.equals(nativeCallType)) {
                return visit(ctx.expression()); // this function call doesnt return a value
            }
            System.out.println("Warning: Result of function call on line "+ctx.start.getLine()+" is ignored.");
            return visit(ctx.expression()) + " drop"; // this function call doesnt use the retval, drop it. like:  add(1,2);
        }

        if(ctx.expression() instanceof UISCParser.PostfixOpExpressionContext || ctx.expression() instanceof UISCParser.PrefixOpExpressionContext) {
            return super.visitFunctionCallStatement(ctx) + " drop"; // this call doesnt use the retval, drop it.
        }

        System.out.println("Warning: Removing unused statement: "+ctx.expression().getText());
        return ASMUtil.generateComment("UNUSED_STATEMENT_"+ctx.expression().getText()); // this is an unexpected expression that does nothing like: 1 + 2;
    }

    /**
     * Begin Statements
     */



    @Override
    public String visitTryCatchStatement(UISCParser.TryCatchStatementContext ctx) {
        StringBuilder tryCatchAsm = new StringBuilder();

        // maybe record depth here so we can drop back to that depth?
        // put inside a virtualscript so returns are caught
        // execute and jumpif over the catch block if returned true

       // ScopeCapture captureScope = PushLocalScopeCapture("TryStatement");

        //depth push {fxn} call verify

        PushLocalScope("TryStatement");

        if(ctx.catchStatement() == null) {
            // try without catch. just ignores returns
            tryCatchAsm.append(" depth "+ASMUtil.generatePushASMString(visit(ctx.tryStatement()))+" call drop ");
        } else {
            String endLabel = getNextLabel();
            tryCatchAsm.append(" depth "+ASMUtil.generatePushASMString(visit(ctx.tryStatement()))+" call gotoif "+endLabel);
            tryCatchAsm.append(visit(ctx.catchStatement())); // catch block
            tryCatchAsm.append(" :"+endLabel);
        }

        PopLocalScope();

      //  return ASMUtil.generateComment("Try statement ") + captureScope.generateCaptureASM() + tryCatchAsm.toString();


/*        if(ctx.catchStatement() != null){
            PushLocalScope("CatchStatement");

            PopLocalScope();
        } else {
            // clean up exceptions?
        }
        /// drop back to that depth?*/

        return tryCatchAsm.toString();
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

            if(ctx.lhs_struct.structArrayIndex != null) throw new UnsupportedOperationException("you have an array of structs??? ");

            if(symbol.struct == null) {
                throw new UnsupportedOperationException("Struct $"+symbol.address+" "+ctx.lhs_struct.structname.getText()+" symbol is null");
            }

            PrimitiveStructOrArrayType structField = symbol.struct.getFieldType(ctx.lhs_struct.fieldname.getText());

            if(structField.isStruct()) {
                throw new UnsupportedOperationException("Struct as member of struct not yet implemented");
            }

            if(structField.PrimitiveType == null){
                System.out.println("Undefined field " + ctx.lhs_struct.structname.getText() + "." + ctx.lhs_struct.fieldname.getText());
                return "FIELD_NOT_DEFINED_"+ ctx.lhs_struct.structname.getText() + "." +  ctx.lhs_struct.fieldname.getText();
            }

            PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

            boolean bShouldWiden = false;

            if (!structField.PrimitiveType.equals(rhsType)) {
                if (rhsType.widensTo(structField.PrimitiveType)) {
                    bShouldWiden = true;
                } else {
                    System.out.println("Type mismatch! Expected " + structField.PrimitiveType + " found " + rhsType);
                    return "TYPE_MISMATCH_EXPECTED_" + structField.PrimitiveType + "_FOUND_" + rhsType + "_ERROR";
                }
            }

            if(ctx.lhs_struct.fieldArrayIndex != null) {
                if(!structField.isArray()) throw new UnsupportedOperationException("Struct field array access but struct field is not array! " + ctx.lhs_struct.toString());
                // value to set                                                                                                   struct base address                 struct field setter
                ///////////////////////////////////////////////////

                PrimitiveType indexType = ctx.lhs_struct.fieldArrayIndex.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

                PrimitiveStructOrArrayType fieldType = symbol.struct.getFieldType(ctx.lhs_struct.fieldname.getText());

                return visit(ctx.rhs) +
                        (bShouldWiden ? " " + generateCastAssembly(rhsType, fieldType.PrimitiveType) : " ") +
                        //"push "+symbol.address+" "+ // push stack element
                        ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.address), PrimitiveType.Int32)+//
                        visit(ctx.lhs_struct.fieldArrayIndex) +" "+
                        generateCastAssembly(indexType, PrimitiveType.Int32) +// push array index auto casted to int
                        (fieldType.PrimitiveType.getSize() == 1 ? "" : (ASMUtil.generatePushNumberLiteralCast(Integer.toString(fieldType.PrimitiveType.getSize()), PrimitiveType.Int32)+" multiply"))+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                        (symbol.struct.getFieldByteIndex(ctx.lhs_struct.fieldname.getText()) != 0 ? (ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.struct.getFieldByteIndex(ctx.lhs_struct.fieldname.getText())), PrimitiveType.Int32) + " add") : "") +    // add struct field offset
                        ASMUtil.generatePushNumberLiteralCast(Integer.toString(fieldType.PrimitiveType.getSize()), PrimitiveType.Int32)+
                        //" push "+fieldType.PrimitiveType.getSize()+
                        " set ";  // push sizeof

                //////////////////////////////////////////////////

            }

            if(structField.isPrimitive()) {
                // value to set                                                                                                                                                 struct base address                               struct field setter
                return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, structField.PrimitiveType) : "") + ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.address), PrimitiveType.Int32) + symbol.struct.generateFieldSetterASM(ctx.lhs_struct.fieldname.getText());
            }
            //todo struct as struct member

            throw new UnsupportedOperationException("Assign value to struct array member? "+ctx.getText());
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

        if(scopeContaining.getSymbol(ctx.lhs.getText()) instanceof SymbolStruct) {
            throw new UnsupportedOperationException("Assigning whole struct values not yet supported.");
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
            return ASMUtil.generateComment("Assignment statement "+ctx.getText()) + visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : " ") +
                    ASMUtil.generateStoreArrayElement(symbol.address, visit(ctx.arrayIndex) +" "+ generateCastAssembly(indexType, PrimitiveType.Int32), symbol.type.getSize());
/*            return ASMUtil.generateComment("Assignment statement "+ctx.getText()) + visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : " ") +
                    "push "+symbol.address+" "+ // push stack element
                    visit(ctx.arrayIndex) +" "+ generateCastAssembly(indexType, PrimitiveType.Int32) +// push array index auto casted to int
                    (symbol.type.getSize() == 1 ? "" : ("push "+ symbol.type.getSize()+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                            " multiply"))+
*//*
                    " push "+symbol.type.getSize()+ // multiply by sizeof to get beginIndex
                    " multiply "+*//*

                    " push "+symbol.type.getSize()+
                    " set ";  // push sizeof*/

           // return visit(ctx.rhs) + (bShouldWiden ? " " + generateCastAssembly(rhsType, symbol.type) : "") + " push " + symbol.address + " " + visit(ctx.arrayIndex) + " push " + /*sizeof type*/symbol.type.getSize() + " set";
        }
    }

    @Override
    public String visitOpAndAssignmentStatement(UISCParser.OpAndAssignmentStatementContext ctx) {
        String opAsm = null;

        switch (ctx.op.getText()) {
            case "+=" ->{
                opAsm = "add";
            }
            case "-=" ->{
                opAsm = "subtract";
            }
            case "*=" ->{
                opAsm = "multiply";
            }
            case "/=" ->{
                opAsm = "divide";
            }
            case "&=" ->{
                opAsm = "bitand";
            }
            case "|=" ->{
                opAsm = "bitor";
            }
            case "%=" ->{
                opAsm = "modulo";
            }
        }

        if(opAsm == null){
            throw new UnsupportedOperationException("Invalid operator: "+ctx.op.getText());
        }

        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.lhs.getText());

        if(scopeContaining == null){
            System.out.println("Undefined symbol " + ctx.lhs.getText());
            return "SYMBOL_NOT_DEFINED_" + ctx.lhs.getText();
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.lhs.getText());

        PrimitiveType rhsType = ctx.rhs.accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        if(rhsType != null && rhsType.widensTo(symbol.type)) {


            return symbol.generateGetSymbolASM() + " " + visit(ctx.rhs) + " " + opAsm + " "+ symbol.generateSetSymbolASM();
        } else {
            System.out.println("Type mismatch! Expected " + symbol.type + " found " + rhsType);
            return "TYPE_MISMATCH_EXPECTED_" + symbol.type + "_FOUND_" + rhsType + "_ERROR";
        }
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
                return ASMUtil.generateComment("Return statement "+ctx.getText()) + " "+visit(ctx.retval)+generateCastAssembly(returnedType,definedReturnType);
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

            if(!symbol.type.widensTo(varType)) {
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
//todo off by one to the right? dont think so anymore
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
        return ASMUtil.generateComment("Address Of variable "+ctx.getText()) + ASMUtil.generatePushNumberLiteralCast(Integer.toString(symbol.address),PrimitiveType.Int32);
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

        if(ctx.type().primitiveType() != null){
           PrimitiveType toType = ctx.type().pointer() == null ? PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()) : PrimitiveType.getByKeyword(ctx.type().primitiveType().getText()).toPointer();

            String castAssembly = generateCastAssembly(fromType, toType);

            if (castAssembly == null) {
                System.out.println("Type mismatch! Cannot cast from " + fromType + " to " + toType);
                return "CANNOT_CAST_FROM_" + fromType + "_TO_" + toType + "_ERROR";
            }

            return ASMUtil.generateComment("Cast "+ctx.getText()) + visit(ctx.expression()) + " " + castAssembly;
        }

        throw new UnsupportedOperationException("Cannot cast to type: "+ctx.type().getText());
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
            // todo this will throw off symbol array lengths, so uforeach wouldnt work. dont see how this can work unless the sizes are fixed. maybe use set 0, len*size instead? to force user to create new array long enough
            // yeah could be a void that takes a pointer to fill in
            return getCastedBinaryExpression(ctx.lhs,ctx.rhs,"append", "append");
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
    public String visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
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

        if(ctx.exprList() != null) {
            int numParamsProvided = ctx.exprList().expression().size();
            if (functionSymbol.Symbol.getNumberOfParameters() != numParamsProvided) {
                System.out.println("Function " + ctx.ID().getText() + " expects " + functionSymbol.Symbol.getNumberOfParameters() + " but only " + numParamsProvided + " were provided.");
                return "FUNCTION_INCORRECT_NUMBER_PARAMETERS_" + ctx.ID().getText() + "_EXPECTED_" + functionSymbol.Symbol.getNumberOfParameters() + "_FOUND_" + numParamsProvided;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(ctx.exprList() != null) {
            List<UISCParser.ExpressionContext> expression = ctx.exprList().expression();
            for (int i = 0; i < expression.size(); i++) {
                PrimitiveType providedType = expression.get(i).accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
                if (providedType.widensTo(functionSymbol.Symbol.getTypeOfParameter(i))) {
                    sb.append(ASMUtil.generateComment("Function parameter " + functionSymbol.Symbol.getNameOfParameter(i)));
                    sb.append(visit(expression.get(i))).append(" ").append(generateCastAssembly(providedType, functionSymbol.Symbol.getTypeOfParameter(i)));
                    sb.append(ASMUtil.generateStoreAddress(((Symbol) functionSymbol.getSymbol(functionSymbol.Symbol.getNameOfParameter(i))).getSymbolAddress()));
                } else {
                    System.out.println("Function " + ctx.ID().getText() + " expects " + functionSymbol.Symbol.getTypeOfParameter(i) + " for parameter " + functionSymbol.Symbol.getNameOfParameter(i) + " but " + providedType + " was provided.");
                    return "FUNCTION_INCORRECT_TYPE_PARAMETERS_" + ctx.ID().getText() + "_EXPECTED_" + functionSymbol.Symbol.getTypeOfParameter(i) + "_FOUND_" + providedType;
                }
            }
        }

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

        return ASMUtil.generateLoadArrayElement(symbol.address,visit(ctx.expression())+" "+ castAssembly,SizeOf);
/*        return ASMUtil.generateComment("Array access "+ctx.getText()) + "push "+symbol.address+" "+ // push stack element
                visit(ctx.expression())+" "+ castAssembly +// push array index auto casted to int
                (SizeOf == 1 ? "" : (" push "+SizeOf+ // multiply by sizeof to get beginIndex, unless SizeOf is 1
                " multiply"))+
                " push "+SizeOf+
                " get ";  // push sizeof*/
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

        return " push "+ symbol.address + symbol.struct.generateFieldGetterASM(ctx.structField().fieldname.getText());
    }

    @Override
    public String visitNativeCallExpression(UISCParser.NativeCallExpressionContext ctx) {
        if(!nativeFunctionCallParameters.containsKey(ctx.ID().getText())) throw new UnsupportedOperationException("Unknown native call: "+ctx.ID().getText());
        int ParamsExpected = nativeFunctionCallParameters.get(ctx.ID().getText());

        if(ParamsExpected != 0 && ctx.exprList().expression() == null) {
            return "NATIVE_CALL_"+ctx.ID().getText()+"_EXPECTED_"+ParamsExpected+"_PARAMETERS_FOUND_0";
        }

        if(((ctx.exprList() == null && ParamsExpected > 0)) || ctx.exprList() != null && ctx.exprList().expression().size() != ParamsExpected) {
            return "NATIVE_CALL_"+ctx.ID().getText()+"_EXPECTED_"+ParamsExpected+"_PARAMETERS_FOUND_"+ctx.exprList().expression().size();
        }

        switch (ctx.ID().getText()) {
            case "encrypt" ->{
                //push key //push message //encryptaes
                return visit(ctx.exprList().expression(1)) + " " + visit(ctx.exprList().expression(0)) + " encryptaes";
            }
            case "decrypt" ->{
                //push key //push message //decryptaes
                return visit(ctx.exprList().expression(1)) + " " + visit(ctx.exprList().expression(0)) + " decryptaes";
            }
            case "zip" ->{
                return visit(ctx.exprList().expression(0)) + " zip";
            }
            case "unzip" ->{
                return visit(ctx.exprList().expression(0)) + " unzip";
            }
            case "sha512" ->{
                return visit(ctx.exprList().expression(0)) + " sha512";
            }
            case "verifySig" ->{
                return visit(ctx.exprList().expression(0)) + " "  + visit(ctx.exprList().expression(1)) + " verifysig verify";
            }
            case "instruction"->{
                return " instruction";
            }
            case "copy"->{
                return visit(ctx.exprList().expression(0)) + " " + visit(ctx.exprList().expression(1)) + " " + visit(ctx.exprList().expression(2)) + " " + visit(ctx.exprList().expression(3)) + " " + visit(ctx.exprList().expression(4)) + " copy";
            }
            case "get"->{
                return visit(ctx.exprList().expression(0)) + " " + visit(ctx.exprList().expression(1)) + " " + visit(ctx.exprList().expression(2)) + " " + visit(ctx.exprList().expression(3)) + " get";
            }
            case "set"->{
                return visit(ctx.exprList().expression(0)) + " " + visit(ctx.exprList().expression(1)) + " " + visit(ctx.exprList().expression(2)) + " " + " set";
            }
        }
        throw new UnsupportedOperationException("No implementation for native call: "+ctx.ID().getText());
    }

    @Override
    public String visitPostfixOpExpression(UISCParser.PostfixOpExpressionContext ctx) {

        if(ctx.parent instanceof UISCParser.StatementContext) {
            throw new UnsupportedOperationException("Use prefix increment if you don't need postfix. "+ctx.getText());
        }

        PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));

        //++ doesnt make sense for anything but an id, array access, or struct member access
        if(ctx.expression() instanceof UISCParser.VariableReferenceExpressionContext) {
            String originalVariableName = ((UISCParser.VariableReferenceExpressionContext) ctx.expression()).ID().getText();
            int originalAddress = ((SymbolBase)getCurrentScope().findScopeContaining(originalVariableName).getSymbol(originalVariableName)).address;

            // dup x, add 1,  store to original address, (leaving original x on the stack)
            return visit(ctx.expression()) + " dup true "+generateCastAssembly(PrimitiveType.Byte,expressionType)+ (ctx.op.getText().equals("++") ? " add " : " subtract ") + ASMUtil.generateStoreAddress(originalAddress);
        }

        if(ctx.expression() instanceof UISCParser.ArrayAccessExpressionContext) {
            throw new UnsupportedOperationException("Postfix increment array access NYI");
        }

        if(ctx.expression() instanceof UISCParser.StructFieldReferenceExpressionContext) {
            throw new UnsupportedOperationException("Postfix increment struct field NYI");
        }

        throw new UnsupportedOperationException("Postfix increment is not supported in this context. "+ctx.getText());
       // throw new UnsupportedOperationException("Postfix operator not yet implemented");
        // return super.visitPostfixOpExpression(ctx);
    }

    @Override
    public String visitPrefixOpExpression(UISCParser.PrefixOpExpressionContext ctx) {
        PrimitiveType expressionType = ctx.expression().accept(new ASMGenPrimitiveTypeVisitor(Global, CurrentLocalScope));
        if(!expressionType.isNumeric()) throw new UnsupportedOperationException("Cannot "+ctx.op+" non-numeric expression "+ctx.expression().getText());

        // for a var ref, array access or struct member we need to store the result
        if(ctx.expression() instanceof UISCParser.VariableReferenceExpressionContext) {
            String originalVariableName = ((UISCParser.VariableReferenceExpressionContext) ctx.expression()).ID().getText();
            int originalAddress = ((SymbolBase)getCurrentScope().findScopeContaining(originalVariableName).getSymbol(originalVariableName)).address;

            return visit(ctx.expression()) + " true " + generateCastAssembly(PrimitiveType.Byte, expressionType) + (ctx.op.getText().equals("--") ? "subtract ":"add ") + "dup "+ASMUtil.generateStoreAddress(originalAddress);
        }

        if(ctx.expression() instanceof UISCParser.ArrayAccessExpressionContext) {
            throw new UnsupportedOperationException("Prefix increment array access NYI");
        }

        if(ctx.expression() instanceof UISCParser.StructFieldReferenceExpressionContext) {
            throw new UnsupportedOperationException("Prefix increment struct field NYI");
        }
        // otherwise we just add to it
        return visit(ctx.expression()) + " true " + generateCastAssembly(PrimitiveType.Byte, expressionType) + (ctx.op.getText().equals("--") ? "subtract ":"add ");
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
        return ASMUtil.generateComment("Array value initialization "+ctx.getText()) + visit(ctx.arrayInitializer()) +
                " push [" + ctx.arrayInitializer().exprList().expression().size() + "] combine " +
                ASMUtil.generateStoreAddress(getCurrentScope().declareArray(ctx.ID().getText(), expectedType, ctx.arrayInitializer().exprList().expression().size()));//" push [" + getCurrentScope().declareArray(ctx.ID().getText(), expectedType, ctx.arrayInitializer().exprList().expression().size()) + "] put";
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

                if(structField.constant != null) {
                    throw new UnsupportedOperationException("Constants are not allowed in structs (yet?)");
                }

                if(structField.type().primitiveType() == null) {
                    throw new UnsupportedOperationException("Nested structs are not currently supported");
                }

                Params.add(new NameAndType(structField.ID().getText(), new PrimitiveStructOrArrayType(structField.type().pointer() == null ? PrimitiveType.getByKeyword(structField.type().primitiveType().getText()) : PrimitiveType.getByKeyword(structField.type().primitiveType().getText()).toPointer())));
            } else if(varDeclarationContext instanceof UISCParser.ArrayAssignmentInitializationContext) {
                UISCParser.ArrayAssignmentInitializationContext structField = (UISCParser.ArrayAssignmentInitializationContext) varDeclarationContext;

                if(structField.expression() != null) {
                    throw new UnsupportedOperationException("That is not allowed right now");
                }

                if(structField.type().primitiveType() == null) {
                    throw new UnsupportedOperationException("Nested structs are not currently supported");
                }

                PrimitiveStructOrArrayType type = new PrimitiveStructOrArrayType(structField.type().pointer() == null ? PrimitiveType.getByKeyword(structField.type().primitiveType().getText()) : PrimitiveType.getByKeyword(structField.type().primitiveType().getText()).toPointer(), Integer.parseInt(structField.size.getText()));
                Params.add(new NameAndType(structField.ID().getText(), type));
            }
        }

        getCurrentScope().defineStruct(ctx.ID().getText(), Params);
        return "";
    }

    @Override
    public String visitFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx) {
        System.out.println(">>Defined function " + ctx.type().getText() + " " + ctx.ID().getText() + " " + (ctx.formalParameters() == null ? "":ctx.formalParameters().toStringTree().replaceAll("\\[(.*?)\\]", "").replace("(", "").replace(")", "")));

        PrimitiveType fxnType = PrimitiveType.getByKeyword(ctx.type().getText());

        if(fxnType == null){
            throw new UnsupportedOperationException("Struct functions are not yet supported.");
        }

        if(ctx.block() == null) {
            System.out.println("No code block was found for the function: "+ctx.ID().getText());
            return "NO_BLOCK_SPECIFIED_IN_FUNCTION";
        }

        if(!fxnType.equals(PrimitiveType.Void)) {
            Boolean doAllPathsReturn = ctx.block().accept(new ASMGenAllPathsReturnVisitor());
            if(doAllPathsReturn == null || !doAllPathsReturn){
                System.out.println("Not all paths return a value in a non void function! "+ctx.ID().getText());
                return "NOT_ALL_PATHS_RETURN_NONVOID_FUNCTION";
            }
        }

        ArrayList<NameAndType> Parameters = new ArrayList<>();

        if(ctx.formalParameters() != null) {
            for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
                Parameters.add(new NameAndType(formalParameterContext.ID().getText(), new PrimitiveStructOrArrayType(PrimitiveType.getByKeyword(formalParameterContext.type().getText()))));
            }
        }

        PushFunctionScope(fxnType, ctx.ID().getText(), Parameters);

        if(ctx.formalParameters() != null) {
            for (UISCParser.FormalParameterContext formalParameterContext : ctx.formalParameters().formalParameter()) {
                getCurrentScope().declareSymbol(formalParameterContext.ID().getText(), PrimitiveType.getByKeyword(formalParameterContext.type().getText()));
            }
        }

        String functionCode = visit(ctx.block());
        //int NumberOfParameters = getCurrentScope().size(); // we capture all for now so we dont have to deal with ScopeCapture
        int FunctionAddress = ((ScopeWithSymbol) getCurrentScope().findScopeContaining(ctx.ID().getText()).getSymbol(ctx.ID().getText())).Symbol.address;

        PopLocalScope();
        return ASMUtil.generateComment("Function declaration "+ctx.ID().getText()) + "push { " + functionCode + "} "+ASMUtil.generateStoreAddress(FunctionAddress);//push [" + FunctionAddress + "] put";
    }


}
