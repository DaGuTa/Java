package DZ3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Dz3_1 {
    public static Map<String, Integer> sortDim(String[] str){
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            Integer res = hm.get(str[i]);
            hm.put(str[i], res == null ? 1 : res + 1);
        }
        return hm;
    }
    public static void unique(String[] str){
        Map<String, Integer> hm = sortDim(str);
        System.out.println("Уникальные строк:");
        for (Map.Entry<String, Integer> me: hm.entrySet()) {
            if (me.getValue() == 1) System.out.println(me.getKey());
        }
    }
    public static void quantity(String[] str){
        Map<String, Integer> hm = sortDim(str);
        System.out.println("Сколько раз встречается каждая строка:");
        for (Map.Entry<String, Integer> me: hm.entrySet()) {
            System.out.println(me.getKey() + ": " + me.getValue());
        }
    }
    public static void main(String[] args) {
        String[] str = {"Яблоко","Персик","Абрикос","Арбуз","Виноград","Лимон","Персик","Груша","Яблоко","Абрикос","Персик","Хурма","Абрикос","Банан","Абрикос",};
        unique(str);
        quantity(str);

    }
}
