package com.bradyrussell.uiscoin.ide;

import com.bradyrussell.uiscoin.ide.compiler.TestCompilationContext;
import com.bradyrussell.uiscoin.ide.compiler.TestCompilerPass;
import com.bradyrussell.uiscoin.script.ScriptParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// @ is the new * pointer, valueAt operator
// $ is the new & reference, addressOf operator

// byte myByte = 'A';
// byte@ myBytePointer = $myByte;

// this helps remove ambiguity from the grammar

public class Main {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Please specify a script to compile.");
            System.exit(1);
        }

        String ScriptLines = null;
        try {
           ScriptLines = Files.readString(Path.of(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }

        ArrayList<String> Tokens = ScriptParser.GetTokensFromString(ScriptLines, false);

        System.out.println(Tokens);

        try {
            TestCompilationContext compilationContext = new TestCompilerPass(Tokens, new TestCompilationContext()).applyPass();

            System.out.println(compilationContext);
        } catch (CompilerErrorException e) {
            e.printStackTrace();
        }
    }
}
