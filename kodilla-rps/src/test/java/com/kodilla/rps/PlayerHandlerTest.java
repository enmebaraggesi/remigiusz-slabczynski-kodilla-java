package com.kodilla.rps;

import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerHandlerTest {

    private final InputStream sysIn = System.in;
    private final PrintStream sysOut = System.out;
    private ByteArrayOutputStream outputStream;

    public void setUpInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @BeforeEach
    public void setUpOutput() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(sysIn);
        System.setOut(sysOut);
    }

    @Test
    void testAskForName() {

        //Given
        String name = "Kamil";
        setUpInput(name);

        //While
        String expected = "Welcome to Rock Paper Scissors game.\n" +
            "What is your name?\r\n" +
            "\nHi Kamil!";
        PlayerHandler.askForName();

        //Then
        assertEquals(expected, outputStream.toString().trim());
    }

    @Test
    void testAskForRoundsLimit() {

        //Given
        String numberOfRounds = "3";
        setUpInput(numberOfRounds);

        //While
        int expected = 3;
        int actual = PlayerHandler.askForRoundsLimit();

        //Then
        assertEquals(expected, actual);
    }

    @Test
    void testAskForDecision() {

        //Given
        int round = 4;
        int maxRounds = 7;
        String number = "1";
        setUpInput(number);

        //While
        String expectedDecision = "1";
        String actualDecision = PlayerHandler.askForDecision(round, maxRounds);
        String expectedText = "Round " + round + "/" + maxRounds +
            "\nChoose your option: 1 - ROCK, 2 - PAPER, 3 - SCISSORS";

        //Then
        assertEquals(expectedDecision, actualDecision);
        assertEquals(expectedText, outputStream.toString().trim());

    }

    @Test
    void testRoundSummary() {

        //Given
        PlayerHandler.setPlayerName("Kamil");
        String result = "WIN";
        String playerMove = "ROCK";
        String cpuMove = "SCISSORS";
        int score = 4;

        //While
        String expected = "It's a WIN!\n" +
            "Kamil move was: ROCK\n" +
            "CPU move was: SCISSORS\n" +
            "Kamil score is now: 4";
        PlayerHandler.roundSummary(result, playerMove, cpuMove, score);

        //Then
        assertEquals(expected, outputStream.toString().trim());
    }

    @Test
    void testDisplayScore() {

        //Given
        PlayerHandler.setPlayerName("Kamil");
        String result = "WIN";
        int roundCounter = 7;
        int score = 6;
        String decision = "x";
        setUpInput(decision);

        //While
        String expectedText = "You WIN with CPU!\n" +
            "After playing 7 rounds Kamil score 6 points.\n" +
            "Press 'x' to quit game or 'n' to play again.";
        String actualDecision = PlayerHandler.displayScore(result, roundCounter, score);

        //Then
        assertEquals(decision, actualDecision);
        assertEquals(expectedText, outputStream.toString().trim());
    }

    @Test
    void testAskIfSure() {

        //Given
        String decision = "y";
        setUpInput(decision);

        //While
        String expectedText = "Are you sure? 'y' for yes, 'n' for no";
        String actualDecision = PlayerHandler.askIfSure();

        //Then
        assertEquals(decision, actualDecision);
        assertEquals(expectedText, outputStream.toString().trim());
    }
}