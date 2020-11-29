package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.antlr.ASMUtil;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;

public class SymbolBase implements Symbol {
    public PrimitiveType type;
    public int address;

    public SymbolBase(PrimitiveType type, int address) {
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
        return ASMUtil.generateLoadAddress(getSymbolAddress());
    }

    @Override
    public String generateSetSymbolASM() {
        return ASMUtil.generateStoreAddress(getSymbolAddress());
    }
}
