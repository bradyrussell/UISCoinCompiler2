package com.bradyrussell.uiscoin.ide;

import com.bradyrussell.uiscoin.ide.grammar.Operation;
import com.bradyrussell.uiscoin.ide.grammar.Type;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeBase;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeGlobal;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeLocal;

public class ScriptBuilder {
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

    public ScriptBuilder declareVariable(String Name, Type VariableType){
        getCurrentScope().declareSymbol(Name, VariableType);
        return this;
    }

    public ScriptBuilder initializeVariable(String Name, TypedValue Value){
        getCurrentScope().declareSymbol(Name, Value.type);
        return this;
    }

    public ScriptBuilder assignVariable(String Name, TypedValue Value){
        return this;
    }

    // push the value of the var on top of the stack
    public ScriptBuilder accessVariable(String Name){
        return this;
    }

    // push the address of the var on top of the stack. example: $name (&name in C)
    public ScriptBuilder referenceVariable(String Name){
        return this;
    }

    // pick Address. example: @address (*address in C)
    public ScriptBuilder dereferenceVariable(int Address){
        return this;
    }

    public ScriptBuilder applyOperation(Operation OperationToApply){
        return this;
    }

}
