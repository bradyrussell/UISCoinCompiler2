package com.bradyrussell.uiscoin.ide.compiler;

import com.bradyrussell.uiscoin.ide.CompilerErrorException;

import java.util.ArrayList;

public abstract class CompilerPassBase<T extends CompilationContextBase> {
    ArrayList<String> Tokens;
    int CurrentToken = -1;
    T Context;

    public CompilerPassBase(ArrayList<String> tokens, T context) {
        Tokens = tokens;
        Context = context;
    }

    //public abstract boolean expect(String Token);
    public abstract boolean accept(String Token) throws CompilerErrorException;

    public String peekToken(int Offset){
        return Tokens.get(CurrentToken+Offset);
    }

    public String popNextToken(){
        if(CurrentToken+1 >= Tokens.size()) return "\n"; // force expected semicolon at EOF
        return Tokens.get(++CurrentToken);
    }

    public T applyPass() throws CompilerErrorException {
        while(CurrentToken+1 < Tokens.size()) {
            accept(popNextToken());
        }
        return Context;
    }
}
