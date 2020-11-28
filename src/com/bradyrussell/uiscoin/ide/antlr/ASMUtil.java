package com.bradyrussell.uiscoin.ide.antlr;

public class ASMUtil {
    public static String generateComment(String Comment){
        return "/* "+Comment+" */ \n";
    }

    public static String generateGetAddress(int Address) {
        return ASMUtil.generateComment("Load Value from "+Address)+ "push ["+Address+"] pick ";
    }

    public static String generateSetAddress(int Address) {
        return ASMUtil.generateComment("Store Value to "+Address)+"push ["+Address+"] put ";
    }
}
