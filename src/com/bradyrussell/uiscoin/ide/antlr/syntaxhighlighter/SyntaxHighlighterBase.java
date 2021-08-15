package com.bradyrussell.uiscoin.ide.antlr.syntaxhighlighter;

import java.util.Map;

public abstract class SyntaxHighlighterBase {
    public abstract String getOpenTag(SyntaxHighlight type);
    public abstract String getCloseTag(SyntaxHighlight type);
    public abstract String getGlobalOpenTag();
    public abstract String getGlobalCloseTag();
    public abstract Map<String, String> getReplacements();
}
