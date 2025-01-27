package org.example.dataFromInputFiles;

import java.util.ArrayList;

public class IntegerDataStore {
    private ArrayList<String> dataInteger=new ArrayList<>();
    private static final IntegerDataStore INSTANCE = new IntegerDataStore();
    private IntegerDataStore() {}
    public static IntegerDataStore getInstance() {
        return INSTANCE;
    }
    public void addData(String value) {
        dataInteger.add(value);
    }
    public ArrayList<String> getData(){
        return dataInteger;
    }
    public void clear(){
        dataInteger=new ArrayList<>();
    }
}