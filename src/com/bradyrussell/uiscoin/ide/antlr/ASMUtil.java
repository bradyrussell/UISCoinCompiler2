package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.script.ScriptParser;

import java.util.Arrays;

public class ASMUtil {
    public static boolean bNoComments = false;

    public static String generateComment(String Comment){
        return bNoComments ? "" : "\n/* "+Comment+" */\n";
    }

    public static String generateLoadAddress(int Address) {
        return ASMUtil.generateComment("Load Value from "+Address)+ " push ["+Address+"] pick ";
    }

    public static String generateStoreAddress(int Address) {
        return ASMUtil.generateComment("Store Value to "+Address)+" push ["+Address+"] put ";
    }

    public static String generatePushASMString(String ASMString) {
        return ASMUtil.generateComment("Bytecode for: "+ASMString)+" push { "+ASMString+" } ";
    }

    public static String generateExecuteZippedBytecode(byte[] ZippedByteCode) {
        if(ZippedByteCode.length == 0) throw new UnsupportedOperationException("ZippedByteCode is empty!");
        return " depth push 0x"+ BytesUtil.bytesToHex(ZippedByteCode)+" unzip call verify"; // not tested
    }

    public static String generateExecuteZippedASM(String ASM) {
        return generateExecuteZippedBytecode(BytesUtil.ZipBytes(ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASM,true))));
    }
}
