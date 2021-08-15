package com.bradyrussell.uiscoin.ide.antlr.syntaxhighlighter;

import java.util.Map;

public class SyntaxHighlighterHtml extends SyntaxHighlighterBase {
    public static String style =
            "<style>\n" +
                    "body {background-color: 111111;}\n" +
                    "span {color: bbbbbb;}\n" +
                    ".PrimitiveType {\n" +
                    "\tcolor:orange;\n" +
                    "}\n" +
                    ".StructType {\n" +
                    "\tcolor:1111bb;\n" +
                    "}\n" +
                    ".StringLiteral {\n" +
                    "\tcolor:green;\n" +
                    "}\n" +
                    ".Comment {\n" +
                    "\tcolor:gray;\n" +
                    "}\n" +
                    ".NativeCall {\n" +
                    "\tcolor:blue;\n" +
                    "}\n" +
                    ".NumberLiteral {\n" +
                    "\tcolor:teal;\n" +
                    "}\n" +
                    ".Keyword {\n" +
                    "\tcolor:brown;\n" +
                    "}\n" +
                    ".Function {\n" +
                    "\tcolor:yellow;\n" +
                    "}\n" +
                    ".Variable {\n" +
                    "\tcolor:pink;\n" +
                    "}\n" +
                    ".AddressOf {\n" +
                    "\tcolor:lime;\n" +
                    "}\n" +
                    ".ValueAt {\n" +
                    "\tcolor:red;\n" +
                    "}\n" +
                    "</style>";

    @Override
    public String getOpenTag(SyntaxHighlight type) {
        return "<span class=\""+type.name()+"\">";
    }

    @Override
    public String getCloseTag(SyntaxHighlight type) {
        return "</span>";
    }

    @Override
    public String getGlobalOpenTag() {
        return style.replace("\n", "").replace("\t", "")+"<span class=\"code\">";
    }

    @Override
    public String getGlobalCloseTag() {
        return "</span>";
    }

    @Override
    public Map<String, String> getReplacements() {
        return Map.of("\n", "<br/>", "\t","&emsp;");
    }
}
