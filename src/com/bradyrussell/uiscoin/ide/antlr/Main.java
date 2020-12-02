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
        ASMUtil.bNoComments = true;

        UISCLexer lexer = new UISCLexer(new ANTLRInputStream(Files.readString(Path.of("fib.uisc"))));
        UISCParser parser = new UISCParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.file();

        ASMGenerationVisitor asmGenerationVisitor = new ASMGenerationVisitor();
        String asm = asmGenerationVisitor.visit(tree);

        String allocation = asmGenerationVisitor.Global.getRecursiveAllocation()+ "\n" + asm;

        String optimized = allocation.replace("push [1]", "true").replace("push [0]", "false").replace("true gotoif", "goto").replace("convert32to8 convert8to32","");
        String zippedASM = "0x"+BytesUtil.bytesToHex(ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASMUtil.generateExecuteZippedASM(optimized), true)));
        String compiledOptimized = "0x"+BytesUtil.bytesToHex(ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(optimized, true)));

        System.out.println("\n\nGenerated Assembly: \n"+allocation+"\n");

        System.out.println("\n\nOptimized Bytecode "+(zippedASM.length() < compiledOptimized.length() ? "(Packed, Flags Not Visible!) "+zippedASM.length()+" bytes" : compiledOptimized.length()+" bytes")+": \n"+ (zippedASM.length() >= compiledOptimized.length() ? compiledOptimized : zippedASM) +"\n");
/*        ParseTreeWalker.DEFAULT.walk(new TestUISCListener(), tree);*/
    }
}
