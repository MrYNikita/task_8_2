package com.example.task_8.modules.text;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@Component
public class FileClear extends AbstractTextModule {

    @Override
    public String getFunctionDescription() {
        return "очистка файла";
    }

    @Override
    public void function(File file) throws IOException {
        FileWriter fwOb = new FileWriter(file.getAbsolutePath(), false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

}
