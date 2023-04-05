package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.*;

public class CollectionTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }

    @Test
    @DisplayName("When given empty List, " +
            "then exterminator should return List size of 0")
    void testOddNumbersExterminatorEmptyList() {

        //Given
        OddNumbersExterminator killingMachine = new OddNumbersExterminator();
        List<Integer> emptyList = new ArrayList<>();
        //When
        List<Integer> result = killingMachine.exterminate(emptyList);
        //Then
        Assertions.assertEquals(0, result.size());
    }

    @Test
    @DisplayName("When given valid List, " +
            "then exterminator should return even numbers List")
    void testOddNumbersExterminatorNormalList() {

        //Given
        OddNumbersExterminator killingMachine = new OddNumbersExterminator();
        List<Integer> validList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //When
        List<Integer> result = killingMachine.exterminate(validList);
        //Then
        List<Integer> expected = Arrays.asList(2,4,6,8,10);
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }
}
