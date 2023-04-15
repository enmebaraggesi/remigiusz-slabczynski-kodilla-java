package com.kodilla.rps;

import java.util.Scanner;

public class PlayerHandler {

    private static String playerName; //name of player

    public static void askForName() {

        System.out.println("Welcome to Rock Paper Scissors game.\n" +
            "What is your name?");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.next();
        System.out.println("\nHi " + playerName + "!");
    }

    public static void explainRules() {

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

    public static int askForRoundsLimit() {

        System.out.println("How many rounds would you like to play?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String askForDecision(int round, int maxRounds) {

        String decision;
        do {
            System.out.println("\nRound " + round + "/" + maxRounds +
                "\nChoose your option: 1 - ROCK, 2 - PAPER, 3 - SCISSORS");
            Scanner scanner = new Scanner(System.in);
            decision = scanner.next();
        } while (!(decision.equals("1") || decision.equals("2") || decision.equals("3") ||
            decision.equals("x") || decision.equals("n")));
        return decision;
    }

    public static void roundSummary(String result, String playerMove, String cpuMove, int score) {

        System.out.println("\nIt's a " + result + "!\n" +
            playerName + " move was: " + playerMove + "\n" +
            "CPU move was: " + cpuMove + "\n" +
            playerName + " score is now: " + score);
    }

    public static String displayScore(String result, int roundCounter, int score) {

        System.out.println("\nYou " + result + " with CPU!\n" +
            "After playing " + roundCounter + " rounds " + playerName + " score " + score + " points.\n" +
            "Press 'x' to quit game or 'n' to play again.");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static String askIfSure() {

        System.out.println("\nAre you sure? 'y' for yes, 'n' for no");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static void setPlayerName(String playerName) {
        PlayerHandler.playerName = playerName;
    }
}
