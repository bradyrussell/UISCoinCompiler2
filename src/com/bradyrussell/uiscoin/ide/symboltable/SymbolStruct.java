package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

public class SymbolStruct extends SymbolBase{
    StructDefinition struct;
    public SymbolStruct(Type type, int address, StructDefinition struct) {
        super(type, address);
        this.struct = struct;
    }
}
