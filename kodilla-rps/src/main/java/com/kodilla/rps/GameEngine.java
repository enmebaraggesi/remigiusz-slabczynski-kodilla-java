package com.kodilla.rps;

import java.util.*;

public class GameEngine {

    private boolean end = false;                            // default is false, used to quit game
    private int numberOfRounds;                             // set by player, used in repetition of playRound()
    private int counter = 0;                                // initial is 1, counter of rounds played
    private int score = 0;                                  // initial is 0, player score
    private Map<String, String> rpsMap;                     // names of chosen options
    private Map<String, Map<String, String>> resultsMap = new HashMap<>();  // map of possible results
    private Random randomGenerator;
    private PlayerHandler handler;

    public GameEngine() {
        randomGenerator = new Random();
        handler = new PlayerHandler();
        rpsMap = Map.of("1", "ROCK", "2", "PAPER", "3", "SCISSORS");
        Map<String, String> resultsForOne =
            Map.of("1", "DRAW", "2", "LOSE", "3", "WIN");
        resultsMap.put("1", resultsForOne);
        Map<String, String> resultsForTwo =
            Map.of("1", "WIN", "2", "DRAW", "3", "LOSE");
        resultsMap.put("2", resultsForTwo);
        Map<String, String> resultsForThree =
            Map.of("1", "LOSE", "2", "WIN", "3", "DRAW");
        resultsMap.put("3", resultsForThree);
    }

    public void playGame() {                                // mechanism to play a whole game
        handler.askForName();
        handler.explainRules();
        numberOfRounds = handler.askForRoundsLimit();
        //play game for number of rounds
        while (!end && counter < numberOfRounds) {
            counter++;
            playRound();
        }
        //view game summary
        String result = prepareFinalResult();

        String decision = handler.displayScore(result, counter, score);
        if (decision.equals("x")) {
            quitGame();

        } else if (decision.equals("n")) {
            restartGame();
        }
    }

    public void playRound() {                               // mechanism to play a round of game
        CpuPlayer cpu = new CpuPlayer();
        String playerDecision = handler.askForDecision(counter, numberOfRounds);

        if (playerDecision.equals("x")) {
            if (quitGame()) {
                return;
            }

        } else if (playerDecision.equals("n")) {
            if (restartGame()) {
                return;
            }
        }

        int chance = randomGenerator.nextInt(100);
        String cpuDecision = cpu.makeDecision(playerDecision, chance);

        processResult(playerDecision, cpuDecision);
    }

    public void processResult(String playerDecision, String cpuDecision) {  // mechanism to evaluate result of round

        String result = resultsMap.get(playerDecision).get(cpuDecision);

        if (result.equals("DRAW")) {
            handler.roundSummary("DRAW", rpsMap.get(playerDecision),
                rpsMap.get(cpuDecision), score);
        } else if (result.equals("WIN")) {
            handler.roundSummary("WIN", rpsMap.get(playerDecision),
                rpsMap.get(cpuDecision), ++score);
        } else {
            handler.roundSummary("LOSE", rpsMap.get(playerDecision),
                rpsMap.get(cpuDecision), score);
        }
    }

    public String prepareFinalResult() {                    // mechanism to evaluate final result

        if (score > (numberOfRounds - score)) {
            return "WON";
        } else if (score == (numberOfRounds - score)) {
            return "DRAW";
        } else {
            return "LOST";
        }
    }

    public boolean quitGame() {                             // mechanism to finish game

        String decision = handler.askIfSure();
        if (decision.equals("y")) {
            end = true;
            return true;
        }
        return false;
    }

    public boolean restartGame() {                          // mechanism to restart game

        String decision = handler.askIfSure();
        if (decision.equals("y")) {
            end = false;
            counter = 0;
            score = 0;
            playGame();
        }
        return false;
    }

    //===================== GETTERS & SETTERS

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Map<String, String> getRpsMap() {
        return rpsMap;
    }

    public PlayerHandler getHandler() {
        return handler;
    }
}
