package ivan.k.testprojectt1consulting.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FrequencyOfCharsInStringService {

    /**
     * Вычисляет частоту встречи символов в заданной строке и возвращает результат в виде отсортированной по убыванию Map.
     *
     * @param input Входная строка для анализа
     * @return Map, где ключ - символ, значение - частота вхождения символа в строку
     */
    public Map<Character, Long> calculateFrequency(String input) {

        // Проверяем на null и пробелы
        if (input == null || input.trim().isEmpty()) {
            // Возвращаем пустой результат, если строка пуста или состоит только из пробелов
            return new HashMap<>();
        }

        // Убираем пробелы из строки
        input = input.replace(" ", "");

        Map<Character, Long> frequencyMap = new HashMap<>();

        for (char c : input.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0L) + 1);
        }

        return sortByFrequencyDescending(frequencyMap);
    }

    /**
     * Сортирует Map по убыванию значения (частоты) и возвращает новый Map.
     *
     * @param frequencyMap Исходная Map для сортировки
     * @return Отсортированная Map по убыванию значения частоты
     */
    private Map<Character, Long> sortByFrequencyDescending(Map<Character, Long> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
