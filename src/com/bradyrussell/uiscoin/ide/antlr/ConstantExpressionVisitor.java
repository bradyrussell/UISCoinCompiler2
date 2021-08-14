package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;

public class ConstantExpressionVisitor extends UISCBaseVisitor<TypedValue>{
    @Override
    protected TypedValue defaultResult() {
        return null;
    }

}
