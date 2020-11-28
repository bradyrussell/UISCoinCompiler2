package com.bradyrussell.uiscoin.ide.symboltable;

public interface Symbol {
    public abstract Integer getSymbolAddress();

    public abstract String generateGetSymbolASM();
    public abstract String generateSetSymbolASM();
}
