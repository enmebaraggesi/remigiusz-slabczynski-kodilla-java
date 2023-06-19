package com.kodilla.sudoku.misc;

import com.kodilla.sudoku.backtrack.Backtrack;
import com.kodilla.sudoku.board.*;

import java.util.*;

import static com.kodilla.sudoku.board.SudokuElement.EMPTY;

public class BoardShenanigansProcessor {

    private static Deque<Backtrack> savedBacktrackStack = new ArrayDeque<>();

    public static boolean isGameFinished(List<SudokuRow> board) {

        int emptyElements = countEmptyElements(board);
        if (emptyElements == 0) {
            System.out.println("Sudoku has been solved!");
            return true;
        } else {
            return false;
        }
    }

    private static int countEmptyElements(List<SudokuRow> board) {

        int count = 0;
        for (SudokuRow row : board) {
            for (SudokuElement element : row.getElements()) {
                if (element.getValue() == EMPTY) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void saveBacktrack(SudokuBoard board, int row, int col, int value) {

        savedBacktrackStack.offerFirst(new Backtrack(board, row, col, value));
    }

    public static SudokuBoard loadBacktrack() {

        if (savedBacktrackStack.isEmpty()) {
            SudokuBoard emptyBoard = new SudokuBoard();
            emptyBoard.initializeBoard();
            return emptyBoard;
        }
        Backtrack loadedBacktrack = savedBacktrackStack.pollFirst();
        System.out.println("Try again with new strategy. Your last move was: " +
            (loadedBacktrack.getLastRow() + 1) + "," +
            (loadedBacktrack.getLastCol() + 1) + "," +
            loadedBacktrack.getLastValue() + "\n"
        );
        return loadedBacktrack.getBoardCopy();
    }

    public static Deque<Backtrack> getSavedBacktrackStack() {
        return savedBacktrackStack;
    }
}
