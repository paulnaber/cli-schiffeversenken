package battleship;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameIntegrationTest {
    private Process        process;
    private BufferedWriter inputWriter;
    private BufferedReader outputReader;

    @BeforeEach
    public void setUp() throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "java", "-cp", "target/classes", "battleship.Main");
        builder.redirectErrorStream(true);
        process = builder.start();
        inputWriter = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    }



    @AfterEach
    public void tearDown() throws IOException {
        if (process != null) {
            process.destroy();
        }
        if (inputWriter != null) {
            inputWriter.close();
        }
        if (outputReader != null) {
            outputReader.close();
        }
    }



    @Test
    public void testGameFlow() throws Exception {
        // Helper to read and assert a single line
        java.util.function.Consumer<String> assertNextLine = expected -> {
            try {
                String line = outputReader.readLine();
                System.out.println(line); // Debug
                assertTrue(line != null && (line.trim().equals(expected) || line.contains(expected)),
                        "Expected: " + expected + ", but got: " + line);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        // Step-by-step manual test (first few actions as example)
        assertNextLine.accept("Player 1, place your ships on the game field");
        assertNextLine.accept("  1 2 3 4 5 6 7 8 9 10");
        assertNextLine.accept("A ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("Enter the coordinates of the Aircraft Carrier (5 cells):");
        inputWriter.write("A1 A5\n");
        inputWriter.flush();
        assertNextLine.accept("  1 2 3 4 5 6 7 8 9 10");
        assertNextLine.accept("A O O O O O ~ ~ ~ ~ ~");
        assertNextLine.accept("B ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("C ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("D ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("E ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("F ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("G ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("H ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("I ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
        assertNextLine.accept("J ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
    }
}
