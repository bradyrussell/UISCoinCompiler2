package com.bradyrussell.uiscoin.ide.symboltable;

public class ScopeWithSymbol extends ScopeLocal {
    public SymbolBase Symbol;

    public ScopeWithSymbol(String scopeName, ScopeBase parent, SymbolBase symbol) {
        super(scopeName, parent);
        Symbol = symbol;
    }

}
