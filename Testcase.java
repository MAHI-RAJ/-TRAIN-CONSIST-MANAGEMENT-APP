import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainTest {

    @Test
    void testFilterBogiesByCapacity_returnsOnlyBogiesAboveThreshold() {
        List<Train.Bogie> bogies = new ArrayList<>();
        bogies.add(new Train.Bogie("Sleeper", 72));
        bogies.add(new Train.Bogie("AC Chair", 56));
        bogies.add(new Train.Bogie("First Class", 24));
        bogies.add(new Train.Bogie("General Coach", 90));

        int threshold = 60;

        List<Train.Bogie> result = Train.filterBogiesByCapacity(bogies, threshold);

        assertEquals(2, result.size());
        assertEquals("Sleeper", result.get(0).getName());
        assertEquals("General Coach", result.get(1).getName());
    }

    @Test
    void testFilterBogiesByCapacity_returnsEmptyListWhenNoMatch() {
        List<Train.Bogie> bogies = new ArrayList<>();
        bogies.add(new Train.Bogie("AC Chair", 56));
        bogies.add(new Train.Bogie("First Class", 24));

        int threshold = 100;

        List<Train.Bogie> result = Train.filterBogiesByCapacity(bogies, threshold);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilterBogiesByCapacity_returnsEmptyListForEmptyInput() {
        List<Train.Bogie> bogies = new ArrayList<>();

        List<Train.Bogie> result = Train.filterBogiesByCapacity(bogies, 50);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilterBogiesByCapacity_originalListRemainsUnchanged() {
        List<Train.Bogie> bogies = new ArrayList<>();
        bogies.add(new Train.Bogie("Sleeper", 72));
        bogies.add(new Train.Bogie("AC Chair", 56));
        bogies.add(new Train.Bogie("First Class", 24));

        int originalSize = bogies.size();

        List<Train.Bogie> result = Train.filterBogiesByCapacity(bogies, 60);

        assertEquals(originalSize, bogies.size());
        assertEquals(3, bogies.size());
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).getName());
    }

    @Test
    void testFilterBogiesByCapacity_doesNotIncludeEqualCapacity() {
        List<Train.Bogie> bogies = new ArrayList<>();
        bogies.add(new Train.Bogie("Sleeper", 60));
        bogies.add(new Train.Bogie("General Coach", 61));

        List<Train.Bogie> result = Train.filterBogiesByCapacity(bogies, 60);

        assertEquals(1, result.size());
        assertEquals("General Coach", result.get(0).getName());
    }
}
