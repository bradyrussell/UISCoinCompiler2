package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

public class SymbolStruct extends SymbolBase{
    StructDefinition struct;
    public SymbolStruct(int address, StructDefinition struct) {
        super(null, address);
        this.struct = struct;
    }
}
