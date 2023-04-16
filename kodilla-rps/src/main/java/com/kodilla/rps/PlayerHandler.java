package com.kodilla.rps;

import java.util.Scanner;

public class PlayerHandler {

    private String playerName;
    private Scanner scanner = new Scanner(System.in);

    public void askForName() {

        System.out.println("Welcome to Rock Paper Scissors game.\n" +
            "What is your name?");
        playerName = scanner.next();
        System.out.println("\nHi " + playerName + "!");
    }

    public void explainRules() {

        System.out.println("""
            First let me remind you rules of this game:
            - ROCK beats SCISSORS
            - SCISSORS beats PAPER
            - PAPER beats ROCK

            You will be asked first for number of rounds you wish to play against CPU player.
            Then game begins and you will be asked for your move, where:
            - '1' button represents ROCK
            - '2' button represents PAPER
            - '3' button represents SCISSORS
            - 'x' button quits game
            - 'n' button starts over a new game
            """);
    }

    public int askForRoundsLimit() {

        System.out.println("How many rounds would you like to play?");
        return scanner.nextInt();
    }

    public String askForDecision(int round, int maxRounds) {

        GameEngine ge = new GameEngine();
        String decision;
        do {
            System.out.println("\nRound " + round + "/" + maxRounds +
                "\nChoose your option: 1 - ROCK, 2 - PAPER, 3 - SCISSORS");
            decision = scanner.next();
        } while (!(ge.getRpsMap().containsKey(decision) ||
            decision.equals("x") || decision.equals("n")));
        return decision;
    }

    public void roundSummary(String result, String playerMove, String cpuMove, int score) {

        System.out.println("\nIt's a " + result + "!\n" +
            playerName + " move was: " + playerMove + "\n" +
            "CPU move was: " + cpuMove + "\n" +
            playerName + " score is now: " + score);
    }

    public String displayScore(String result, int roundCounter, int score) {

        System.out.println("\nYou " + result + " with CPU!\n" +
            "After playing " + roundCounter + " rounds " + playerName + " score " + score + " points.\n" +
            "Press 'x' to quit game or 'n' to play again.");
        return scanner.next();
    }

    public String askIfSure() {

        System.out.println("\nAre you sure? 'y' for yes, 'n' for no");
        return scanner.next();
    }

    //===================== SETTERS

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
