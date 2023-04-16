package com.kodilla.rps;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing GameEngine class")
class GameEngineTest {

    private GameEngine gameEngine = new GameEngine();

    @Test
    @DisplayName("Testing result for ROCK vs SCISSORS. Should return WIN text")
    void testProcessResult_WithRvsS_ShouldResultInWin() {

        //Given
        String playerDecisionWin = "1";
        String cpuDecisionWin = "3";
        gameEngine.getHandler().setPlayerName("Kamil");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //When
        String expected = """
            It's a WIN!
            Kamil move was: ROCK
            CPU move was: SCISSORS
            Kamil score is now: 1""";
        gameEngine.processResult(playerDecisionWin, cpuDecisionWin);

        //Then
        assertEquals(expected, outputStream.toString().trim());
        PrintStream sysOut = System.out;
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Testing result for ROCK vs ROCK. Should return DRAW text")
    void testProcessResult_WithRvsR_ShouldResultInDraw() {

        //Given
        String playerDecisionDraw = "1";
        String cpuDecisionDraw = "1";
        gameEngine.getHandler().setPlayerName("Kamil");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //When
        String expected = """
            It's a DRAW!
            Kamil move was: ROCK
            CPU move was: ROCK
            Kamil score is now: 0""";
        gameEngine.processResult(playerDecisionDraw, cpuDecisionDraw);

        //Then
        assertEquals(expected, outputStream.toString().trim());
        PrintStream sysOut = System.out;
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Testing result for ROCK vs PAPER. Should return LOSE text")
    void testProcessResult_WithRvsP_ShouldResultInLose() {

        //Given
        String playerDecisionLose = "1";
        String cpuDecisionLose = "2";
        gameEngine.getHandler().setPlayerName("Kamil");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //When
        String expected = """
            It's a LOSE!
            Kamil move was: ROCK
            CPU move was: PAPER
            Kamil score is now: 0""";
        gameEngine.processResult(playerDecisionLose, cpuDecisionLose);

        //Then
        assertEquals(expected, outputStream.toString().trim());
        PrintStream sysOut = System.out;
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Testing result for 4/7 points. Should return WON")
    void testPrepareFinalResult_With4By7_ShouldReturnWin() {

        //Given
        gameEngine.setScore(4);
        gameEngine.setNumberOfRounds(7);

        //When
        String result = gameEngine.prepareFinalResult();
        String expected = "WON";

        //Then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing result for 4/8 points. Should return DRAW")
    void testPrepareFinalResult_With4By8_ShouldReturnDraw() {

        //Given
        gameEngine.setScore(4);
        gameEngine.setNumberOfRounds(8);

        //When
        String result = gameEngine.prepareFinalResult();
        String expected = "DRAW";

        //Then
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing result for 3/7 points. Should return LOST")
    void testPrepareFinalResult_With3By7_ShouldReturnLost() {

        //Given
        gameEngine.setScore(3);
        gameEngine.setNumberOfRounds(7);

        //When
        String result = gameEngine.prepareFinalResult();
        String expected = "LOST";

        //Then
        assertEquals(expected, result);
    }
}