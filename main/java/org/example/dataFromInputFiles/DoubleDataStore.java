package org.example.dataFromInputFiles;

import java.util.ArrayList;

public class DoubleDataStore {
    private ArrayList<String> dataDouble=new ArrayList<>();
    private static final DoubleDataStore INSTANCE = new DoubleDataStore();
    private DoubleDataStore() {}
    public static DoubleDataStore getInstance() {
        return INSTANCE;
    }
    public void addData(String value) {
        dataDouble.add(value);
    }
    public ArrayList<String> getData(){
        return dataDouble;
    }
    public void clear(){
        dataDouble=new ArrayList<>();
    }
}
