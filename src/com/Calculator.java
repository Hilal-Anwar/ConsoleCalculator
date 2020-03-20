package com;

public class Calculator extends CalculatorOperation {

    Calculator(String ConsoleValue) {
        int start = 0, end = 0;
        while (ConsoleValue.contains("(") || ConsoleValue.contains(")"))
        {
            for (int i = 0; i < ConsoleValue.length(); i++) {
                if (ConsoleValue.charAt(i) == '(')
                    start = i;
                if (ConsoleValue.charAt(i) == ')') {
                    end = i;
                    break;
                }
            }
            String x = ConsoleValue.substring(start, end + 1);
            Operation(ConsoleValue.substring(start + 1, end));
            if (start!=0&&Character.isDigit(ConsoleValue.charAt(start - 1)))
                ConsoleValue = ConsoleValue.replace(x, "*" + findAnswers());
            else if (ConsoleValue.charAt(start - 1)=='-'){
                String y=ConsoleValue.substring(start-1, end + 1);
                ConsoleValue = ConsoleValue.replace(y, -1+"*" + findAnswers());
            }
            else if (ConsoleValue.charAt(start-1)=='*')
                ConsoleValue=ConsoleValue.replace(x,String.valueOf(findAnswers()));
            else
                ConsoleValue = ConsoleValue.replace(x, String.valueOf(findAnswers()));
        }
        Operation(ConsoleValue);
    }

    Double findAnswers() {
        power();
        division();
        multiplication();
        AdditionAndSubtraction();
        return FinalValue;
    }
}
