package org.comand.calc;

import java.util.function.BinaryOperator;

public class Calculator {


    private static final String  ERROR_MESSAGE = "Не определен тип операции: ";
    private static final String  ERROR_ZERO_MESSAGE = "На ноль делить нельзя: ";

    public static Integer calculate(String expression, Integer a,Integer b){
        BinaryOperator<Integer> execute;
        switch (expression){
            case "+": execute = Calculator::add; break;
            case "-":  execute = Calculator::minus; break;
            case  "*": execute = Calculator::multiply; break;
            case  "/": execute = Calculator::divide; break;
            default: throw new RuntimeException("ERROR_MESSAGE" + expression );
        }
        return execute.apply(a,b);
    }


    private static Integer multiply(Integer a, Integer b ){
        return a*b;
    }

    private static Integer divide(Integer a, Integer b ){
        if(b == 0){
            System.out.println(ERROR_ZERO_MESSAGE);
            return 0;  // :)     or try {} catch (ArithmeticException ex),  но зачем эксепшены лишние, можно же проверить ))
        }
        return a/b;
    }

    private static Integer minus(Integer a, Integer b ){
        return  a-b;
    }

    private static Integer add(Integer a, Integer b ){
       return a+b;
    }


}
