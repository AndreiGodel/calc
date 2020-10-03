package org.comand.calc;

import java.util.HashMap;
import java.util.Map;


public class RomeNumber {
    private static String ERROR_NUMBER_MESSAGE = "Значение  %s  не Римское число";
   // private static Boolean IS_ROMAN_NUMBER = false; // Это не очень хорошо, но очень спать  хочу )))


    private static  final Map<String, Integer> ROMAN_DICTIONARY = new HashMap<String, Integer>(){{
        put("I",1 );
        put("IV", 4);
        put("V", 5);
        put("IX",9);
        put("X",10);
        put("XL",40);
        put("L",50);
        put("XC",90);
        put("C",100);
    }};


    public  static int romanNumberOffInt(String romanNumber){
        int summ = 0;
        try {
            for (int i = 0; i < romanNumber.length(); i++) {
                int t_ = ROMAN_DICTIONARY.get(String.valueOf(romanNumber.charAt(i)));
                if ((summ >= 3  && summ<5 && t_>= 1 && t_<=10) || (summ >= 8 && summ < 10 && t_ < 10 )){
                    throw  new RuntimeException(String.format(ERROR_NUMBER_MESSAGE,romanNumber));
                }
                if ((summ >= 13  && summ<15  && t_ >=1 && t_<= 10) || (summ >= 18 && summ < 20  && t_ <= 5 )){
                    throw  new RuntimeException(String.format(ERROR_NUMBER_MESSAGE,romanNumber));
                }
                if (summ >= t_ || (summ > 1 && t_ == 10))
                    summ += t_;
                else
                    summ = t_ - summ;
            }
        }catch (NullPointerException ex){
            throw new RuntimeException(String.format(ERROR_NUMBER_MESSAGE, romanNumber));
        }

        return summ;
    }

    public static String intOffRomanNumber(Integer arabicNumber) {
        String romanNumber = "";
        if(arabicNumber == 0){ return "0";}
        while (arabicNumber > 0) {
            if(arabicNumber >= 100) {
                romanNumber += getFromDictinary(100);
                arabicNumber -= 100;
                continue;
            }
            if (arabicNumber >= 90) {
                romanNumber += getFromDictinary(90);
                arabicNumber -= 90;
                continue;
            }
            if (arabicNumber >= 50) {
                romanNumber += getFromDictinary(50);
                arabicNumber -= 50;
                continue;
            }
            if (arabicNumber >= 40) {
                romanNumber += getFromDictinary(40);
                arabicNumber -= 40;
                continue;
            }
            if (arabicNumber >= 10) {
                romanNumber += getFromDictinary(10);
                arabicNumber -= 10;
                continue;
            }
            if (arabicNumber >= 9) {
                romanNumber += getFromDictinary(9);
                arabicNumber -= 9;
                continue;
            }
            if (arabicNumber >= 5) {
                romanNumber += getFromDictinary(5);
                arabicNumber -= 5;
                continue;
            }
            if (arabicNumber >= 4) {
                romanNumber += getFromDictinary(4);
                arabicNumber -= 4;
                continue;
            }
            if (arabicNumber >= 1) {
                romanNumber += getFromDictinary(1);
                arabicNumber -= 1;
                continue;
            }
        }
        return romanNumber;
    }


    public static  String getFromDictinary(Integer number){
        for (Map.Entry<String, Integer> entry : ROMAN_DICTIONARY.entrySet()) {
            if (number == entry.getValue()) {
                return entry.getKey();
            }
        }
        return "";
     }
}
