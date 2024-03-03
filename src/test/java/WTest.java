import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WTest {

    private static final String SOURCE_FILE = "src/main/java/W.java";

    private PrintStream oldOut;
    private ByteArrayOutputStream testOutput;

    @BeforeEach
    void setup() {
        testOutput = new ByteArrayOutputStream();
        oldOut = System.out;
        System.setOut(new PrintStream(testOutput));
    }

    @AfterEach
    void cleanup() {
        System.setOut(oldOut);
    }

    @Test
    void Java_21_source_code_outputs_itself() throws Exception {

        // Given

        var sourceFile = new File(SOURCE_FILE);
        String source = Files.readString(sourceFile.toPath(), StandardCharsets.UTF_8);

        Class<?> classW = Class.forName("W");
        Object objW = classW.getDeclaredConstructor().newInstance();
        Method main = classW.getDeclaredMethod("main");

        // When

        main.invoke(objW);

        // Then

        assertEquals(source, testOutput.toString(StandardCharsets.UTF_8));
    }

    @Test
    void file_length_is_shortest_Java_21_code_that_outputs_itself() {

        // Given

        var sourceFile = new File(SOURCE_FILE);

        // When

        var length = sourceFile.length();

        // Then

        assertEquals(102, length);
    }
}