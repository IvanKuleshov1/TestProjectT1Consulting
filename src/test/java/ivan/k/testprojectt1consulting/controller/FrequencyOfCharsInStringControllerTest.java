package ivan.k.testprojectt1consulting.controller;

import ivan.k.testprojectt1consulting.service.FrequencyOfCharsInStringService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FrequencyOfCharsInStringControllerTest {

    private final FrequencyOfCharsInStringService frequencyService = mock(FrequencyOfCharsInStringService.class);
    private final FrequencyOfCharsInStringController controller = new FrequencyOfCharsInStringController(frequencyService);

    @Test
    void calculateFrequency_NonEmptyString_Success() {
        // Мокаем сервис, чтобы вернуть ожидаемый результат
        when(frequencyService.calculateFrequency("test")).thenReturn(Map.of('t', 2L, 'e', 1L, 's', 1L));

        ResponseEntity<Map<Character, Long>> responseEntity = controller.calculateFrequency("test");

        // Проверяем, что результат корректный
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(2, responseEntity.getBody().get('t'));
        assertEquals(1, responseEntity.getBody().get('e'));
        // Другие проверки
    }

    @Test
    void calculateFrequency_EmptyString_NoContent() {
        // Мокаем сервис, чтобы вернуть пустой результат
        when(frequencyService.calculateFrequency("  ")).thenReturn(Map.of());

        ResponseEntity<Map<Character, Long>> responseEntity = controller.calculateFrequency("");

        // Проверяем, что возвращается статус NO_CONTENT
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

    @Test
    void calculateFrequency_NullString_NoContent() {
        // Мокаем сервис, чтобы вернуть пустой результат
        when(frequencyService.calculateFrequency(null)).thenReturn(Map.of());

        ResponseEntity<Map<Character, Long>> responseEntity = controller.calculateFrequency(null);

        // Проверяем, что возвращается статус NO_CONTENT
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }

}
