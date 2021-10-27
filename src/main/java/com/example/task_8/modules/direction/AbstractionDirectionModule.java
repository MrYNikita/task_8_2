package com.example.task_8.modules.direction;

import com.example.task_8.modules.Module;

import java.io.File;

public abstract class AbstractionDirectionModule implements Module {
    @Override
    public boolean isSupportedFormat(File file) {
        return file.isDirectory();
    }
    @Override
    public abstract String getFunctionDescription();

    @Override
    public abstract void function(File file);
}
