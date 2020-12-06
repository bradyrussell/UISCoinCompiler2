import com.bradyrussell.uiscoin.BytesUtil;
import com.bradyrussell.uiscoin.ide.antlr.ASMGenerationVisitor;
import com.bradyrussell.uiscoin.ide.antlr.ASMUtil;
import com.bradyrussell.uiscoin.ide.antlr.UISCLexer;
import com.bradyrussell.uiscoin.ide.antlr.UISCParser;
import com.bradyrussell.uiscoin.script.ScriptExecution;
import com.bradyrussell.uiscoin.script.ScriptParser;
import com.bradyrussell.uiscoin.script.exception.ScriptEmptyStackException;
import com.bradyrussell.uiscoin.script.exception.ScriptInvalidException;
import com.bradyrussell.uiscoin.script.exception.ScriptInvalidParameterException;
import com.bradyrussell.uiscoin.script.exception.ScriptUnsupportedOperationException;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class CompilerTest {
    @Test
    public void Test_BasicMathExpression(){
        String Script =
                "int32 x = 500 * 700 + 200 * 900 / 400 + 120;\n"+
                "int32 y = x * x;";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 5, 89, 106] [-99, 94, -33, -28]");
    }

    @Test
    public void Test_ArrayAccess(){
        String Script =
                "byte a[] = {1, 2, 3, 4};\n"+
                "byte b = a[3];";

        System.out.println(ASMUtil.compileHLLToASM(Script));
        performStandardTests(ASMUtil.compileHLLToASM(Script), "[1, 2, 3, 4] [4]");
    }

    @Test
    public void Test_ArrayElementAssignment(){
        String Script =
                "byte z = 6;\n"+
                "byte a[] = {1, 2, 3, 4};\n"+
                "a[2] = z;";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[6] [1, 2, 6, 4]");
    }

    @Test
    public void Test_AutoWidening(){
        String Script =
                "byte a = 64;\n"+
                "int32 b = a;\n"+
                "float c = b;\n"+
                "int64 d = b;\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[64] [0, 0, 0, 64] [66, -128, 0, 0] [0, 0, 0, 0, 0, 0, 0, 64]");
    }

    @Test
    public void Test_Casting(){
        String Script =
                "int64 a = 64;\n"+
                "int32 b = (int32)a;\n"+
                "float c = b;\n"+
                "byte d = (byte)b;\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 0, 0, 0, 0, 64] [0, 0, 0, 64] [66, -128, 0, 0] [64]");
    }

    @Test
    public void Test_Natives(){ // todo fix void casts
        String Script =
                "byte m[] = \"Hello world!\";\n" +
                "byte k[] = \"encryptionKey\";\n" +
                "void o = (void)_encrypt(m, k);\n" +
                "asm(\"/* my asm comment */\");\n" +
                "o = (void)_decrypt(_encrypt(m, k), k);\n" +
                "o = (void)_zip(_decrypt(_encrypt(m, k), k));\n" +
                "o = (void)_unzip(_zip(_decrypt(_encrypt(m, k), k)));";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33] [101, 110, 99, 114, 121, 112, 116, 105, 111, 110, 75, 101, 121] [72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33]");
    }

    private void performStandardTests(String allocation, String expectedOutput) {
        String optimized = ASMUtil.performBasicOptimizations(allocation);

        byte[] originalBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(allocation, true));
        byte[] optimizedBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(optimized, true));
        byte[] optimizedZippedBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASMUtil.generateExecuteZippedASM(optimized), true));

        boolean bNoOptimization = Arrays.equals(originalBytecode,optimizedBytecode);

        ScriptExecution originalScriptExecution = new ScriptExecution();
        ScriptExecution optimizedScriptExecution = new ScriptExecution();
        ScriptExecution optimizedZippedScriptExecution = new ScriptExecution();

        originalScriptExecution.Initialize(originalBytecode);
        optimizedScriptExecution.Initialize(optimizedBytecode);
        optimizedZippedScriptExecution.Initialize(optimizedZippedBytecode);

        try{
            while (originalScriptExecution.Step());
        }catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException e){
            fail(e);
        }

        System.out.println("Original script execution: "+(originalScriptExecution.bScriptFailed ? "FAIL":"PASS"));
        assertFalse(originalScriptExecution.bScriptFailed);

        if(!bNoOptimization){
            try{
                while (optimizedScriptExecution.Step());
            }catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException e){
                fail(e);
            }

            System.out.println("Optimized script execution: "+(optimizedScriptExecution.bScriptFailed ? "FAIL":"PASS"));
            assertFalse(optimizedScriptExecution.bScriptFailed);
        }

        try{
            while (optimizedZippedScriptExecution.Step());
        }catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException e){
            fail(e);
        }

        System.out.println("Optimized / Zipped script execution: "+(optimizedZippedScriptExecution.bScriptFailed ? "FAIL":"PASS"));
        assertFalse(optimizedZippedScriptExecution.bScriptFailed);

        System.out.println("Original script output: "+originalScriptExecution.getStackContents().replace("\n"," "));
        if(!bNoOptimization) System.out.println("Optimized script output: "+optimizedScriptExecution.getStackContents().replace("\n"," "));
        System.out.println("Optimized / Zipped script output: "+optimizedZippedScriptExecution.getStackContents().replace("\n"," "));

        if(!bNoOptimization) System.out.println("Original & Optimized output matches: "+(originalScriptExecution.getStackContents().equals(optimizedScriptExecution.getStackContents())));
        System.out.println("Original & Zipped / Optimized output matches: "+(originalScriptExecution.getStackContents().equals(optimizedZippedScriptExecution.getStackContents())));

        if(!bNoOptimization) assertEquals(optimizedScriptExecution.getStackContents(), originalScriptExecution.getStackContents());
        assertEquals(optimizedZippedScriptExecution.getStackContents(), originalScriptExecution.getStackContents());

        if(expectedOutput != null) {
            assertEquals(expectedOutput, originalScriptExecution.getStackContents().replace("\n"," ").trim());
            if (!bNoOptimization) assertEquals(optimizedScriptExecution.getStackContents().replace("\n"," ").trim(), expectedOutput);
            assertEquals(expectedOutput, optimizedZippedScriptExecution.getStackContents().replace("\n"," ").trim());
        }

        System.out.println();
        System.out.println("Original Bytecode: "+originalBytecode.length+" bytes.");
        if(!bNoOptimization) System.out.println("Optimized Bytecode: "+optimizedBytecode.length+" bytes."); else
            System.out.println("Optimized bytecode was the same as original.");
        System.out.println("Optimized & Zipped Bytecode: "+optimizedZippedBytecode.length+" bytes.");
    }

}
