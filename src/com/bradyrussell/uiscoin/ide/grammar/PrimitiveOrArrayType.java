package com.bradyrussell.uiscoin.ide.grammar;

public class PrimitiveOrArrayType {
    PrimitiveType Type;
    int ArrayLength = -1;

    public boolean isArray(){
        return ArrayLength >= 0;
    }
}
