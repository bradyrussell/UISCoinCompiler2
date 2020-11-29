package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;
import com.bradyrussell.uiscoin.ide.symboltable.*;
import org.antlr.v4.runtime.tree.RuleNode;

public class ASMGenPrimitiveTypeVisitor extends ASMGenSubVisitorBase<PrimitiveType> {
    public ASMGenPrimitiveTypeVisitor(ScopeGlobal global, ScopeLocal currentLocalScope) {
        super(global, currentLocalScope);
    }

    @Override
    public PrimitiveType visitChildren(RuleNode node) {
        PrimitiveType type = super.visitChildren(node);
        if(type == null){
            System.out.println("[TypeChecker] Type visitor returned null! Cannot determine type for: "+node.getText());
        }
        return type;
    }

    @Override
    protected PrimitiveType defaultResult() {
        return null;
    }

    @Override
    protected PrimitiveType aggregateResult(PrimitiveType aggregate, PrimitiveType nextResult) {
        if(aggregate == null && nextResult != null) return nextResult;
        if(nextResult == null) return null;
        return PrimitiveType.getWiderType(aggregate, nextResult);
    }

    public static PrimitiveType deduceTypeOfNumber(String NumberString){
        try {
            //noinspection ResultOfMethodCallIgnored
            Byte.parseByte(NumberString);
            return PrimitiveType.Byte;
        } catch (Exception e) {
            try {
                Integer.parseInt(NumberString);
                return PrimitiveType.Int32;
            } catch (Exception e2) {
                try {
                    Long.parseLong(NumberString);
                    return PrimitiveType.Int64;
                } catch (Exception e3) {
                    try {
                        Float.parseFloat(NumberString);
                        return PrimitiveType.Float;
                    } catch (Exception e4) {
                        System.out.println("Cannot deduce type of number: "+NumberString);
                        return null;
                    }
                }
            }
        }
    }

    private PrimitiveType getCastedBinaryExpression(UISCParser.ExpressionContext LHS, UISCParser.ExpressionContext RHS){
        //Type lhsType = LHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        //Type rhsType = RHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        PrimitiveType lhsType = visit(LHS);
        PrimitiveType rhsType = visit(RHS);

        if(lhsType == null || rhsType == null) {
            System.out.println("Type null! Cannot determine type: " + lhsType + " and " + rhsType);
            return null;
        }

        return PrimitiveType.getWiderType(lhsType, rhsType);
    }

/*    @Override
    public Type visitVarInitialization(UISCParser.VarInitializationContext ctx) {
        return ctx.pointer() != null ? Type.getByKeyword(ctx.type().getText()).toPointer() : Type.getByKeyword(ctx.type().getText());
    }*/

    @Override
    public PrimitiveType visitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined variable: "+ctx.ID().getText());
            return null;
        }

        Object uncastedSymbol = scopeContaining.getSymbol(ctx.ID().getText());
        if(uncastedSymbol instanceof TypedValue) {
            return ((TypedValue)uncastedSymbol).type;
        }

        SymbolBase symbol = (SymbolBase) uncastedSymbol;
        if(symbol == null) {
            System.out.println("Cannot deduce type of function as variable: "+ctx.ID().getText());
            return null;
        }
        return symbol.type;
    }

    @Override
    public PrimitiveType visitBooleanLiteral(UISCParser.BooleanLiteralContext ctx) {
        return ctx.getText().equals("null") ? PrimitiveType.Void : PrimitiveType.Byte;
    }

    @Override
    public PrimitiveType visitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx) {
        return deduceTypeOfNumber(ctx.number().getText());
    }

    @Override
    public PrimitiveType visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        return PrimitiveType.Byte; // byte array
    }

    @Override
    public PrimitiveType visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        return PrimitiveType.Byte;
    }

    @Override
    public PrimitiveType visitArrayInitializer(UISCParser.ArrayInitializerContext ctx) {
        PrimitiveType lastType = null;
        for (UISCParser.ExpressionContext expressionContext : ctx.exprList().expression()) {
            if(lastType == null) {
                lastType = visit(expressionContext);
            } else {
                lastType = PrimitiveType.getWiderType(lastType, visit(expressionContext));
            }
        }
        return lastType;
    }

    @Override
    public PrimitiveType visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined function: "+ctx.ID().getText());
            return null;
        }
        ScopeWithSymbol symbol = (ScopeWithSymbol) scopeContaining.getSymbol(ctx.ID().getText());
        if(symbol == null) {
            System.out.println("Cannot deduce type of variable as function: "+ctx.ID().getText());
            return null;
        }
        return symbol.Symbol.type;
    }

    @Override
    public PrimitiveType visitModuloExpression(UISCParser.ModuloExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitAndOrExpression(UISCParser.AndOrExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitMultDivExpression(UISCParser.MultDivExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitAddSubExpression(UISCParser.AddSubExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitEqualityExpression(UISCParser.EqualityExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public PrimitiveType visitTernaryExpression(UISCParser.TernaryExpressionContext ctx) {
        PrimitiveType commonType = getCastedBinaryExpression(ctx.iftrue, ctx.iffalse);
        if(commonType == null){
            System.out.println("Warning: Cannot find common type for ternary expression, returning void pointer. "+ctx.toString());
            return PrimitiveType.VoidPointer;
        }
        return commonType;
    }

    @Override
    public PrimitiveType visitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined variable: "+ctx.ID().getText());
            return null;
        }

        Object uncasted = scopeContaining.getSymbol(ctx.ID().getText());

        if(uncasted instanceof ScopeWithSymbol) { // address of function
            return PrimitiveType.VoidPointer; // function ptr
        } else {
            SymbolBase symbol = (SymbolBase)uncasted;
            return  symbol.type.toPointer();
        }
    }

    @Override
    public PrimitiveType visitCastExpression(UISCParser.CastExpressionContext ctx) {
        return PrimitiveType.getByKeyword(ctx.type().getText());
    }

    @Override
    public PrimitiveType visitParenExpression(UISCParser.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public PrimitiveType visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx) {
        return PrimitiveType.Int32; // todo check what type LEN returns
    }

    @Override
    public PrimitiveType visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        // this is always r value
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not defined in this scope.");
            return null;
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.getSymbol(ctx.ID().getText());

        if (symbol == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly defined in this scope.");
            return null;
        }

        return symbol.type;
    }

    @Override
    public PrimitiveType visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx) {
        PrimitiveType sizeOfType = PrimitiveType.getByKeyword(ctx.type().getText());
        if (sizeOfType == null) return null;
        return deduceTypeOfNumber(""+sizeOfType.getSize());
    }

    @Override
    public PrimitiveType visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        PrimitiveType pointedType = visit(ctx.expression());
        if(pointedType == null) {
            System.out.println("Warning: Cannot find type for valueAt, returning void. "+ctx.toString());
            return PrimitiveType.Void;
        }
        return pointedType.fromPointer();
    }

    @Override
    public PrimitiveType visitStructFieldReferenceExpression(UISCParser.StructFieldReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.structField().structname.getText());
        if (scopeContaining == null) {
            System.out.println("Struct " + ctx.structField().structname.getText() + " was not defined in this scope.");
            return null;
        }

        SymbolStruct symbol = (SymbolStruct) scopeContaining.getSymbol(ctx.structField().structname.getText());

        if (symbol == null) {
            System.out.println("Struct " + ctx.structField().structname.getText() + " was not properly defined in this scope.");
            return null;
        }

        return symbol.struct.getFieldType(ctx.structField().fieldname.getText());
    }
}
