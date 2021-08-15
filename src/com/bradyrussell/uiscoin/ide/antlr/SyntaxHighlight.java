package com.bradyrussell.uiscoin.ide.antlr;

public enum SyntaxHighlight {
    PrimitiveType,
    StructType,
    Const,
    StringLiteral,
    Comment,
    NumberLiteral,
    NativeCall,
    Keyword
    ;

    private final String OpenTag;
    private final String CloseTag;

/*    SyntaxHighlight() {
        OpenTag = "<"+this.name()+">";
        CloseTag = "</"+this.name()+">";;
    }*/

    SyntaxHighlight() {
        OpenTag = "<span class=\""+this.name()+"\">";
        CloseTag = "</span>";
    }

    SyntaxHighlight(String openTag, String closeTag) {
        OpenTag = openTag;
        CloseTag = closeTag;
    }

    public String getOpenTag() {
        return OpenTag;
    }

    public String getCloseTag() {
        return CloseTag;
    }
}
