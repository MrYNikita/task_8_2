package com.example.task_8.modules.audio;

import com.example.task_8.MethodsFile;
import com.example.task_8.modules.Module;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class AbstractAudioModule implements Module {
    static final List<String> formats = Arrays.asList("wav", "mp3");

    @Override
    public boolean isSupportedFormat(File file) {
        return formats.contains(MethodsFile.getFileExp(file).toLowerCase(Locale.ROOT));
    }

    @Override
    public abstract String getFunctionDescription();

    @Override
    public abstract void function(File file);
}
