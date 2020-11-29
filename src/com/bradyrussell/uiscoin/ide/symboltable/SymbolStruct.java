package com.bradyrussell.uiscoin.ide.symboltable;

public class SymbolStruct extends SymbolBase{
    public StructDefinition struct;
    public SymbolStruct(int address, StructDefinition struct) {
        super(null, address);
        this.struct = struct;
    }
}
