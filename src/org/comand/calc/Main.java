package org.comand.calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final Integer  MAX_VALUE = 10;


     public static void showResult(String  line){
          String [] data = Utils.splitCalcLineThreeArg(line);
          String exp =  data[1].trim().toUpperCase();
          Integer a,b;
          String result;

          if(Utils.isNumeric(data[0]) &&Utils. isNumeric(data[2])){
              a = Integer.valueOf(data[0]);
              b = Integer.valueOf(data[2]);
              Utils.validateNumbers(MAX_VALUE, a,b);
              result = a.toString() + exp + b.toString() + "= " + Calculator.calculate(exp,a,b).toString();
          }else{
              a = RomeNumber.romanNumberOffInt(data[0].toUpperCase()) ;
              b = RomeNumber.romanNumberOffInt(data[2].toUpperCase()) ;
              Utils.validateNumbers(MAX_VALUE, a,b);
              result = RomeNumber.intOffRomanNumber(a) +"  "+exp +" "+ RomeNumber.intOffRomanNumber(b) + " = " + RomeNumber.intOffRomanNumber(Calculator.calculate(exp,a,b));
          }

          System.out.print(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        showResult(name);
    }
}
