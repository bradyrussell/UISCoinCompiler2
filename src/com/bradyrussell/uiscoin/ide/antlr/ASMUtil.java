package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;
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

    // returns asm to cast one type to another, or null if conversion is not allowed
    public static String generateCastAssembly(PrimitiveType From, PrimitiveType To) {
        if (From.equals(To)) return " ";

        StringBuilder asm = new StringBuilder();

        if(From.isPointer()) {
            System.out.println("Warning: Casting value from "+From+" to "+To+" might violate type safety!");
            From = PrimitiveType.Int32;
        }

        if(To.isPointer()) {
            System.out.println("Warning: Casting value from "+From+" to "+To+" might violate type safety!");
            To = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Byte)) {
            if (To.getSize() > 1) { // int32 is the intermediate type
                asm.append("convert8to32 ");
                From = PrimitiveType.Int32;
            }
        }

        if (From.equals(PrimitiveType.Int64)) {
            // int32 is the intermediate type
            asm.append("convert64to32 ");
            From = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Float)) {
            // int32 is the intermediate type
            asm.append("convertfloatto32 ");
            From = PrimitiveType.Int32;
        }

        if (From.equals(PrimitiveType.Int32)) {
            switch (To) {
                case Byte -> {
                    asm.append("convert32to8 ");
                    return asm.toString();
                }
                case Int32 -> {
                    return asm.toString();
                }
                case Int64 -> {
                    asm.append("convert32to64 ");
                    return asm.toString();
                }
                case Float -> {
                    asm.append("convert32tofloat ");
                    return asm.toString();
                }
            }
        }

        if(From.equals(PrimitiveType.Void)) {
            System.out.println("Warning: Casting from void could violate type safety!");
            return "";
        }
        System.out.println("Cannot cast from "+From+" to "+To+"!");
        return null;
    }

    public static String generatePushNumberLiteral(String NumberLiteralString){
        PrimitiveType typeOfInteger = PrimitiveType.deduceTypeOfNumber(NumberLiteralString);
        return "push " + (PrimitiveType.Byte.equals(typeOfInteger) ? "[":"") + NumberLiteralString + (PrimitiveType.Byte.equals(typeOfInteger) ? "] ":" ");
    }
}
