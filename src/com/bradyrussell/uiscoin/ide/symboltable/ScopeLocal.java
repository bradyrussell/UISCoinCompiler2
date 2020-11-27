package com.bradyrussell.uiscoin.ide.symboltable;

import java.util.ArrayList;

public class ScopeLocal extends ScopeBase{
    public ScopeLocal(ScopeBase parent) {
        super(parent);
    }

    public ScopeLocal(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
    }
}
