package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    void testCalculations() {

        //When
        double addResult = calculator.add(2, 5);
        double subResult = calculator.sub(5, 2);
        double mulResult = calculator.mul(2, 5);
        double divResult = calculator.div(5, 2);

        //Then
        assertEquals(7, addResult);
        assertEquals(3, subResult);
        assertEquals(10, mulResult);
        assertEquals(2.5, divResult);
    }
}