package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class StructDefinition {
    private HashMap<String, Type> structFields;
    private ArrayList<String> structFieldOrder;

    public StructDefinition(List<NameAndType> Fields) {
        structFields = new HashMap<>();
        structFieldOrder = new ArrayList<>();

        for (NameAndType field : Fields) {
            if(!defineField(field.Name,field.Type)) throw new UnsupportedOperationException("Struct field redefinition: "+field.Name);
        }
    }

    public int getSize(){
        return structFields.values().stream().mapToInt(Type::getSize).sum();
    }

    public int getFieldByteIndex(String FieldName){
        int index = 0;
        for (String structField : structFieldOrder) {
            if(structField.equals(FieldName)) return index;
            index += getFieldSize(FieldName);
        }
        return -1;
    }

    public int getFieldSize(String FieldName){
        return getFieldType(FieldName).getSize();
    }

    public boolean defineField(String FieldName, Type FieldType) {
        if(structFields.containsKey(FieldName)) return false;

        structFields.put(FieldName,FieldType);
        structFieldOrder.add(FieldName);

        return true;
    }

    public ArrayList<Type> getOrderedTypes(){
        ArrayList<Type> types = new ArrayList<>();
        for (String structField : structFieldOrder) {
            types.add(getFieldType(structField));
        }
        return types;
    }

    public Type getFieldType(String FieldName){
        return structFields.get(FieldName);
    }

    // expects int32 Struct address to be the top stack element
    public String generateFieldGetterASM(String FieldName){
        return "push "+getFieldByteIndex(FieldName)+" push "+getFieldSize(FieldName)+" get ";
    }

    // expects [Data][Struct Address] on stack
    public String generateFieldSetterASM(String FieldName){
        return "push "+getFieldByteIndex(FieldName)+" push "+getFieldSize(FieldName)+" set ";
    }

    // push this struct zeroed onto the stack
    public String generateAllocatorASM(){
        return " push "+getSize()+" alloc ";
    }
}
