package com.kodilla.sudoku.game;

import com.kodilla.sudoku.board.SudokuBoard;
import com.kodilla.sudoku.misc.InputProcessor;

import static com.kodilla.sudoku.misc.BoardShenanigansProcessor.*;

public class SudokuGame {

    public boolean resolveSudoku() {

        PlayerHandler playerHandler = new PlayerHandler();
        playerHandler.welcomingContent();

        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();

        while (true) {
            System.out.println(sudokuBoard);

            String playerAnswer = playerHandler.askForMove();
            if (playerAnswer.equalsIgnoreCase("sudoku")) {
                CpuSolver cpuSolver = new CpuSolver(sudokuBoard);
                boolean solved = cpuSolver.attemptToSolve();
                if (solved) {
                    System.out.println("Sudoku solved correctly!");
                    return true;
                } else {
                    sudokuBoard = loadBacktrack();
                }
            } else {
                InputProcessor inputProcessor = new InputProcessor(sudokuBoard);
                inputProcessor.processPlayerInput(playerAnswer);
                if (isGameFinished(sudokuBoard.getBoard())) {
                    System.out.println("You solved this Sudoku!");
                    return true;
                }
            }
        }
    }
}
