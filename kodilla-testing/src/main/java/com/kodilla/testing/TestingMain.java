package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int resultOfAddition = calculator.add(5, 5);

        if (resultOfAddition == 10) {
            System.out.println("Addition test OK");
        } else {
            System.out.println("Error!");
        }

        int resultOfSubtraction = calculator.subtract(10,5);

        if (resultOfSubtraction == 5) {
            System.out.println("Subtraction test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
