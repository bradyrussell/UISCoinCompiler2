package com.bradyrussell.uiscoin.ide;

import com.bradyrussell.uiscoin.ide.grammar.Type;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeBase;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeGlobal;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeLocal;

import java.util.ArrayList;

public class deprScriptCompiler {
    ScopeGlobal Global = new ScopeGlobal(null);
    ArrayList<String> InputTokens;

    ScopeLocal CurrentLocalScope = null;

    ScopeBase getCurrentScope(){
        return CurrentLocalScope == null ? Global : CurrentLocalScope;
    }

    void PushLocalScope(){
        if(CurrentLocalScope == null) {
            CurrentLocalScope = new ScopeLocal(Global);
            Global.Children.add(CurrentLocalScope);
        } else {
            ScopeLocal parent = CurrentLocalScope;
            CurrentLocalScope = new ScopeLocal(parent);
            parent.Children.add(CurrentLocalScope);
        }
    }

    void PopLocalScope(){
        if(CurrentLocalScope.Parent instanceof ScopeLocal) CurrentLocalScope = (ScopeLocal) CurrentLocalScope.Parent;
        CurrentLocalScope = null;
    }

    public deprScriptCompiler(ArrayList<String> inputTokens) {
        InputTokens = inputTokens;
    }

    // i felt that having this as individual if statements with continues was more readable than an if elseif chain
    void BuildSymbolTable() throws CompilerErrorException {
        for (int i = 0; i < InputTokens.size(); i++) {

            // type declaration   Type Name -> int32 MyInt
            Type type = Type.getByKeyword(InputTokens.get(i));
            if (type != null) {
                String identifierName = InputTokens.get(++i);

                if(!isValidIdentifierName(identifierName)) throw new CompilerErrorException("Invalid identifier: "+identifierName);

                // either declaration or declaration & initialization
                String nextToken = InputTokens.get(++i);
                if(nextToken.charAt(0) == ';') {// declaration     int32 MyInt;
                    System.out.println("DECLARE VAR "+identifierName+" of type "+type);
                    getCurrentScope().declareSymbol(identifierName, type);
                    continue;
                }

                if(nextToken.charAt(0) == '=') { // declaration and initialization   int32 MyInt = 10;
                    String assignRvalue = InputTokens.get(++i);

                    System.out.println("INITIALIZE VAR "+identifierName+" = "+assignRvalue+" of type "+type);
                    getCurrentScope().declareSymbol(identifierName, type);

                    i++;//skip the ;
                    continue;
                }

                throw new CompilerErrorException("Unexpected token: "+nextToken);
            }

            // assignment   Name = Expr  ->   MyInt = 5+5;
           if(isValidIdentifierName(InputTokens.get(i)) && getCurrentScope().symbolTable.containsKey(InputTokens.get(i))) {
               String identifierName = InputTokens.get(i);
               String nextToken = InputTokens.get(++i);
               if(nextToken.charAt(0) == '=') {// declaration     int32 MyInt;
                   String rValue = InputTokens.get(++i);
                   System.out.println("ASSIGN VAR "+identifierName+" value "+rValue);
                   //getCurrentScope().declareSymbol(identifierName, type);
                   continue;
               }
           } else {
               throw isValidIdentifierName(InputTokens.get(i)) ? new CompilerErrorException("Unknown identifier: "+InputTokens.get(i)) : new CompilerErrorException("Invalid identifier: "+InputTokens.get(i));
           }

        }
    }

    public static boolean isValidIdentifierName(String Token){
        char[] charArray = Token.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //if (Character.isDigit(charArray[i]) && i == 0) return false; // cannnot begin with digit
            if (!Character.isJavaIdentifierStart(charArray[i]) && i == 0) return false;
            if (!Character.isJavaIdentifierPart(charArray[i])) return false;
        }
        return true;
    }
}
