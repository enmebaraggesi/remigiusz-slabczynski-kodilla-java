package com.kodilla.sudoku.game;

import com.kodilla.sudoku.board.*;

import java.util.*;

import static com.kodilla.sudoku.board.SudokuBoard.BOARD_SIZE;
import static com.kodilla.sudoku.board.SudokuElement.EMPTY;
import static com.kodilla.sudoku.misc.BoardShenanigansProcessor.isGameFinished;

public class CpuSolver {

    private SudokuBoard board;

    public CpuSolver(SudokuBoard board) {
        this.board = board;
    }

    public boolean attemptToSolve() {

        while (true) {
            boolean progress = false;
            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {

                    SudokuElement element = board.getBoard().get(row).getElements().get(col);
                    if (element.getValue() == EMPTY) {
                        List<Integer> rowValues = collectFromRow(row);
                        List<Integer> columnValues = collectFromColumn(col);
                        List<Integer> sectionValues = collectFromSection(row, col);

                        List<Integer> unwantedValues = new ArrayList<>();
                        for (int value : element.getPossibleValues()) {
                            if (rowValues.contains(value) || columnValues.contains(value)
                                || sectionValues.contains(value)) {
                                unwantedValues.add(value);
                            }
                        }

                        if (unwantedValues.size() == element.getPossibleValues().size()) {
                            System.out.println("Latest attempt to solve this Sudoku was:\n");
                            System.out.println(board.toString());
                            System.out.println("Failed to resolve this Sudoku. Backtracking...");
                            return false;
                        }

                        if (unwantedValues.size() > 0) {
                            element.getPossibleValues().removeAll(unwantedValues);
                            progress = true;
                        }

                        if (element.getPossibleValues().size() >= 1) {
                            Random random = new Random();
                            int luckyShot = random.nextInt(element.getPossibleValues().size());
                            element.setValue(element.getPossibleValues().get(luckyShot));
                            progress = true;
                        }
                    }
                }
            }
            if (!progress) {
                System.out.println("CPU made no more progress.\n" +
                    "Latest attempt was:\n" +
                    board.toString());
                break;
            }
        }
        return isGameFinished(board.getBoard());
    }

    private List<Integer> collectFromRow(int row) {

        List<Integer> collection = new ArrayList<>();
        for (SudokuElement element : board.getBoard().get(row).getElements()) {
            if (element.getValue() != EMPTY) {
                collection.add(element.getValue());
            }
        }
        return collection;
    }

    private List<Integer> collectFromColumn(int col) {

        List<Integer> collection = new ArrayList<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            int value = board.getBoard().get(row).getElements().get(col).getValue();
            if (value != EMPTY) {
                collection.add(value);
            }
        }
        return collection;
    }

    private List<Integer> collectFromSection(int row, int col) {

        int rowStart = row - (row % 3);
        int colStart = col - (col % 3);

        List<Integer> collection = new ArrayList<>();
        for (int i = rowStart; i < rowStart + 3; i++) {
            for (int j = colStart; j < colStart + 3; j++) {
                int value = board.getBoard().get(i).getElements().get(j).getValue();
                if (value != EMPTY) {
                    collection.add(value);
                }
            }
        }
        return collection;
    }
}