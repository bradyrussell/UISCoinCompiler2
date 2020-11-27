package com.bradyrussell.uiscoin.ide.symboltable;

public class ScopeGlobal extends ScopeBase{
    public ScopeGlobal(ScopeBase parent) {
        super(parent);
    }

    public ScopeGlobal(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
    }
}
