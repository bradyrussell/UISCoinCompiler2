package com.bradyrussell.uiscoin.ide.compiler;

import com.bradyrussell.uiscoin.ide.symboltable.ScopeBase;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeGlobal;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeLocal;

import java.util.ArrayList;
import java.util.HashMap;

public class TestCompilationContext extends CompilationContextBase{
    ScopeGlobal Global = new ScopeGlobal("GlobalScope",null);
    ScopeLocal CurrentLocalScope = null;

    ScopeBase getCurrentScope(){
        return CurrentLocalScope == null ? Global : CurrentLocalScope;
    }

    void PushLocalScope(String ScopeName){
        if(CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeLocal(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeLocal(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
    }

    void PopLocalScope(){
        if(CurrentLocalScope.Parent instanceof ScopeLocal) CurrentLocalScope = (ScopeLocal) CurrentLocalScope.Parent;
        CurrentLocalScope = null;
    }

    @Override
    public String toString() {
        return "TestCompilationContext{" +
                "Global=" + Global +
                ", CurrentLocalScope=" + CurrentLocalScope +
                '}';
    }
}
