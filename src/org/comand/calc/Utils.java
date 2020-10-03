package org.comand.calc;

public class Utils {

    public static String [] splitCalcLineThreeArg(String line){
        String [] data =  line.trim().split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)|(?<=\\w)(?=\\W)|(?<=\\W)(?=\\w)");
        if ( data.length != 3) {
            throw new RuntimeException("Вы передали неправильно аргументы  ");
        }
        return  data;
    }

    public static void validateNumbers(Integer maxValue, Integer ... values){
        for (Integer value : values) {
            if(value > maxValue) {
               throw new RuntimeException("значение чисел должно быть в пределах от 0 до " + maxValue);
            }
        }
    }

    static boolean isNumeric(String strNumber){
        try{
            Integer.valueOf(strNumber);
            return true;
        }catch(NumberFormatException ex) {
            return false;
        }
    }

}
