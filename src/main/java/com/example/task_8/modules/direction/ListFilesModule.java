package com.example.task_8.modules.direction;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

@Component
public class ListFilesModule extends AbstractionDirectionModule {
    @Override
    public String getFunctionDescription() {
        return "получить список файлов";
    }

    @Override
    public void function(File file) {
        Arrays.stream(file.listFiles())
                .sorted(getFilesComparator())
                .map(f -> (f.isDirectory() ? "[DIR]" : "[FILE]") + "\t" + f.getName())
                .forEach(System.out::println);
    }

    private Comparator<File> getFilesComparator() {
        return (a, b) -> a.isDirectory() && !b.isDirectory() ? -1 :
                !a.isDirectory() && b.isDirectory() ? 1 : 0;
    }
}
