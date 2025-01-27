package org.example;

import org.example.dataFromInputFiles.IntegerDataStore;
import org.example.dataFromInputFiles.DoubleDataStore;
import org.example.dataFromInputFiles.StringDataStore;
import org.example.model.Options;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomFileWriter {
    public void writeFiles() throws ErrorHandler {
        Options options = Options.getInstance();
        boolean appendMode = options.isA(); // Проверяем наличие параметра -a
        String prefix = options.getPrefix() != null ? options.getPrefix() : ""; // Префикс
        String outputPath = options.getOutputFilesPath() != null ? options.getOutputFilesPath() : ""; // Путь

        // Убедимся, что путь существует, если указан
        if (!outputPath.isEmpty()) {
            File dir = new File(outputPath);
            if (!dir.exists() && !dir.mkdirs()) {
                throw new ErrorHandler("Не удалось создать директорию: " + outputPath);
            }
        }

        // Получаем ссылки на хранилища данных
        IntegerDataStore integerDataStore = IntegerDataStore.getInstance();
        DoubleDataStore doubleDataStore = DoubleDataStore.getInstance();
        StringDataStore stringDataStore = StringDataStore.getInstance();

        // Запись данных в файлы
        if(!integerDataStore.getData().isEmpty()) {
            writeToFile(outputPath + prefix + "integers.txt", integerDataStore.getData(), appendMode);
        }
        if(!doubleDataStore.getData().isEmpty()) {
            writeToFile(outputPath + prefix + "doubles.txt", doubleDataStore.getData(), appendMode);
        }
        if(!stringDataStore.getData().isEmpty()) {
            writeToFile(outputPath + prefix + "strings.txt", stringDataStore.getData(), appendMode);
        }


    }

    private <T> void writeToFile(String fileName, List<T> data, boolean append) throws ErrorHandler {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
            for (T item : data) {
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println((append ? "Дополнено" : "Записано") + " в файл: " + fileName);
        } catch (IOException e) {
            throw new ErrorHandler("Ошибка при записи в файл: " + fileName);
        }
    }
}
