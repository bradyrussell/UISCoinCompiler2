package com.bradyrussell.uiscoin.ide.symboltable;

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
}
