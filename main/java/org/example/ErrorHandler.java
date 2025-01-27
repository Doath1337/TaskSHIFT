package org.example;

public class ErrorHandler extends Exception {
    ErrorHandler(String message) {
        super(message);
        error(message);
    }
    public void error(String message) {
        System.out.println(message);
        Launcher launcher = new Launcher();
        launcher.runAfterError();
    }
}
