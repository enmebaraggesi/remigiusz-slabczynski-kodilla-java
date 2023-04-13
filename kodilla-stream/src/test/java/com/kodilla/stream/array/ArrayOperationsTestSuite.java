package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {

        //Given
        int[] numbers = {2, 5, 8, 12, 15, 18, 26};

        //When
        double expected = 12.285;
        double result = getAverage(numbers);

        //Then
        assertEquals(expected, result, 0.001);
    }
}