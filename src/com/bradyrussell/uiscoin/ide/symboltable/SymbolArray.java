package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

public class SymbolArray extends SymbolBase{
    public int length;

    public SymbolArray(Type type, int address, int length) {
        super(type, address);
        this.length = length;
    }
}
