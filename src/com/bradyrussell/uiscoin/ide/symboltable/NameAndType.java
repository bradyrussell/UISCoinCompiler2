package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.PrimitiveStructOrArrayType;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;

public class NameAndType {
    public String Name;
    public PrimitiveStructOrArrayType Type;

    public NameAndType(String name, PrimitiveStructOrArrayType type) {
        Name = name;
        Type = type;
    }

}
