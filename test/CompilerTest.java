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
    public void Test_StructElementAssign(){
        String Script =
                "struct test {\n" +
                        "    int32 a;\n" +
                        "    int64 b;\n" +
                        "    int32 c[4];\n" +
                        "    byte d[12];\n" +
                        "}\n" +
                        "\n" +
                        "test myTest;\n" +
                        "\n" +
                        "myTest.a = 6;\n" +
                        "myTest.b = 12;\n" +
                        "myTest.c[0] = 1;\n" +
                        "myTest.c[1] = 2;\n" +
                        "myTest.c[2] = 3;\n" +
                        "myTest.c[3] = 4;\n" +
                        "myTest.d[0] = -1;\n" +
                        "myTest.d[1] = -2;\n" +
                        "myTest.d[2] = -3;\n" +
                        "myTest.d[3] = -4;\n" +
                        "myTest.d[4] = -5;\n" +
                        "myTest.d[5] = -6;\n" +
                        "myTest.d[6] = -7;\n" +
                        "myTest.d[7] = -8;\n" +
                        "myTest.d[8] = -9;\n" +
                        "myTest.d[9] = -10;\n" +
                        "myTest.d[10] = -11;\n" +
                        "myTest.d[11] = -12;\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 1, 0, 0, 0, 2, 0, 0, 0, 3, 0, 0, 0, 4, -1, -2, -3, -4, -5, -6, -7, -8, -9, -10, -11, -12]");
    }

    @Test
    public void Test_StructElemAccess(){
        String Script =
                "struct test {\n" +
                "    int32 a;\n" +
                "    int64 b;\n" +
                "    int32 c[4];\n" +
                "}\n" +
                "\n" +
                "test myTest;\n" +
                "\n" +
                "myTest.a = 10;\n" +
                "myTest.b = myTest.a * 5;\n" +
                "ufori(4 as int32 i){\n" +
                "    myTest.c[i] = ((int32)myTest.b) + i;\n" +
                "}";

        performStandardTests(ASMUtil.compileHLLToASM(Script), null);
    }

    @Test
    public void Test_OpAndAssignment(){
        String Script =
                "int32 a = 123;\n" +
                "int32 b = 6;\n" +
                "a += b;\n" +
                "a -= b;\n" +
                "a *= b;\n" +
                "a /= b;\n" +
                "a &= b;\n" +
                "a |= b;\n" +
                "//a ^= b;";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[0, 0, 0, 6] [0, 0, 0, 6]");
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
                "o = (void)_unzip(_zip(_decrypt(_encrypt(m, k), k)));\n" +
                "_copy($m, (int32)0, $k, (int32)0, (int32)2);\n";

        performStandardTests(ASMUtil.compileHLLToASM(Script), "[72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33] [72, 101, 99, 114, 121, 112, 116, 105, 111, 110, 75, 101, 121] [72, 101, 108, 108, 111, 32, 119, 111, 114, 108, 100, 33]");
    }

    @Test
    public void Test_SyntaxMarkup() {
        String Script =
                "struct test {\n" +
                        "    int32 a;\n" +
                        "    int64 b;\n" +
                        "    int32 c[4];\n" +
                        "}\n" +
                        "\n" +
                        "test myTest;\n" +
                        "\n" +
                        "myTest.a = 10;\n" +
                        "myTest.b = myTest.a * 5;\n" +
                        "ufori(4 as int32 i){\n" +
                        "    myTest.c[i] = ((int32)myTest.b) + i;\n" +
                        "}\n" +
                        "int64 square(int64 a) {\n\treturn a * a;\n}\nint64 b = @square((int64)2);\n" +
                        "byte m[] = \"Hello world!\";\n" +
                        "byte k[] = \"encryptionKey\";\n" +
                        "void o = (void)_encrypt(m, k);\n" +
                        "asm(\"/* my asm comment */\");\n" +
                        "o = (void)_decrypt(_encrypt(m, k), k);\n" +
                        "o = (void)_zip(_decrypt(_encrypt(m, k), k));\n" +
                        "o = (void)_unzip(_zip(_decrypt(_encrypt(m, k), k)));\n" +
                        "_copy($m, (int32)0, $k, (int32)0, (int32)2);\n";
        System.out.println(ASMUtil.compileHLLToSyntaxMarkup(Script));
    }

    private void performStandardTests(String allocation, String expectedOutput) {
        String optimized = ASMUtil.performBasicOptimizations(allocation);

        byte[] originalBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(allocation, true));
        byte[] optimizedBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(optimized, true));
        byte[] optimizedZippedBytecode = ScriptParser.CompileScriptTokensToBytecode(ScriptParser.GetTokensFromString(ASMUtil.generateExecuteZippedASM(optimized), true));

        System.out.println(Arrays.toString(optimizedBytecode));
        System.out.println(Arrays.toString(optimizedZippedBytecode));

        boolean bNoOptimization = Arrays.equals(originalBytecode,optimizedBytecode);

        ScriptExecution originalScriptExecution = new ScriptExecution();
        ScriptExecution optimizedScriptExecution = new ScriptExecution();
        ScriptExecution optimizedZippedScriptExecution = new ScriptExecution();

        originalScriptExecution.initialize(originalBytecode);
        optimizedScriptExecution.initialize(optimizedBytecode);
        optimizedZippedScriptExecution.initialize(optimizedZippedBytecode);

        try{
            while (originalScriptExecution.step());
        }catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException e){
            fail(e);
        }

        System.out.println("Original script execution: "+(originalScriptExecution.bScriptFailed ? "FAIL":"PASS"));
        assertFalse(originalScriptExecution.bScriptFailed);

        if(!bNoOptimization){
            try{
                while (optimizedScriptExecution.step());
            }catch (ScriptInvalidException | ScriptEmptyStackException | ScriptInvalidParameterException | ScriptUnsupportedOperationException e){
                fail(e);
            }

            System.out.println("Optimized script execution: "+(optimizedScriptExecution.bScriptFailed ? "FAIL":"PASS"));
            assertFalse(optimizedScriptExecution.bScriptFailed);
        }

        try{
            while (optimizedZippedScriptExecution.step());
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
