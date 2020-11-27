package com.bradyrussell.uiscoin.ide.antlr;

import org.antlr.v4.runtime.ParserRuleContext;

public class TestUISCListener extends UISCBaseListener{

    @Override
    public void enterVarInitialization(UISCParser.VarInitializationContext ctx) {
        System.out.println("Initialize var "+ctx.ID()+" with type "+ctx.type().getText()+" = "+ctx.expression());
    }

    @Override
    public void enterAssignmentStatement(UISCParser.AssignmentStatementContext ctx) {
        //System.out.println("Assign var "+ctx.expression(0).getText() + " value "+ctx.expression(1).getText());
    }
}
