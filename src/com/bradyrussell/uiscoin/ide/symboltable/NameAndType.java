package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveOrArrayType;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;

public class NameAndType {
    public String Name;
    public PrimitiveOrArrayType Type;
    public String StructType;
    public boolean bIsStruct;

    public NameAndType(String name, PrimitiveOrArrayType type) {
        Name = name;
        Type = type;
        bIsStruct = false;
    }

    public NameAndType(String name, PrimitiveType type, int ArrayLength) {
        Name = name;
        Type = type;
        bIsStruct = false;
        this.ArrayLength = ArrayLength;
    }

    public NameAndType(String name, String structType) {
        Name = name;
        StructType = structType;
        bIsStruct = true;
    }

    public NameAndType(String name, String structType, int ArrayLength) {
        Name = name;
        StructType = structType;
        bIsStruct = true;
        this.ArrayLength = ArrayLength;
    }
}
