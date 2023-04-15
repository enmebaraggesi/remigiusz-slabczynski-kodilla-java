package com.kodilla.rps;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Testing CpuPlayer class")
class CpuPlayerTest {

    @Test
    @DisplayName("Testing random decision making. Expected results are 1, 2 or 3")
    void testMakeDecision() {

        //Given
        CpuPlayer cpuPlayer = new CpuPlayer();
        String[] playerMoves = {"1", "2", "3"};

        //When

        //Then
        for (String playerMove : playerMoves) {
            String cpuMove = cpuPlayer.makeDecision(playerMove);
            assertTrue(cpuMove.equals("1") || cpuMove.equals("2") || cpuMove.equals("3"));
        }
    }
}