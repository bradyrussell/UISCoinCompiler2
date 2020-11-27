package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

public class SymbolBase {
    public Type type;
    public int address;

    public SymbolBase(Type type, int address) {
        this.type = type;
        this.address = address;
    }

    @Override
    public String toString() {
        return "SymbolBase{\n" +
                "type=" + type +
                ", address=" + address +
                '}';
    }
}
