package com.kodilla.exception.test;

public class Powers {

    public static void main(String[] args) {

        System.out.println(exponentiation(0, 4));
        System.out.println(exponentiation(4, 0));
        System.out.println(exponentiation(4, 2));
    }

    public static int exponentiation(int base, int power) {

        int result = 1;
        for (int i = 0; i < power; i++) {

            result *= base;
        }
        return result;
    }
}
