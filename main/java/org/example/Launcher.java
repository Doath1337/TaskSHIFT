package org.example;

import org.example.dataFromInputFiles.DoubleDataStore;
import org.example.dataFromInputFiles.IntegerDataStore;
import org.example.dataFromInputFiles.StringDataStore;
import org.example.model.InputDataKeeper;
import org.example.model.Options;
import org.example.stat.FullStatistics;
import org.example.stat.ShortStatistics;

import java.util.Scanner;

public class Launcher {
    public void run() {
        OptionsSupervisor optionsSupervisor = new OptionsSupervisor();

        try{
            if(!optionsSupervisor.checkOptions()){
                runAfterError();
            }
                       CustomFileReader customFileReader = new CustomFileReader();
            customFileReader.readFiles();
            CustomFileWriter customFileWriter = new CustomFileWriter();
            customFileWriter.writeFiles();
            if(Options.getInstance().isS()){
                ShortStatistics.getInstance().write();
            }
            if(Options.getInstance().isF()){
                FullStatistics.getInstance().write();
            }
        }
        catch(Exception e){}

    }
    public void runAfterError() {
        Scanner scanner = new Scanner(System.in);
        Options options = Options.getInstance();

        // Сброс текущих настроек
        options.reset();
        IntegerDataStore.getInstance().clear();
        DoubleDataStore.getInstance().clear();
        StringDataStore.getInstance().clear();

        // Запрос нового ввода пользователя
        System.out.println("Произошла ошибка. Пожалуйста, введите команду заново:");
        String newCommand = scanner.nextLine();

        // Парсим новую команду
        parseCommand(newCommand);
    }

    private void parseCommand(String command) {
        try {
            InputDataKeeper inputDataKeeper = new InputDataKeeper();
            inputDataKeeper.resetData();
            String[] args = command.split(" ");
            for(String arg: args){
                inputDataKeeper.addData(arg);
            }
        } catch (Exception e) {
            // Если ошибка повторяется, снова вызываем runAfterError
            System.out.println("Ошибка при обработке команды: " + e.getMessage());
            runAfterError();
        }
        run();
    }
}
