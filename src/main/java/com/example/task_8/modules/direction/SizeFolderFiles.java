package com.example.task_8.modules.direction;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class SizeFolderFiles extends AbstractionDirectionModule {
    @Override
    public String getFunctionDescription() {
        return "получить размер директории";
    }

    @Override
    public void function(File file) {
        try {
            long sum = Files.walk(file.toPath())
                    .mapToLong(p -> p.toFile().length())
                    .sum();
            System.out.printf("Size of folder %s: %s\n",file.getAbsolutePath(),getFormattedSize(sum));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String getFormattedSize(long l) {
        return  l < 1024 ? l + "Bytes" :
                l < (1024 * 1024) ? l / 1024 + "KBytes" :
                l < (1024 * 1024 * 1024) ? l / (1024 * 1024) + "MBytes" :
                l / (1024 * 1024 * 1024) + "GBytes";
    }
}
