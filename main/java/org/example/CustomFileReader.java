package org.example;

import org.example.model.Options;
import org.example.dataFromInputFiles.IntegerDataStore;
import org.example.dataFromInputFiles.DoubleDataStore;
import org.example.dataFromInputFiles.StringDataStore;
import org.example.stat.FullStatistics;
import org.example.stat.ShortStatistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReader {
    public void readFiles() throws ErrorHandler {
        Options options = Options.getInstance();

        // Получаем ссылки на хранилища данных
        IntegerDataStore integerDataStore = IntegerDataStore.getInstance();
        DoubleDataStore doubleDataStore = DoubleDataStore.getInstance();
        StringDataStore stringDataStore = StringDataStore.getInstance();
        ShortStatistics shortStatistics = ShortStatistics.getInstance();
        FullStatistics fullStatistics = FullStatistics.getInstance();
        try {
            for (String fileName : options.getFileNames()) {
                System.out.println("Считывание файла: " + fileName);
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (isInteger(line)) {
                        integerDataStore.addData(line);
                        if(options.isF()){
                            shortStatistics.setCountInteger(shortStatistics.getCountInteger() + 1);
                            fullStatistics.valide(line);
                        }
                        else if(options.isS()){
                            shortStatistics.setCountInteger(shortStatistics.getCountInteger() + 1);
                        }

                    } else if (isDouble(line)) {
                        doubleDataStore.addData(line);
                        if(options.isF()){
                            shortStatistics.setCountDouble(shortStatistics.getCountInteger() + 1);
                            fullStatistics.valide(line);
                        }
                        else if(options.isS()){
                            shortStatistics.setCountDouble(shortStatistics.getCountDouble() + 1);
                        }

                    } else {
                        stringDataStore.addData(line);
                        shortStatistics.setCountString(shortStatistics.getCountString() + 1);

                    }
                }
            }
        }
        catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " );
            System.out.println("Рабочая директория: " + System.getProperty("user.dir"));
            throw new ErrorHandler("Не найден файл, убедитесь что верно указали его имя или путь");

        }
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
