package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.antlr.ASMUtil;

public class ScopeWithSymbol extends ScopeLocal implements Symbol {
    public SymbolBase Symbol;

    public ScopeWithSymbol(String scopeName, ScopeBase parent, SymbolBase symbol) {
        super(scopeName, parent);
        Symbol = symbol;
    }

    @Override
    public Integer getSymbolAddress() {
        return Symbol.address;
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
