package com.bradyrussell.uiscoin.ide.antlr;

import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.script.ScriptBuilder;
import com.bradyrussell.uiscoin.script.ScriptParser;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        UISCLexer lexer = new UISCLexer(new ANTLRInputStream(Files.readString(Path.of("fib.uisc"))));
        UISCParser parser = new UISCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.file();

        ASMGenerationVisitor asmGenerationVisitor = new ASMGenerationVisitor();
        String asm = asmGenerationVisitor.visit(tree);

        String allocation = asmGenerationVisitor.Global.getRecursiveAllocation()+ "\n" + asm;

        System.out.println("\n\nGenerated Assembly: \n"+allocation/*.replace("push [1]", "true").replace("push [0]", "false")*/+"\n");

/*        ParseTreeWalker.DEFAULT.walk(new TestUISCListener(), tree);*/
    }
}
