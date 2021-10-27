package com.example.task_8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Task8Application implements CommandLineRunner {

	@Autowired
	MethodsFile methodsFile;

	public static void main(String[] args) {
		SpringApplication.run(Task8Application.class, args);
	}

	public void run(String... args) throws Exception {

		File file;

		Long fileSize;

		String fileName = "";
		String fileException = "";
		String path = "D:\\Y_Projects\\Y_Java\\task_8\\files";

		System.out.println("#######################################################################################################################################################################################################################");

		MethodsString.pustHeader("вывод_аргументов");
		MethodsString.pustString("Аргументы",args);
		MethodsString.pustString("Путь",path);
		MethodsString.pustString("Файл",args[0]);

		MethodsString.pustHeader("проверка_аргументов");

		if (args.length < 1) {

			MethodsString.pustStringError("указанно недостаточное кол-во аргументов. Необходимо указать от одного и более аргументов");
			MethodsString.pustHeader("завершение_программы");
			return;

		} else {

			MethodsString.pustStringInfo("указано достаточное кол-во аргументов");

			try {

				file = new File(path,args[0]);

				if (!file.exists()) {

					throw new FileNotFoundException();

				} else {

					MethodsString.pustStringInfo("указанный файл существует");

				}

			} catch (FileNotFoundException e) {

				MethodsString.pustStringError("указанный файл " + "'" + args[0] + "'" + " не был найден в файловой директории files");
				MethodsString.pustHeader("завершение_программы");
				return;

			}

		}
		if (file.getName().indexOf('.') != -1 || file.isDirectory()) { //file.getName().indexOf('.') != -1 || args.length > 1 || file.isDirectory()

			if (file.isDirectory()) {

				fileName = file.getName();
				fileException = "directory";

			} else if (file.getName().indexOf('.') != -1) {

				fileName = file.getName().substring(0,file.getName().indexOf('.'));
				fileException = file.getName().substring(file.getName().indexOf('.') + 1);

			}
//			else if (args[1] != null) {
//
//				fileName = args[0];
//				fileException = args[1];
//
//			}

		} else {

			MethodsString.pustStringError("не указано расширение файла");
			MethodsString.pustHeader("завершение_программы");
			return;

		}

		fileSize = file.length();

		MethodsString.pustHeader("вывод_данных_файла");
		MethodsString.pustString("Имя",fileName);
		MethodsString.pustString("Тип",fileException);
		MethodsString.pustString("Размер",
				(fileSize < 1024) ? fileSize + "Bytes" :
				(fileSize < 1024 * 1024) ? fileSize / 1024 + "KBytes" :
				(fileSize < 1024 * 1024 * 1024) ? fileSize / (1024 * 1024)  + "MBytes" :
				fileSize / (1024 * 1024 * 1024) + "GBytes");

		MethodsString.pustHeader("выбор_методов");

		methodsFile.selectMethod(file,fileException);

	}
}
