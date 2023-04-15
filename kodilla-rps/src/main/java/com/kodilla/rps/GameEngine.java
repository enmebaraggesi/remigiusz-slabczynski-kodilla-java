package com.kodilla.rps;

import java.util.*;

import static com.kodilla.rps.PlayerHandler.*;

public class GameEngine {

    private boolean end = false;                            // default is false, used to quit game
    private int numberOfRounds;                             // set by player, used in repetition of playRound()
    private int counter = 0;                                // initial is 1, counter of rounds played
    private int score = 0;                                  // initial is 0, player score
    private Map<String, String> rpsMap = new HashMap<>();   // names of chosen option

    public GameEngine() {
        this.rpsMap.put("1", "ROCK");
        this.rpsMap.put("2", "PAPER");
        this.rpsMap.put("3", "SCISSORS");
    }

    public void playGame() {                                // mechanism to play a whole game
        askForName();
        explainRules();
        numberOfRounds = askForRoundsLimit();
        //play game for number of rounds
        while (!end && counter < numberOfRounds) {
            counter++;
            playRound();
        }
        //view game summary
        String result = prepareResult();

        String decision = displayScore(result, counter, score);
        if (decision.equals("x")) {
            quitGame();

        } else if (decision.equals("n")) {
            restartGame();
        }
    }

    public void playRound() {                               // mechanism to play a round of game
        CpuPlayer cpu = new CpuPlayer();
        String playerDecision = askForDecision(counter, numberOfRounds);

        if (playerDecision.equals("x")) {
            if (quitGame()) {
                return;
            }

        } else if (playerDecision.equals("n")) {
            if (restartGame()) {
                return;
            }
        }

        String cpuDecision = cpu.makeDecision(playerDecision);

        switch (playerDecision) {
            case "1" -> {
                if (cpuDecision.equals("1")) {
                    roundSummary("DRAW", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), score);
                } else if (cpuDecision.equals("2")) {
                    roundSummary("LOSE", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), score);
                } else {
                    roundSummary("WIN", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), ++score);
                }
            }
            case "2" -> {
                if (cpuDecision.equals("2")) {
                    roundSummary("DRAW", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), score);
                } else if (cpuDecision.equals("3")) {
                    roundSummary("LOSE", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), score);
                } else {
                    roundSummary("WIN", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), ++score);
                }
            }
            case "3" -> {
                if (cpuDecision.equals("3")) {
                    roundSummary("DRAW", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), score);
                } else if (cpuDecision.equals("1")) {
                    roundSummary("LOSE", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), score);
                } else {
                    roundSummary("WIN", rpsMap.get(playerDecision),
                        rpsMap.get(cpuDecision), ++score);
                }
            }
        }
    }

    public String prepareResult() {                         // mechanism to count up final result

        if (score > (numberOfRounds - score)) {
            return "WON";
        } else if (score == (numberOfRounds - score)) {
            return "DRAW";
        } else {
            return "LOST";
        }
    }

    public boolean quitGame() {                             // mechanism to finish game

        String decision = askIfSure();
        if (decision.equals("y")) {
            end = true;
            return true;
        }
        return false;
    }

    public boolean restartGame() {                          // mechanism to restart game

        String decision = askIfSure();
        if (decision.equals("y")) {
            end = false;
            counter = 1;
            score = 0;
            playGame();
        }
        return false;
    }
}
