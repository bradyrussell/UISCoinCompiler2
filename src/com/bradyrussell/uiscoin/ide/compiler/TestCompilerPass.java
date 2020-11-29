package com.bradyrussell.uiscoin.ide.compiler;

import com.bradyrussell.uiscoin.ide.CompilerErrorException;
import com.bradyrussell.uiscoin.ide.grammar.Type;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeBase;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeLocal;
import com.bradyrussell.uiscoin.ide.symboltable.SymbolBase;
import com.bradyrussell.uiscoin.ide.symboltable.ScopeWithSymbol;

import java.util.ArrayList;

public class TestCompilerPass extends CompilerPassBase<TestCompilationContext> {
    public TestCompilerPass(ArrayList<String> tokens, TestCompilationContext context) {
        super(tokens, context);
    }

    private void expectSemicolon(String ExpectedAfter) throws CompilerErrorException {
        if(popNextToken().charAt(0) != ';')  throw new CompilerErrorException("Expected semicolon after: "+ExpectedAfter+" at "+CurrentToken+".");
    }

    ScopeLocal currentFunctionScope = null;

    @Override
    public boolean accept(String Token) throws CompilerErrorException {
        Type type = Type.getByKeyword(Token);
        if (type != null) {
            String identifierName = popNextToken();

            if(!isValidIdentifierName(identifierName)) throw new CompilerErrorException("Invalid identifier: "+identifierName);

            // either declaration or declaration & initialization or function definition
            String nextToken = popNextToken();
            if(nextToken.charAt(0) == ';') {// declaration     int32 MyInt;
                System.out.println("DECLARE VAR "+identifierName+" of type "+type);
                Context.getCurrentScope().declareSymbol(identifierName, type);
                //expectSemicolon(identifierName);
                return true;
            }

            if(nextToken.charAt(0) == '=') { // declaration and initialization   int32 MyInt = 10;
                String assignRvalue = popNextToken();

                System.out.println("INITIALIZE VAR "+identifierName+" = "+assignRvalue+" of type "+type);
                Context.getCurrentScope().declareSymbol(identifierName, type);

                expectSemicolon(assignRvalue);
                return true;
            }

            if(nextToken.charAt(0) == '(') {// function definition      int32 myFunction(int32 myParameter, byte secondParameter) { ... }
                System.out.println("DEFINE FUNCTION "+identifierName+" of type "+type);
             //   currentFunctionScope = Context.getCurrentScope().defineFunction(identifierName, type);

                // parameter list
                //////////////////////////////////////////////////////
                String nextNextToken = popNextToken();
                while (nextNextToken.charAt(0) != ')') {
                    //accept parameter
                    Type parameterType = Type.getByKeyword(nextNextToken);
                    if (parameterType != null) {
                        String parameterName = popNextToken();

                        if (!isValidIdentifierName(parameterName))
                            throw new CompilerErrorException("Invalid identifier: " + parameterName);

                        String commaToken = popNextToken();
                        if (commaToken.charAt(0) == ',') {// declaration     int32 MyInt;
                            System.out.println("FUNCTION PARAMETER " + parameterName + " of type " + parameterType);
                            currentFunctionScope.declareSymbol(parameterName, type);
                            nextNextToken = popNextToken();
                            continue;
                        }else if (commaToken.charAt(0) == ')') {// declaration     int32 MyInt;
                            System.out.println("FUNCTION PARAMETER " + parameterName + " of type " + parameterType);
                            currentFunctionScope.declareSymbol(parameterName, type);
                            break;
                        }
                        else {
                            throw new CompilerErrorException("Unexpected token : "+commaToken);
                        }

                    }
                    throw new CompilerErrorException("Expected type, found : "+nextNextToken);
                }
                ///////////////////////////////////////////
                return true;
            }

            throw new CompilerErrorException("Unexpected token: "+nextToken);
        }

        // function body
        if(Token.charAt(0) == '{'){
            // list of statements
            String nextToken = popNextToken();
            while(nextToken.charAt(0) != '}') {
                System.out.println("FUNCTION STATEMENT TOKEN: "+nextToken);
                nextToken = popNextToken();
            }

            return true;
        }

        // line comment
        if(Token.charAt(0) == '/'){
            String nextToken = popNextToken();
            while (nextToken.charAt(0) != '\n') nextToken = popNextToken();
        }

        // block comment
        if(Token.startsWith("/*")){
            String nextToken = popNextToken();
            while (!nextToken.endsWith("*/")) nextToken = popNextToken();
        }

        // assignment   Name = Expr  ->   MyInt = 5+5;
        if(isValidIdentifierName(Token) && Context.getCurrentScope().hasSymbol(Token)) {
            String nextToken = popNextToken();
            if(nextToken.charAt(0) == '=') {
                String rValue = popNextToken();

                ScopeBase scopeContainingVariable = Context.getCurrentScope().findScopeContaining(Token);
                if(scopeContainingVariable == null) throw new CompilerErrorException("Undeclared symbol: "+Token);
                Object symbol = scopeContainingVariable.getSymbol(Token);
                if(symbol instanceof ScopeWithSymbol) throw new CompilerErrorException("Cannot assign value to function: "+Token);

                System.out.println("ASSIGN VAR "+ Token +" value "+rValue+" type "+((SymbolBase)symbol).type);

                expectSemicolon(rValue);
                return true;
            }
        } else {
            throw isValidIdentifierName(Token) ? new CompilerErrorException("Unknown identifier: "+Token) : new CompilerErrorException("Invalid identifier: "+Token);
        }

        return false;
    }

    public static boolean isValidIdentifierName(String Token){
        if(Type.getByKeyword(Token) != null) return false;

        char[] charArray = Token.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            //if (Character.isDigit(charArray[i]) && i == 0) return false; // cannnot begin with digit
            if (!Character.isJavaIdentifierStart(charArray[i]) && i == 0) return false;
            if (!Character.isJavaIdentifierPart(charArray[i])) return false;
        }
        return true;
    }


}
