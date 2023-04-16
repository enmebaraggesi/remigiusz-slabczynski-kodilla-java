package com.kodilla.rps;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing CpuPlayer class")
class CpuPlayerTest {

    @Test
    @DisplayName("Testing CPU decision making resulting in draw. For '1' expected result is '1'")
    void testMakeDecisionWithDraw() {

        //Given
        CpuPlayer cpuPlayer = new CpuPlayer();
        String playerMove = "1";
        int chanceMin = 0;
        int chanceMax = 24;

        //When
        String actualMin = cpuPlayer.makeDecision(playerMove, chanceMin);
        String actualMax = cpuPlayer.makeDecision(playerMove, chanceMax);

        //Then
        assertEquals(playerMove, actualMin);
        assertEquals(playerMove, actualMax);
    }

    @Test
    @DisplayName("Testing CPU decision making resulting in lose. For '1' expected result is '3'")
    void testMakeDecisionWithLose() {

        //Given
        CpuPlayer cpuPlayer = new CpuPlayer();
        String playerMove = "1";
        int chanceMin = 25;
        int chanceMax = 49;

        //When
        String expected = "3";
        String actualMin = cpuPlayer.makeDecision(playerMove, chanceMin);
        String actualMax = cpuPlayer.makeDecision(playerMove, chanceMax);

        //Then
        assertEquals(expected, actualMin);
        assertEquals(expected, actualMax);
    }

    @Test
    @DisplayName("Testing CPU decision making resulting in win. For '1' expected result is '2'")
    void testMakeDecisionWithWin() {

        //Given
        CpuPlayer cpuPlayer = new CpuPlayer();
        String playerMove = "1";
        int chanceMin = 50;
        int chanceMax = 99;

        //When
        String expected = "2";
        String actualMin = cpuPlayer.makeDecision(playerMove, chanceMin);
        String actualMax = cpuPlayer.makeDecision(playerMove, chanceMax);

        //Then
        assertEquals(expected, actualMin);
        assertEquals(expected, actualMax);
    }
}