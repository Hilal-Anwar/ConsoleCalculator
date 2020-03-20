package com;

import java.util.ArrayList;


public class CalculatorOperation {
    int sign = 1,finalSign=1;
    Double FinalValue=0.0;
    ArrayList<Double> Memory = new ArrayList<>();
    ArrayList<Integer> divisionOperator = new ArrayList<>();
    ArrayList<Integer> multiplicationOperator = new ArrayList<>();
    ArrayList<Integer> powerOperator = new ArrayList<>();
    String tem ="";
    void Operation(String ConsoleValue)
    {
        Memory.clear();
        divisionOperator.clear();
        multiplicationOperator.clear();
        powerOperator.clear();
        tem="";
        FinalValue=0.0;
        ConsoleValue = ConsoleValue + "+";
        for (int i = 0; i < ConsoleValue.length(); i++) {
            boolean condition = ConsoleValue.charAt(i) == '-' || ConsoleValue.charAt(i) == '+';
            if (ConsoleValue.charAt(i) == '-')
                sign =(-1);
            if (ConsoleValue.charAt(i) == '+')
                sign = 1;
            if ((Character.isDigit(ConsoleValue.charAt(i)) || ConsoleValue.charAt(i) == '.')||ConsoleValue.charAt(i)=='E') {
                tem = String.format("%s%s", tem, ConsoleValue.charAt(i));
                if (tem.length() == 1)
                    finalSign=sign;
            }
            if (condition) {
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem)*finalSign);
                    tem = "";
                }
            }
            if (ConsoleValue.charAt(i) == '/') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem)*finalSign);
                    tem = "";
                }
                divisionOperator.add(Memory.size() - 1);
            }
            if (ConsoleValue.charAt(i) == '*') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem)*finalSign);
                    tem = "";
                }
                multiplicationOperator.add(Memory.size() - 1);
            }
            if (ConsoleValue.charAt(i) == '^') {
                sign = 1;
                if (!tem.equals("")) {
                    Memory.add(Double.parseDouble(tem)*finalSign);
                    tem = "";
                }
                powerOperator.add(Memory.size() - 1);
            }
        }
    }
    void power(){
        for (int j = 0; j < powerOperator.size(); j++)
        {
            Memory.set(powerOperator.get(j), Math.pow(Memory.get(powerOperator.get(j)),(Memory.get(powerOperator.get(j) + 1))));
            Memory.remove(powerOperator.get(j) + 1);
            powerOperator=sizeReducer(powerOperator,powerOperator,j);
            divisionOperator=sizeReducer(divisionOperator,powerOperator,j);
            multiplicationOperator=sizeReducer(multiplicationOperator,powerOperator,j);
        }
    }
    void division(){
        for (int i = 0; i < divisionOperator.size(); i++) {
            Memory.set(divisionOperator.get(i), Memory.get(divisionOperator.get(i)) / Memory.get(divisionOperator.get(i) + 1));
            Memory.remove(divisionOperator.get(i) + 1);
            divisionOperator=sizeReducer(divisionOperator,divisionOperator,i);
            multiplicationOperator=sizeReducer(multiplicationOperator,divisionOperator,i);
        }
    }
    void multiplication()
    {
        for (int j = 0; j < multiplicationOperator.size(); j++) {
            Memory.set(multiplicationOperator.get(j), Memory.get(multiplicationOperator.get(j)) * Memory.get(multiplicationOperator.get(j) + 1));
            Memory.remove(multiplicationOperator.get(j) + 1);
            multiplicationOperator=sizeReducer(multiplicationOperator,multiplicationOperator,j);
        }
    }
    void AdditionAndSubtraction(){
        for (Double aDouble : Memory) FinalValue = FinalValue + aDouble;
    }
    ArrayList<Integer> sizeReducer(ArrayList<Integer> memoryList1,ArrayList<Integer> memoryList2,int a ){
        for (int b = 0; b <memoryList1.size(); b++) {
            if ((memoryList2.get(a)) < memoryList1.get(b))
                memoryList1.set(b, (memoryList1.get(b) - 1));
        }
        return memoryList1;
    }
}
