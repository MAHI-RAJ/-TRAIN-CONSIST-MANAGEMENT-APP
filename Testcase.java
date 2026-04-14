import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainTest {

    @Test
    void testMainDisplaysGoodsBogies() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Goods Bogies in Train:"));
        assertTrue(output.contains("GoodsBogie{type='Cylindrical', cargo='Petroleum'}"));
        assertTrue(output.contains("GoodsBogie{type='Open', cargo='Coal'}"));
        assertTrue(output.contains("GoodsBogie{type='Box', cargo='Grain'}"));
    }

    @Test
    void testMainDisplaysSafetyComplianceMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Safety Compliance Check:"));
        assertTrue(output.contains("Train is safety compliant."));
    }

    @Test
    void testMainDisplaysProgramContinuesMessage() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try {
            Train.main(new String[]{});
        } finally {
            System.setOut(originalOut);
        }

        String output = outputStream.toString();

        assertTrue(output.contains("Program continues..."));
    }
}
