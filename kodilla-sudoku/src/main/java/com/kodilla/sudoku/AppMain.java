package com.kodilla.sudoku;

import com.kodilla.sudoku.game.SudokuGame;

public class AppMain {

    public static void main(String[] args) {

        boolean gameFinished = false;
        while (!gameFinished) {
            SudokuGame theGame = new SudokuGame();
            gameFinished = theGame.resolveSudoku();
        }
    }
}
