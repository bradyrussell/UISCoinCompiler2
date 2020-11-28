package com.bradyrussell.uiscoin.ide.antlr;

public class ASMUtil {
    public static boolean bNoComments = false;

    public static String generateComment(String Comment){
        return bNoComments ? "" : "\n/* "+Comment+" */\n";
    }

    public static String generateLoadAddress(int Address) {
        return ASMUtil.generateComment("Load Value from "+Address)+ "push ["+Address+"] pick ";
    }

    public static String generateStoreAddress(int Address) {
        return ASMUtil.generateComment("Store Value to "+Address)+"push ["+Address+"] put ";
    }
}
