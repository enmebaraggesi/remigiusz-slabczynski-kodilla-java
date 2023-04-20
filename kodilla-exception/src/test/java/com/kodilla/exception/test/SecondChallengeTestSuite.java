package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillThrowException_shouldThrowException() {

        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 5)),
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(0.99, 5)),
            () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(5, 1.5))
        );
    }

    @Test
    void testProbablyIWillThrowException_shouldPassOK() {

        //Given
        SecondChallenge secondChallenge = new SecondChallenge();
        //When & Then
        assertAll(
            () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1, 1.49)),
            () -> assertEquals("Done!", secondChallenge.probablyIWillThrowException(1, 1.49))
        );
    }
}