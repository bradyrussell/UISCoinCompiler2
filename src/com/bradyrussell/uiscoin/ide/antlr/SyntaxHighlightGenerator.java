package com.bradyrussell.uiscoin.ide.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStreamRewriter;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

public class SyntaxHighlightGenerator extends UISCBaseListener {
    private final CommonTokenStream tokens;
    private final TokenStreamRewriter rewriter;

    public SyntaxHighlightGenerator(CommonTokenStream tokens) {
        this.tokens = tokens;
        this.rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterPrimitiveType(UISCParser.PrimitiveTypeContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.PrimitiveType.getOpenTag());
        rewriter.insertAfter(ctx.stop, SyntaxHighlight.PrimitiveType.getCloseTag());
    }

    @Override
    public void enterStructType(UISCParser.StructTypeContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.StructType.getOpenTag());
        rewriter.insertAfter(ctx.stop, SyntaxHighlight.StructType.getCloseTag());
    }

    @Override
    public void enterVarInitialization(UISCParser.VarInitializationContext ctx) {
        if(ctx.constant != null) {
            rewriter.insertBefore(ctx.constant, SyntaxHighlight.Const.getOpenTag());
            rewriter.insertAfter(ctx.constant, SyntaxHighlight.Const.getCloseTag());
        }
    }

    @Override
    public void enterStringLiteralExpression(UISCParser.StringLiteralExpressionContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.StringLiteral.getOpenTag());
        rewriter.insertAfter(ctx.stop, SyntaxHighlight.StringLiteral.getCloseTag());
    }

    @Override
    public void enterArrayStringInitialization(UISCParser.ArrayStringInitializationContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getOpenTag());
            rewriter.insertAfter(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getCloseTag());
        }
    }

    @Override
    public void enterAssembly(UISCParser.AssemblyContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getOpenTag());
            rewriter.insertAfter(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getCloseTag());
        }
    }

    @Override
    public void enterFlagData(UISCParser.FlagDataContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getOpenTag());
            rewriter.insertAfter(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getCloseTag());
        }
    }

    @Override
    public void enterCharLiteralExpression(UISCParser.CharLiteralExpressionContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.StringLiteral.getOpenTag());
        rewriter.insertAfter(ctx.stop, SyntaxHighlight.StringLiteral.getCloseTag());
    }

    @Override
    public void enterInclude(UISCParser.IncludeContext ctx) {
        if(ctx.STRING().getSymbol() != null) {
            rewriter.insertBefore(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getOpenTag());
            rewriter.insertAfter(ctx.STRING().getSymbol(), SyntaxHighlight.StringLiteral.getCloseTag());
        }
    }

    @Override
    public void enterNativeCallExpression(UISCParser.NativeCallExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.start, SyntaxHighlight.NativeCall.getOpenTag());
            rewriter.insertAfter(ctx.ID().getSymbol(), SyntaxHighlight.NativeCall.getCloseTag());
        }
    }

    @Override
    public void enterNumber(UISCParser.NumberContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.NumberLiteral.getOpenTag());
        rewriter.insertAfter(ctx.stop, SyntaxHighlight.NumberLiteral.getCloseTag());
    }

    @Override
    public void enterStructDeclaration(UISCParser.StructDeclarationContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.Keyword.getOpenTag());
        rewriter.insertAfter(ctx.start, SyntaxHighlight.Keyword.getCloseTag());
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.start, SyntaxHighlight.StructType.getOpenTag());
            rewriter.insertAfter(ctx.ID().getSymbol(), SyntaxHighlight.StructType.getCloseTag());
        }
    }

    @Override
    public void enterUforiStatement(UISCParser.UforiStatementContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.Keyword.getOpenTag());
        rewriter.insertAfter(ctx.start, SyntaxHighlight.Keyword.getCloseTag());
        for (TerminalNode terminalNode : ctx.INT()) {
            if(terminalNode.getSymbol() != null) {
                rewriter.insertBefore(terminalNode.getSymbol(), SyntaxHighlight.NumberLiteral.getOpenTag());
                rewriter.insertAfter(terminalNode.getSymbol(), SyntaxHighlight.NumberLiteral.getCloseTag());
            }
        }
    }

    @Override
    public void enterUforeachStatement(UISCParser.UforeachStatementContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.Keyword.getOpenTag());
        rewriter.insertAfter(ctx.start, SyntaxHighlight.Keyword.getCloseTag());
    }

    @Override
    public void enterForStatement(UISCParser.ForStatementContext ctx) {
        rewriter.insertBefore(ctx.start, SyntaxHighlight.Keyword.getOpenTag());
        rewriter.insertAfter(ctx.start, SyntaxHighlight.Keyword.getCloseTag());
    }

    @Override
    public void enterArrayAssignmentInitialization(UISCParser.ArrayAssignmentInitializationContext ctx) {
        if(ctx.INT().getSymbol() != null) {
            rewriter.insertBefore(ctx.INT().getSymbol(), SyntaxHighlight.NumberLiteral.getOpenTag());
            rewriter.insertAfter(ctx.INT().getSymbol(), SyntaxHighlight.NumberLiteral.getCloseTag());
        }
    }

    @Override
    public void enterFunctionCallExpression(UISCParser.FunctionCallExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), SyntaxHighlight.Function.getOpenTag());
            rewriter.insertAfter(ctx.ID().getSymbol(), SyntaxHighlight.Function.getCloseTag());
        }
    }

    @Override
    public void enterFunctionDeclaration(UISCParser.FunctionDeclarationContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), SyntaxHighlight.Function.getOpenTag());
            rewriter.insertAfter(ctx.ID().getSymbol(), SyntaxHighlight.Function.getCloseTag());
        }
    }

    @Override
    public void enterVariableReferenceExpression(UISCParser.VariableReferenceExpressionContext ctx) {
        if(ctx.ID().getSymbol() != null) {
            rewriter.insertBefore(ctx.ID().getSymbol(), SyntaxHighlight.Variable.getOpenTag());
            rewriter.insertAfter(ctx.ID().getSymbol(), SyntaxHighlight.Variable.getCloseTag());
        }
    }

    public static String style =
            "<style>\n" +
                    "body {background-color: 111111;}\n" +
                    "span {color: bbbbbb;}\n" +
                    ".PrimitiveType {\n" +
                    "\tcolor:orange;\n" +
                    "}\n" +
                    ".StructType {\n" +
                    "\tcolor:1111bb;\n" +
                    "}\n" +
                    ".StringLiteral {\n" +
                    "\tcolor:green;\n" +
                    "}\n" +
                    ".Comment {\n" +
                    "\tcolor:gray;\n" +
                    "}\n" +
                    ".NativeCall {\n" +
                    "\tcolor:blue;\n" +
                    "}\n" +
                    ".NumberLiteral {\n" +
                    "\tcolor:teal;\n" +
                    "}\n" +
                    ".Keyword {\n" +
                    "\tcolor:brown;\n" +
                    "}\n" +
                    ".Function {\n" +
                    "\tcolor:yellow;\n" +
                    "}\n" +
                    ".Variable {\n" +
                    "\tcolor:pink;\n" +
                    "}\n" +
                    "</style>";

    public String getText() {
        for (int i = 0; i < tokens.size(); i++) {
            if(tokens.getTokens().get(i).getChannel() == 0) {
                List<Token> tokensToRight = tokens.getHiddenTokensToRight(i, 2);
                if(tokensToRight != null) {
                    rewriter.insertBefore(tokensToRight.get(0), SyntaxHighlight.Comment.getOpenTag());
                    rewriter.insertAfter(tokensToRight.get(tokensToRight.size()-1), SyntaxHighlight.Comment.getCloseTag());
                }
            }
        }

        return style.replace("\n", "").replace("\t", "")+("<span class=\"code\">"+rewriter.getText()+"</span>").replace("\n", "<br/>").replace("\t","&emsp;");
    }
}