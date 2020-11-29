package com.bradyrussell.uiscoin.ide.grammar;

import com.bradyrussell.uiscoin.ide.CompilerErrorException;
import com.bradyrussell.uiscoin.script.ScriptUtil;

public enum PrimitiveType {
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

    StructArray(1),// * Size * Length
    ByteArray(1),// * Length
    Int32Array(4),// * Length
    Int64Array(8),// * Length
    FloatArray(4),// * Length
    ;

    final String[] Keywords;
    final int SizeOf;

    PrimitiveType(int sizeOf, String... keywords) {
        SizeOf = sizeOf;
        Keywords = keywords;
    }

    public static PrimitiveType getByKeyword(String Keyword) {
        for (PrimitiveType value : PrimitiveType.values()) {
            for (String keyword : value.Keywords) {
                if(keyword.equals(Keyword)) return value;
            }
        }
        return null;
        //throw new IllegalArgumentException(Keyword+" is not a valid type!");
    }

    public int getSize() {
        return SizeOf;
    }

    public static PrimitiveType getWiderType(PrimitiveType A, PrimitiveType B){ // for math
        if(A.equals(PrimitiveType.Float) || B.equals(PrimitiveType.Float)) return PrimitiveType.Float; // integer always widens to float for math
        return A.getSize() >= B.getSize() ? A : B; // otherwise choose largest
    }

    public boolean widensTo(PrimitiveType WideType){
        if(!(this.equals(PrimitiveType.Byte) || this.equals(PrimitiveType.Int32))) return false;
        return this.SizeOf <= WideType.SizeOf;
    }

    public PrimitiveType toPointer(){
        return toPointer(this);
    }

    public static PrimitiveType toPointer(PrimitiveType type){
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

    public PrimitiveType fromPointer(){
        return fromPointer(this);
    }

    public static PrimitiveType fromPointer(PrimitiveType type){
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

    public PrimitiveType toArray(){
        return toArray(this);
    }

    public static PrimitiveType toArray(PrimitiveType type){
        switch (type) {
            case Void -> {
                return StructArray;
            }
            case Byte -> {
                return ByteArray;
            }
            case Int32 -> {
                return Int32Array;
            }
            case Int64 -> {
                return Int64Array;
            }
            case Float -> {
                return FloatArray;
            }
        }
        return type;
    }

    public PrimitiveType fromArray(){
        return fromArray(this);
    }

    public static PrimitiveType fromArray(PrimitiveType type){
        switch (type) {
            case StructArray -> {
                return Void;
            }
            case ByteArray -> {
                return Byte;
            }
            case Int32Array -> {
                return Int32;
            }
            case Int64Array -> {
                return Int64;
            }
            case FloatArray -> {
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
