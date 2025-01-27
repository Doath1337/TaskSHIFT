package org.example.model;

import java.util.ArrayList;
import java.util.List;

public  class InputDataKeeper {
    private static List<String> data = new ArrayList<>();

    public void addData(String item) {
        data.add(item);
    }
    public List<String> getData() {
        return data;
    }
    public void resetData() {
        data=new ArrayList<>();
    }

}

