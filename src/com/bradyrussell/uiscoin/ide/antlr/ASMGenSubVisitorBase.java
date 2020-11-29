package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.ide.symboltable.ScopeBase;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeGlobal;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeLocal;

public abstract class ASMGenSubVisitorBase<T> extends UISCBaseVisitor<T> {

    ////////////////////////
    ScopeGlobal Global;
    ScopeLocal CurrentLocalScope;

    public ASMGenSubVisitorBase(ScopeGlobal global, ScopeLocal currentLocalScope) {
        Global = global;
        CurrentLocalScope = currentLocalScope;
    }

    ScopeBase getCurrentScope() {
        return CurrentLocalScope == null ? Global : CurrentLocalScope;
    }

/*    void PushLocalScope(String ScopeName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeLocal(ScopeName, Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeLocal(ScopeName, parent);
            parent.Children.add(CurrentLocalScope);
        }
    }

    void PushFunctionScope(Type FunctionType, String FunctionName) {
        if (CurrentLocalScope == null) {
            CurrentLocalScope = Global.defineFunction(FunctionName, FunctionType);
        } else {
            CurrentLocalScope = CurrentLocalScope.defineFunction(FunctionName, FunctionType);
        }
    }

    void PopLocalScope() {
        if (CurrentLocalScope.Parent instanceof ScopeLocal) CurrentLocalScope = (ScopeLocal) CurrentLocalScope.Parent;
        CurrentLocalScope = null;
    }*/
    ////////////////////////


}
