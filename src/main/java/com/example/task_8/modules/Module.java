package com.example.task_8.modules;

import java.io.File;
import java.io.IOException;

public interface Module {
    boolean isSupportedFormat(File file);

    String getFunctionDescription();

    void function(File file) throws IOException;
}