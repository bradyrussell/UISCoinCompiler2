package com.bradyrussell.uiscoin.ide.grammar;

import com.bradyrussell.uiscoin.ide.CompilerErrorException;
import com.bradyrussell.uiscoin.script.ScriptUtil;

public enum Type {
    Void(1, "void", "v"),
    Byte(1, "byte", "i8", "char", "b", "bool"),
    Int32(4, "int32", "i32", "int", "i"),
    Int64(8, "int64", "i64", "long", "l"),
    Float(4, "float", "f32", "f", "f"),

    VoidPointer(4),
    BytePointer(4),
    Int32Pointer(4),
    Int64Pointer(4),
    FloatPointer(4),
    ;

    final String[] Keywords;
    final int SizeOf;

    Type(int sizeOf, String... keywords) {
        SizeOf = sizeOf;
        Keywords = keywords;
    }

    public static Type getByKeyword(String Keyword) {
        for (Type value : Type.values()) {
            for (String keyword : value.Keywords) {
                if(keyword.equals(Keyword)) return value;
            }
        }
        throw new IllegalArgumentException(Keyword+" is not a valid type!");
    }

    public int getSize() {
        return SizeOf;
    }

    public static Type getWiderType(Type A, Type B){ // for math
        if(A.equals(Type.Float) || B.equals(Type.Float)) return Type.Float; // integer always widens to float for math
        return A.getSize() >= B.getSize() ? A : B; // otherwise choose largest
    }

    public boolean widensTo(Type WideType){
        if(!(this.equals(Type.Byte) || this.equals(Type.Int32))) return false;
        return this.SizeOf <= WideType.SizeOf;
    }

    public Type toPointer(){
        return toPointer(this);
    }

    public static Type toPointer(Type type){
        switch (type) {
            case Void -> {
                return VoidPointer;
            }
            case Byte -> {
                return BytePointer;
            }
            case Int32 -> {
                return Int32Pointer;
            }
            case Int64 -> {
                return Int64Pointer;
            }
            case Float -> {
                return FloatPointer;
            }
        }
        return type;
    }

    public Type fromPointer(){
        return fromPointer(this);
    }

    public static Type fromPointer(Type type){
        switch (type) {
            case VoidPointer -> {
                return Void;
            }
            case BytePointer -> {
                return Byte;
            }
            case Int32Pointer -> {
                return Int32;
            }
            case Int64Pointer -> {
                return Int64;
            }
            case FloatPointer -> {
                return Float;
            }
        }
        return Void;
    }

    public byte[] Parse(String Token) throws CompilerErrorException {
        switch (this){
            case Void -> { // todo
                throw new CompilerErrorException("Cannot parse void type!");
            }
            case Byte -> {
                return ScriptUtil.NumberStringToBytes(Token, false);
            }
            default -> {
                return ScriptUtil.NumberStringToBytes(Token, true);
            }
        }
    }
}
