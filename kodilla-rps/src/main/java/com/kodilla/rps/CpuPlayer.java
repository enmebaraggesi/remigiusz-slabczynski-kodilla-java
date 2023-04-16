package com.kodilla.rps;

public class CpuPlayer {

    public String makeDecision(String playerMove, int chance) {

        if (chance < 25) {         // 25% chance for drawing with player
            return playerMove;
        } else if (chance < 50) {  // 25% chance for losing to player
            if (playerMove.equals("1")) {
                return "3";
            } else if (playerMove.equals("2")) {
                return "1";
            }
            return "2";
        } else {                    // 50% chance for winning with player
            if (playerMove.equals("3")) {
                return "1";
            } else if (playerMove.equals("2")) {
                return "3";
            }
            return "2";
        }
    }
}
