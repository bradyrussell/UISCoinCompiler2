package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

public class SymbolBase implements Symbol {
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

    @Override
    public Integer getSymbolAddress() {
        return address;
    }

    @Override
    public String generateGetSymbolASM() {
        return "push ["+getSymbolAddress()+"] pick ";
    }

    @Override
    public String generateSetSymbolASM() {
        return "push ["+getSymbolAddress()+"] put ";
    }
}
