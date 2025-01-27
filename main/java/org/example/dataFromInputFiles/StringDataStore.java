package org.example.dataFromInputFiles;

import java.util.ArrayList;

public class StringDataStore {
    private ArrayList<String> dataString=new ArrayList<>();

    private static final StringDataStore INSTANCE = new StringDataStore();
    private StringDataStore(){}
    public static StringDataStore getInstance() {
        return INSTANCE;
    }
    public void addData(String value) {
        dataString.add(value);
    }
    public ArrayList<String> getData(){
        return dataString;
    }
    public void clear(){
        dataString=new ArrayList<>();
    }
}
