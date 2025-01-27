package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Options {
    private boolean O;
    private boolean P;
    private boolean S;
    private boolean F;
    private boolean A;
    private String prefix;
    private String outputFilesPath;
    private ArrayList<String> fileNames=new ArrayList<>();
    private static final Options INSTANCE = new Options();

    private Options() {}

    public static Options getInstance() {
        return INSTANCE;
    }
    public void reset() {
        INSTANCE.O = false;
        INSTANCE.P = false;
        INSTANCE.S = false;
        INSTANCE.F = false;
        INSTANCE.A = false;
        INSTANCE.prefix = null;
        INSTANCE.outputFilesPath = null;
        INSTANCE.fileNames = new ArrayList<>();
    }
}

