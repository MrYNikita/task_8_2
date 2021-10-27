package com.example.task_8.modules.text;

import com.example.task_8.MethodsString;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

@Component
public class FrequencyOfSymbols extends AbstractTextModule {

    @Override
    public String getFunctionDescription() {
        return "Возврат статистики символов";
    }

    @Override
    public void function(File file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
        } catch (IOException e) {
            return;
        }

        HashMap<Character, Integer> symbols = lines.stream()
                .flatMapToInt(String::chars)
                .mapToObj(x -> (char) x)
                .collect(HashMap::new,
                        (m, c) -> m.put(c, m.getOrDefault(c, 0) + 1),
                        HashMap::putAll);
        if (symbols.keySet().size() == 0)
            MethodsString.pustStringInfo("файл пуст");
        else
            symbols.entrySet()
                    .stream()
                    .sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                    .map(entry -> entry.getKey() + " -> " + entry.getValue())
                    .forEach(System.out::println);
    }
}
