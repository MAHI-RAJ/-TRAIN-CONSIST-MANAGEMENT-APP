import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testSafeCargoAssignment() {
        GoodsBogie bogie = new GoodsBogie("GB-101", "Cylindrical");
        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.getCurrentCargo());
    }

    @Test
    void testUnsafeCargoAssignmentDoesNotChangeCargo() {
        GoodsBogie bogie = new GoodsBogie("GB-202", "Rectangular");
        bogie.assignCargo("Petroleum");

        assertEquals("None", bogie.getCurrentCargo());
    }

    @Test
    void testProgramContinuesAfterExceptionAndAllowsNextValidAssignment() {
        GoodsBogie bogie = new GoodsBogie("GB-202", "Rectangular");

        bogie.assignCargo("Petroleum");
        bogie.assignCargo("Grain");

        assertEquals("Grain", bogie.getCurrentCargo());
    }

    @Test
    void testMainDisplaysHeaderAndFinalSummary() {
        OutputResult result = runMainAndCaptureOutput();
        String output = result.stdout + result.stderr;

        assertTrue(output.contains("=== Train Consist Management System (UC15: Structured Exception Handling) ==="));
        assertTrue(output.contains("--- FINAL CONSIST INVENTORY ---"));
        assertTrue(output.contains("Bogie GB-101 Status: Petroleum"));
        assertTrue(output.contains("Bogie GB-202 Status: Grain"));
        assertTrue(output.contains("System execution finished successfully."));
    }

    @Test
    void testMainDisplaysSafeAssignmentMessage() {
        OutputResult result = runMainAndCaptureOutput();
        String output = result.stdout + result.stderr;

        assertTrue(output.contains(">>> Initiating Safety Check for Bogie: GB-101 [Cylindrical]"));
        assertTrue(output.contains("SUCCESS: Petroleum has been safely loaded into GB-101."));
        assertTrue(output.contains("LOG: Cargo assignment validation cycle finished for GB-101."));
    }

    @Test
    void testMainDisplaysExceptionMessageForUnsafeAssignment() {
        OutputResult result = runMainAndCaptureOutput();
        String output = result.stdout + result.stderr;

        assertTrue(output.contains(">>> Initiating Safety Check for Bogie: GB-202 [Rectangular]"));
        assertTrue(output.contains("EXCEPTION CAUGHT: CRITICAL SAFETY VIOLATION: Petroleum cannot be assigned to Rectangular bogies!"));
        assertTrue(output.contains("STATUS: Assignment blocked. Bogie remains empty/unchanged."));
        assertTrue(output.contains("LOG: Cargo assignment validation cycle finished for GB-202."));
    }

    @Test
    void testMainDisplaysSuccessfulAssignmentAfterFailure() {
        OutputResult result = runMainAndCaptureOutput();
        String output = result.stdout + result.stderr;

        assertTrue(output.contains("SUCCESS: Grain has been safely loaded into GB-202."));
    }

    private OutputResult runMainAndCaptureOutput() {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayOutputStream errStream = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        System.setOut(new PrintStream(outStream));
        System.setErr(new PrintStream(errStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        return new OutputResult(outStream.toString(), errStream.toString());
    }

    static class OutputResult {
        String stdout;
        String stderr;

        OutputResult(String stdout, String stderr) {
            this.stdout = stdout;
            this.stderr = stderr;
        }
    }
}
