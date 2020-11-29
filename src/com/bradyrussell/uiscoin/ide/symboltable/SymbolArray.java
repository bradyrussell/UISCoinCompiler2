package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;

public class SymbolArray extends SymbolBase{
    public int length;

    public SymbolArray(PrimitiveType type, int address, int length) {
        super(type, address);
        this.length = length;
    }
}
