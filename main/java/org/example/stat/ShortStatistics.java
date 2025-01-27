package org.example.stat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortStatistics {
    private ShortStatistics(){}
    private static final ShortStatistics INSTANCE = new ShortStatistics();
    private int countString=0;
    private int countInteger=0;
    private int countDouble=0;
    public static ShortStatistics getInstance(){
        return INSTANCE;
    }
        public void write(){
        System.out.println("Количество записанных строк: "+countString+"\nКоличество записанных целочисленных значений: "+ countInteger
        +"\nКоличество записанных дробных значений: "+ countDouble);
    }
}
