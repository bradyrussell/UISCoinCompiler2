package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.antlr.ASMUtil;
import com.bradyrussell.uiscoin.ide.grammar.PrimitiveType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StructDefinition {
    private HashMap<String, String> structStructFields; // if a field is a struct, the entry in structFields will be null
    private HashMap<String, PrimitiveType> structFields;
    private ArrayList<String> structFieldOrder;

    public StructDefinition(List<NameAndType> Fields) {
        structFields = new HashMap<>();
        structFieldOrder = new ArrayList<>();
        structStructFields = new HashMap<>();

        for (NameAndType field : Fields) {
            if(field.bIsStruct) {
                if (!defineStructField(field.Name, field.StructType)) throw new UnsupportedOperationException("Struct struct field redefinition: " + field.Name);
            } else {
                if (!defineField(field.Name, field.Type)) throw new UnsupportedOperationException("Struct field redefinition: " + field.Name);
            }
        }
    }

    public int getSize(){
        int size = 0;

        for (PrimitiveType value : structFields.values()) {
            if(value == null) throw new UnsupportedOperationException("getting the size of struct struct fields not yet supported"); //todo need some way to get defined structs for size
        }

        return structFields.values().stream().mapToInt(PrimitiveType::getSize).sum();
    }

    public int getFieldByteIndex(String FieldName){
        int index = 0;
        for (String structField : structFieldOrder) {
            if(structField.equals(FieldName)) return index;
            index += getFieldSize(structField);
        }
        return -1;
    }

    public int getFieldSize(String FieldName){
        if(structStructFields.containsKey(FieldName)) throw new UnsupportedOperationException("getting the size of struct struct fields not yet supported");
        return getFieldType(FieldName).getSize();
    }

    public boolean defineField(String FieldName, PrimitiveType FieldType) {
        if(structFields.containsKey(FieldName)) return false;

        structFields.put(FieldName,FieldType);
        structFieldOrder.add(FieldName);

        return true;
    }

    public boolean defineStructField(String FieldName, String StructType) {
        if(structFields.containsKey(FieldName)) return false;

        structFields.put(FieldName,null);
        structStructFields.put(FieldName, StructType);
        structFieldOrder.add(FieldName);

        return true;
    }

    public ArrayList<PrimitiveType> getOrderedTypes(){
        ArrayList<PrimitiveType> types = new ArrayList<>();
        for (String structField : structFieldOrder) {
            types.add(getFieldType(structField));
        }
        return types;
    }

    public PrimitiveType getFieldType(String FieldName){
        return structFields.get(FieldName);
    }

    // expects int32 Struct address to be the top stack element
    public String generateFieldGetterASM(String FieldName){
        return " push "+getFieldByteIndex(FieldName)+" push "+getFieldSize(FieldName)+" get ";
    }

    // expects [Data][int32 Struct Address] on stack
    public String generateFieldSetterASM(String FieldName){ // todo this seems off for diff size struct fields
        return ASMUtil.generateComment(FieldName) +ASMUtil.generateComment("Field index: "+getFieldByteIndex(FieldName))+" push " +getFieldByteIndex(FieldName)+ASMUtil.generateComment("Field size: "+getFieldSize(FieldName)) +" push "+getFieldSize(FieldName)+" set ";
    }

    // push this struct zeroed onto the stack
    public String generateAllocatorASM(){
        return " push "+getSize()+" alloc ";
    }
}
