package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;
import com.bradyrussell.uiscoin.ide.grammar.TypedValue;

import java.util.ArrayList;
import java.util.HashMap;

public class ScopeBase {
    public String ScopeName = "AnonymousScope";
    public ScopeBase Parent;
    public ArrayList<ScopeBase> Children = new ArrayList<>();
    public HashMap<String, Object> symbolTable = new HashMap<>(); // can either be SymbolBase or SymbolWithScope

    private int ScopeBaseAddress = 0;
    private int ScopeAddress;

    public ScopeBase(ScopeBase parent) {
        Parent = parent;
        if(parent !=  null) ScopeBaseAddress = parent.ScopeAddress;
        ScopeAddress = ScopeBaseAddress;
    }

    public ScopeBase(String scopeName, ScopeBase parent) {
        ScopeName = scopeName;
        Parent = parent;
        if(parent !=  null) ScopeBaseAddress = parent.ScopeAddress;
        ScopeAddress = ScopeBaseAddress;
        System.out.println("[Scope] Entering new scope "+scopeName+", base address: "+ScopeAddress+", parent: "+(Parent == null ? "None" : Parent.ScopeName));
    }

    public ScopeLocal defineFunction(String Name, Type SymbolType){
        if(symbolTable.containsKey(Name)) return null;
        ScopeWithSymbol scope = new ScopeWithSymbol(Name,this, new SymbolBase(SymbolType, ScopeAddress++));
        symbolTable.put(Name, scope);
        System.out.println("[Scope] Defined function "+Name+" at address "+(ScopeAddress-1));
        return scope;
    }

    public int declareSymbol(String Name, Type SymbolType){
        if(symbolTable.containsKey(Name)) return -1;
        symbolTable.put(Name, new SymbolBase(SymbolType, ScopeAddress++));
        System.out.println("[Scope] Declared symbol "+Name+" at address "+(ScopeAddress-1));
        return ScopeAddress-1;
    }

    public int declareConstantInlineSymbol(String Name, TypedValue Value){
        if(symbolTable.containsKey(Name)) return -1;
        symbolTable.put(Name, Value);
        System.out.println("[Scope] Declared constant inline symbol "+Name+" with value "+Value);
        return ScopeAddress-1;
    }

    @Override
    public String toString() {
        return "ScopeBase{" +
                "ScopeName='" + ScopeName + '\'' +
                ", Parent=" + (Parent == null ? "None":Parent.ScopeName) +
                ", Children=" + Children +
                ", symbolTable=" + symbolTable +
                ", ScopeAddress=" + ScopeAddress +
                ", ScopeBaseAddress=" + ScopeBaseAddress +
                '}';
    }

    public ScopeBase findScopeContaining(String Name) {
        if(symbolTable.containsKey(Name)) return this;
        if(Parent == null) {
            //System.out.println("Symbol "+Name+" was not found in global scope "+ScopeName);
            return null;
        }

        //System.out.println("Symbol "+Name+" was not found in scope "+ScopeName);
        return Parent.findScopeContaining(Name);
    }

    public String getRecursiveAllocation(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getDepth()+1; i++) {
            sb.append("null ");
        }

        return sb.toString();
    }

    public String getAllocation(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ScopeAddress - ScopeBaseAddress; i++) {
            sb.append("null ");
        }

        return sb.toString();
    }

    public String getDeallocation(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ScopeAddress - ScopeBaseAddress; i++) {
            sb.append("drop ");
        }

        return sb.toString();
    }

    public int getDepth(){
        int deepest = 0;
        int ThisDepth = ScopeAddress - ScopeBaseAddress;

        for (ScopeBase child : Children) {
            int childDepth = ThisDepth + child.getDepth();
            if(childDepth > deepest) deepest = childDepth;
        }
        return deepest;
    }
}
