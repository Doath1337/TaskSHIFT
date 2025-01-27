package org.example.stat;

import org.example.dataFromInputFiles.DoubleDataStore;
import org.example.dataFromInputFiles.IntegerDataStore;

public class FullStatistics {
    private double min;
    private double max;
    private double sum;
    private double avg;
    private int count;
    private FullStatistics() {}
    private static final FullStatistics INSTANCE = new FullStatistics();
    IntegerDataStore integerDataStore = IntegerDataStore.getInstance();
    DoubleDataStore doubleDataStore = DoubleDataStore.getInstance();

    public static FullStatistics getInstance() {
        return INSTANCE;
    }
    public void write(){
        ShortStatistics.getInstance().write();
        System.out.println("Полная статистика:\n" +
                "Минимальное значение: "+min+
                "\nМаксимальное значение: " +max+
                "\nСумма значений: "+sum+
                "\nСреднее значение: "+avg);
    }
    public void valide(String num){
        count++;
        sum += Double.parseDouble(num);
        min=Math.min(min,Double.parseDouble(num));
        max=Math.max(max,Double.parseDouble(num));
        avg=sum/count;
    }
}
