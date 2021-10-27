package com.example.task_8;

import com.example.task_8.modules.Module;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import java.io.File;
import java.util.Map;

@Service
public class MethodsFile {

    public void selectMethod(File file,String fileException) throws IOException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.example.task_8.modules");
        Module[] modules = getModules(file, fileException, applicationContext);

        printModules(modules);

        int index;

        while (true) {
            Scanner s = new Scanner(System.in);

            try {
                index = Integer.parseInt(s.nextLine());
                if (index < 1 || index > modules.length) {
                    System.out.println("Incorrect number");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number");
            }
        }
        modules[index - 1].function(file);

    }
    public Module[] getModules(File file,String fileException,ApplicationContext applicationContext) {
        Map<String, Module> moduleMap = applicationContext.getBeansOfType(Module.class);

        return moduleMap.values()
                .stream()
                .filter(module -> module.isSupportedFormat(file))
                .toArray(Module[]::new);
    }

    public void printModules(Module[] modules) {

        MethodsString.pustHeader("выбор_функции");
        MethodsString.pustStringInfo("выберите одну из функций и введите её номер");

        for (int i = 0; i < modules.length; i++) {

            MethodsString.pustString(i + 1 + "",modules[i].getFunctionDescription());

        }

    }

    public static String getFileExp(File file) {
        String fileName = file.getName();
        if (!fileName.contains("."))
            return "";
        return fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase(Locale.ROOT);
    }
}
