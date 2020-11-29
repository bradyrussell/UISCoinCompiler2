package com.bradyrussell.uiscoin.ide.symboltable;

import com.bradyrussell.uiscoin.ide.grammar.Type;

import java.util.ArrayList;
import java.util.HashMap;

public class SymbolFunction extends SymbolBase{
    HashMap<String, Type> parameters = new HashMap<>();
    ArrayList<String> parameterOrder = new ArrayList<>();

    public boolean defineParameter(String Name, Type ParameterType){
        if(parameters.containsKey(Name)) return false;
        parameters.put(Name,ParameterType);
        parameterOrder.add(Name);
        return true;
    }

    public SymbolFunction(Type type, int address) {
        super(type, address);
    }

    public Type getTypeOfParameter(String Name){
        return parameters.get(Name);
    }

    public Type getTypeOfParameter(int Index){
        return parameters.get(getNameOfParameter(Index));
    }


    public String getNameOfParameter(int Index){
        return parameterOrder.get(Index);
    }

    public int getNumberOfParameters(){
        return parameters.size();
    }

}
