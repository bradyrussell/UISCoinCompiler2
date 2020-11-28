package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.ide.grammar.Type;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;
import com.bradyrussell.uiscoin.ide.symboltable.*;
import org.antlr.v4.runtime.tree.RuleNode;

public class ASMGenTypeVisitor extends ASMGenSubVisitorBase<Type> {
    public ASMGenTypeVisitor(ScopeGlobal global, ScopeLocal currentLocalScope) {
        super(global, currentLocalScope);
    }

    @Override
    public Type visitChildren(RuleNode node) {
        Type type = super.visitChildren(node);
        if(type == null){
            System.out.println("[TypeChecker] Type visitor returned null! Cannot determine type for: "+node.getText());
        }
        return type;
    }

    @Override
    protected Type defaultResult() {
        return null;
    }

    @Override
    protected Type aggregateResult(Type aggregate, Type nextResult) {
        if(aggregate == null && nextResult != null) return nextResult;
        if(nextResult == null) return null;
        return Type.getWiderType(aggregate, nextResult);
    }

    public static Type deduceTypeOfNumber(String NumberString){
        try {
            //noinspection ResultOfMethodCallIgnored
            Byte.parseByte(NumberString);
            return Type.Byte;
        } catch (Exception e) {
            try {
                Integer.parseInt(NumberString);
                return Type.Int32;
            } catch (Exception e2) {
                try {
                    Long.parseLong(NumberString);
                    return Type.Int64;
                } catch (Exception e3) {
                    try {
                        Float.parseFloat(NumberString);
                        return Type.Float;
                    } catch (Exception e4) {
                        System.out.println("Cannot deduce type of number: "+NumberString);
                        return null;
                    }
                }
            }
        }
    }

    private Type getCastedBinaryExpression(UISCParser.ExpressionContext LHS, UISCParser.ExpressionContext RHS){
        //Type lhsType = LHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        //Type rhsType = RHS.accept(new ASMGenTypeVisitor(Global, CurrentLocalScope));
        Type lhsType = visit(LHS);
        Type rhsType = visit(RHS);

        if(lhsType == null || rhsType == null) {
            System.out.println("Type null! Cannot determine type: " + lhsType + " and " + rhsType);
            return null;
        }

        return Type.getWiderType(lhsType, rhsType);
    }

/*    @Override
    public Type visitVarInitialization(UISCParser.VarInitializationContext ctx) {
        return ctx.pointer() != null ? Type.getByKeyword(ctx.type().getText()).toPointer() : Type.getByKeyword(ctx.type().getText());
    }*/

    @Override
    public Type visitVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined variable: "+ctx.ID().getText());
            return null;
        }

        Object uncastedSymbol = scopeContaining.symbolTable.get(ctx.ID().getText());
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
    public Type visitBooleanLiteral(UISCParser.BooleanLiteralContext ctx) {
        return Type.Byte;
    }

    @Override
    public Type visitNumberLiteralExpression(UISCParser.NumberLiteralExpressionContext ctx) {
        return deduceTypeOfNumber(ctx.number().getText());
    }

    @Override
    public Type visitStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        return Type.Byte; // byte array
    }

    @Override
    public Type visitCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        return Type.Byte;
    }

    @Override
    public Type visitArrayInitializer(UISCParser.ArrayInitializerContext ctx) {
        Type lastType = null;
        for (UISCParser.ExpressionContext expressionContext : ctx.exprList().expression()) {
            if(lastType == null) {
                lastType = visit(expressionContext);
            } else {
                lastType = Type.getWiderType(lastType, visit(expressionContext));
            }
        }
        return lastType;
    }

    @Override
    public Type visitFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined function: "+ctx.ID().getText());
            return null;
        }
        ScopeWithSymbol symbol = (ScopeWithSymbol) scopeContaining.symbolTable.get(ctx.ID().getText());
        if(symbol == null) {
            System.out.println("Cannot deduce type of variable as function: "+ctx.ID().getText());
            return null;
        }
        return symbol.Symbol.type;
    }

    @Override
    public Type visitModuloExpression(UISCParser.ModuloExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public Type visitAndOrExpression(UISCParser.AndOrExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public Type visitMultDivExpression(UISCParser.MultDivExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public Type visitAddSubExpression(UISCParser.AddSubExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public Type visitEqualityExpression(UISCParser.EqualityExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public Type visitBitwiseExpression(UISCParser.BitwiseExpressionContext ctx) {
        return getCastedBinaryExpression(ctx.lhs, ctx.rhs);
    }

    @Override
    public Type visitTernaryExpression(UISCParser.TernaryExpressionContext ctx) {
        Type commonType = getCastedBinaryExpression(ctx.iftrue, ctx.iffalse);
        if(commonType == null){
            System.out.println("Warning: Cannot find common type for ternary expression, returning void pointer. "+ctx.toString());
            return Type.VoidPointer;
        }
        return commonType;
    }

    @Override
    public Type visitAddressOfVariableExpression(UISCParser.AddressOfVariableExpressionContext ctx) {
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if(scopeContaining == null) {
            System.out.println("Cannot deduce type of undefined variable: "+ctx.ID().getText());
            return null;
        }

        Object uncasted = scopeContaining.symbolTable.get(ctx.ID().getText());

        if(uncasted instanceof ScopeWithSymbol) { // address of function
            return Type.VoidPointer; // function ptr
        } else {
            SymbolBase symbol = (SymbolBase)uncasted;
            return  symbol.type.toPointer();
        }
    }

    @Override
    public Type visitCastExpression(UISCParser.CastExpressionContext ctx) {
        return Type.getByKeyword(ctx.type().getText());
    }

    @Override
    public Type visitParenExpression(UISCParser.ParenExpressionContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Type visitLengthOfExpression(UISCParser.LengthOfExpressionContext ctx) {
        return Type.Int32; // todo check what type LEN returns
    }

    @Override
    public Type visitArrayAccessExpression(UISCParser.ArrayAccessExpressionContext ctx) {
        // this is always r value
        ScopeBase scopeContaining = getCurrentScope().findScopeContaining(ctx.ID().getText());
        if (scopeContaining == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not defined in this scope.");
            return null;
        }

        SymbolBase symbol = (SymbolBase) scopeContaining.symbolTable.get(ctx.ID().getText());

        if (symbol == null) {
            System.out.println("Array " + ctx.ID().getText() + " was not properly defined in this scope.");
            return null;
        }

        return symbol.type;
    }

    @Override
    public Type visitSizeOfExpression(UISCParser.SizeOfExpressionContext ctx) {
        Type sizeOfType = Type.getByKeyword(ctx.type().getText());
        if (sizeOfType == null) return null;
        return deduceTypeOfNumber(""+sizeOfType.getSize());
    }

    @Override
    public Type visitValueAtVariableExpression(UISCParser.ValueAtVariableExpressionContext ctx) {
        Type pointedType = visit(ctx.expression());
        if(pointedType == null) {
            System.out.println("Warning: Cannot find type for valueAt, returning void. "+ctx.toString());
            return Type.Void;
        }
        return pointedType.fromPointer();
    }
}
