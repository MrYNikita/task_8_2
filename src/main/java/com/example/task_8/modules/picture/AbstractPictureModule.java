package com.example.task_8.modules.picture;

import com.example.task_8.MethodsFile;
import com.example.task_8.modules.Module;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractPictureModule implements Module {
    static final List<String> formats = Arrays.asList(
            "jpg",
            "jpeg",
            "png",
            "bmp",
            "webp"
    );

    @Override
    public boolean isSupportedFormat(File file) {
        return formats.contains(MethodsFile.getFileExp(file));
    }
    @Override
    public abstract String getFunctionDescription();
    @Override
    public abstract void function(File file);
}
