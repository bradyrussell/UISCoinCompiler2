package com.bradyrussell.uiscoin.ide.symboltable;

import java.util.HashMap;

public class ScopeCapture extends ScopeLocal {
    public ScopeCapture(String scopeName, ScopeBase parent) {
        super(scopeName, parent);
        ScopeBaseAddress = 0; // capture always starts from zero
        ScopeAddress = 0;
    }

    HashMap<String, Integer> capturedVariableRealAddresses = new HashMap<>();

    public String generateCaptureASM(){
        // pick capturedVariableRealAddresses(x)
        // pick ..y
        //pick ..z    in order where symbolTable.get(x).address = 0, y = 1 etc

        return "CAPTURE_ASM_NOT_IMPLEMENTED";
    }

    @Override
    public Object getSymbol(String Name) {
        if(symbolTable.containsKey(Name)) return symbolTable.get(Name);
        ScopeBase actualScope = super.findScopeContaining(Name);
        if(actualScope == null) return null;

        // capture the symbol into this scope
        Object uncastedActualSymbol = actualScope.getSymbol(Name);

        if(uncastedActualSymbol instanceof ScopeWithSymbol) {
            ScopeWithSymbol actualSymbol = (ScopeWithSymbol) uncastedActualSymbol;
            capturedVariableRealAddresses.put(Name, actualSymbol.Symbol.address);

            // todo functions need their scope captured?

        } else if(uncastedActualSymbol instanceof SymbolArray) {
            SymbolArray actualSymbol = (SymbolArray) uncastedActualSymbol;
            capturedVariableRealAddresses.put(Name, actualSymbol.address);

            int innerAddress = declareArray(Name, actualSymbol.type, actualSymbol.length);
            System.out.println("Captured array "+Name+" outer address: "+actualSymbol.address+" inner address: "+innerAddress);
        } else {
            SymbolBase actualSymbol = (SymbolBase) uncastedActualSymbol;
            capturedVariableRealAddresses.put(Name, actualSymbol.address);

            int innerAddress = declareSymbol(Name, actualSymbol.type);
            System.out.println("Captured symbol "+Name+" outer address: "+actualSymbol.address+" inner address: "+innerAddress);
        }
        return symbolTable.get(Name);
    }

    @Override
    public boolean hasSymbol(String Name) {
        if(super.hasSymbol(Name)) return true;
        ScopeBase actualScope = super.findScopeContaining(Name);
        return actualScope != null;
    }

    @Override
    public ScopeBase findScopeContaining(String Name) {
        if(hasSymbol(Name)) return this;
        return null;
    }
}
