package ivan.k.testprojectt1consulting.controller;

import ivan.k.testprojectt1consulting.service.FrequencyOfCharsInStringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import java.util.Map;

@RestController

public class FrequencyOfCharsInStringController {


    private final FrequencyOfCharsInStringService frequencyService;

    @Autowired
    public FrequencyOfCharsInStringController(FrequencyOfCharsInStringService frequencyService) {
        this.frequencyService = frequencyService;
    }


    /**
     * Обрабатывает POST-запрос для вычисления частоты встречи символов в заданной строке.
     *
     * @param input Входная строка для анализа
     * @return ResponseEntity с Map, где ключ - символ, значение - частота вхождения символа в строку
     */
    @PostMapping("/chars/frequency")
    public ResponseEntity<Map<Character, Long>> calculateFrequency(@RequestBody(required = false) String input) {

        Map<Character, Long> result = frequencyService.calculateFrequency(input);

        if (result.isEmpty()) {
            // Возвращаем статус 204 No Content для пустого результата
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(result);
    }

}
