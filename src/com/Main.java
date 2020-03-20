package com;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a Expression");
        String expression=scanner.nextLine();
        System.out.println(new Calculator(expression).findAnswers());
    }
}
