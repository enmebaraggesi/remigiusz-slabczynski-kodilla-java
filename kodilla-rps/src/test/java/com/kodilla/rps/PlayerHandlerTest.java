package com.kodilla.rps;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testing PlayerHandler class")
class PlayerHandlerTest {

    private final PrintStream sysOut = System.out;
    private ByteArrayOutputStream outputStream;
    private PlayerHandler handler = new PlayerHandler();

    @Mock
    private Scanner scannerMock;

    @BeforeEach
    public void setUpTests() {
        handler.setScanner(scannerMock);
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(sysOut);
    }

    @Test
    @DisplayName("Testing receiving name from player")
    void testAskForName() {

        //Given
        when(scannerMock.next()).thenReturn("Kamil");

        //While
        String expected = """
            Welcome to Rock Paper Scissors game.
            What is your name?\r

            Hi Kamil!""";
        handler.askForName();

        //Then
        assertEquals(expected, outputStream.toString().trim());
    }

    @Test
    @DisplayName("Testing receiving rounds limit from player")
    void testAskForRoundsLimit() {

        //Given
        when(scannerMock.nextInt()).thenReturn(3);

        //While
        int expected = 3;
        int actual = handler.askForRoundsLimit();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Testing move decision from player")
    void testAskForDecision() {

        //Given
        int round = 4;
        int maxRounds = 7;
        when(scannerMock.next()).thenReturn("1");

        //While
        String expectedDecision = "1";
        String actualDecision = handler.askForDecision(round, maxRounds);
        String expectedText = "Round " + round + "/" + maxRounds +
            "\nChoose your option: 1 - ROCK, 2 - PAPER, 3 - SCISSORS";

        //Then
        assertEquals(expectedDecision, actualDecision);
        assertEquals(expectedText, outputStream.toString().trim());
    }

    @Test
    @DisplayName("Testing round summary")
    void testRoundSummary() {

        //Given
        handler.setPlayerName("Kamil");
        String result = "WIN";
        String playerMove = "ROCK";
        String cpuMove = "SCISSORS";
        int score = 4;

        //While
        String expected = """
            It's a WIN!
            Kamil move was: ROCK
            CPU move was: SCISSORS
            Kamil score is now: 4""";
        handler.roundSummary(result, playerMove, cpuMove, score);

        //Then
        assertEquals(expected, outputStream.toString().trim());
    }

    @Test
    @DisplayName("Testing game score summary")
    void testDisplayScore() {

        //Given
        handler.setPlayerName("Kamil");
        String result = "WIN";
        int roundCounter = 7;
        int score = 6;
        when(scannerMock.next()).thenReturn("x");

        //While
        String expectedText = """
            You WIN with CPU!
            After playing 7 rounds Kamil score 6 points.
            Press 'x' to quit game or 'n' to play again.""";
        String expectedDecision = "x";
        String actualDecision = handler.displayScore(result, roundCounter, score);

        //Then
        assertEquals(expectedDecision, actualDecision);
        assertEquals(expectedText, outputStream.toString().trim());
    }

    @Test
    @DisplayName("Testing 'y'/'n' question and answer")
    void testAskIfSure() {

        //Given
        when(scannerMock.next()).thenReturn("y");

        //While
        String expectedText = "Are you sure? 'y' for yes, 'n' for no";
        String expectedDecision = "y";
        String actualDecision = handler.askIfSure();

        //Then
        assertEquals(expectedDecision, actualDecision);
        assertEquals(expectedText, outputStream.toString().trim());
    }
}