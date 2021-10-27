package com.example.task_8.modules.direction;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class СlearModule extends AbstractionDirectionModule {
    @Override
    public String getFunctionDescription() {
        return "очистить директорию";
    }

    @Override
    public void function(File file) {
        for (File myFile : file.listFiles())
            if (myFile.isFile()) myFile.delete();
    }
}
