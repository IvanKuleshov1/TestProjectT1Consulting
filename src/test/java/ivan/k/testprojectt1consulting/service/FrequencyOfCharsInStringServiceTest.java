package ivan.k.testprojectt1consulting.service;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class FrequencyOfCharsInStringServiceTest {

    private final FrequencyOfCharsInStringService frequencyService = new FrequencyOfCharsInStringService();

    @Test
    void testCalculateFrequencyWithValidInput() {
        String input = "abcaab";
        Map<Character, Long> result = frequencyService.calculateFrequency(input);

        assertNotNull(result);
        assertEquals(3, result.get('a'));
        assertEquals(2, result.get('b'));
        assertEquals(1, result.get('c'));
    }

    @Test
    void testCalculateFrequencyWithEmptyInput() {
        String input = "";
        Map<Character, Long> result = frequencyService.calculateFrequency(input);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCalculateFrequencyWithNullInput() {
        String input = null;
        Map<Character, Long> result = frequencyService.calculateFrequency(input);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testCalculateFrequencyWithSpaceInput() {
        String input = "   ";
        Map<Character, Long> result = frequencyService.calculateFrequency(input);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}