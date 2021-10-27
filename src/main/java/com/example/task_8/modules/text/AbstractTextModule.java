package com.example.task_8.modules.text;

import ch.qos.logback.core.util.FileUtil;
import com.example.task_8.MethodsFile;
import com.example.task_8.modules.Module;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public abstract class AbstractTextModule implements Module {

    static final List<String> formats = Arrays.asList(
            "txt",
            "doc",
            "docx",
            "rtf",
            "html",
            "pdf",
            "odt",
            "fb2",
            "epud",
            "mobi",
            "djvu"
    );

    @Override
    public boolean isSupportedFormat(File file) {
        return formats.contains(MethodsFile.getFileExp(file));
    }

    @Override
    public abstract String getFunctionDescription();

    @Override
    public abstract void function(File file) throws IOException;

}
