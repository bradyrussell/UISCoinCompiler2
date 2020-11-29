package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;

public class NameAndType {
    String Name;
    PrimitiveType Type;
    String StructType;
    boolean bIsStruct;

    public NameAndType(String name, PrimitiveType type) {
        Name = name;
        Type = type;
        bIsStruct = false;
    }

    public NameAndType(String name, String structType) {
        Name = name;
        StructType = structType;
        bIsStruct = true;
    }
}
