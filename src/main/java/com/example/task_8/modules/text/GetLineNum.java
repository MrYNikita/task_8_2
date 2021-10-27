package com.example.task_8.modules.text;

import com.example.task_8.MethodsFile;
import com.example.task_8.MethodsString;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class GetLineNum extends AbstractTextModule {
    @Override
    public String getFunctionDescription() {
        return "Возврат кол-ва строк в файле";
    }

    @Override
    public void function(File file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(file.toPath());
            MethodsString.pustString("Кол-во_строк_в_файле",lines.toArray().length + "");
        } catch (IOException e) {

            MethodsString.pustStringError("ошибка при считывании кол-ва строк");

        }
    }
}
