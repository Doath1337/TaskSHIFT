package org.example;

import org.example.model.InputDataKeeper;

public class Main {
    public static void main(String[] args) {
        InputDataKeeper inputDataKeeper = new InputDataKeeper();
        for (String arg : args) {
            inputDataKeeper.addData(arg);
        }
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        Launcher launcher = new Launcher();
        launcher.run();
    }
}
