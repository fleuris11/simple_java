package com.example;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("2 + 2 = " + calc.add(4, 8));
        System.out.println("2 - 2 = " + calc.subtract(2, 2));
    }
}