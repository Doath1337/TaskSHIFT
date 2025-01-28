package org.example;

import org.example.model.InputDataKeeper;
import org.example.model.Options;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class OptionsSupervisor {
    InputDataKeeper inputDataKeeper = new InputDataKeeper();

    public boolean checkOptions() throws ErrorHandler {
        ArrayList<String> args = (ArrayList<String>) inputDataKeeper.getData();
        if(args.size()==1 && args.get(0).equals("exit")) {
            System.exit(0);
        }
        Options option = Options.getInstance();
        for (int i = 0; i < args.size(); i++) {
            switch (args.get(i)) {
                case "-s":
                    option.setO(true);
                    break;
                case "-f":
                    option.setF(true);
                    break;
                case "-a":
                    option.setA(true);
                    break;
                case "-p":
                    if (i + 1 < args.size()) {
                        option.setPrefix(args.get(++i)); // Считываем следующий аргумент как значение для -p
                    } else {
                        System.err.println("Ошибка: После -p ожидается значение.");
                        return false;
                    }
                    break;
                case "-o":
                    if (i + 1 < args.size()) {
                        Path path = Path.of(args.get(++i));
                        if(Files.exists(path)){
                            option.setOutputFilesPath(path.toString());
                        }
                        else {
                            System.err.println("Ошибка: заданный путь не существует");
                            return false;
                        }
                    }
                    else {
                        System.err.println("Ошибка: После -o ожидается значение.");
                        return false;
                    }
                    break;
                default:
                    if(checkFile(args.get(i))){
                        option.getFileNames().add(args.get(i));
                    }
                    else{
                        throw new ErrorHandler("Файл не найден, проверьте правильность написания запроса!");
                    }
                    break;
            }
        }
        return true;
    }
    private boolean checkFile(String fileName){
        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            return true;
        } else {

            return false;
        }
    }
}
