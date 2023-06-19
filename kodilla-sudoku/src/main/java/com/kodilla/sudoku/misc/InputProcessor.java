package com.kodilla.sudoku.misc;

import com.kodilla.sudoku.board.*;

import static com.kodilla.sudoku.board.SudokuBoard.BOARD_SIZE;
import static com.kodilla.sudoku.board.SudokuElement.EMPTY;
import static com.kodilla.sudoku.misc.BoardShenanigansProcessor.saveBacktrack;

public class InputProcessor {

    private SudokuBoard sudokuBoard;

    public InputProcessor(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    public void processPlayerInput(String playerInput) {

        int row = getRowNumber(playerInput);
        int col = getColumnNumber(playerInput);
        int value = getNumber(playerInput);
        if (row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE
            && value >= 1 && value <= 9) {
            if (!processMoveOnBoard(row, col, value)) {
                System.out.println("\nInvalid input. Please try again.\n");
            }
        } else {
            System.out.println("\nInvalid input. Please try again.\n");
        }
    }

    private int getRowNumber(String playerInput) {
        String rowNumber = splitInput(playerInput)[0];
        int answer = Integer.parseInt(rowNumber);
        return answer - 1;
    }

    private int getColumnNumber(String playerInput) {
        String colNumber = splitInput(playerInput)[1];
        int answer = Integer.parseInt(colNumber);
        return answer - 1;
    }

    private int getNumber(String playerInput) {
        String number = splitInput(playerInput)[2];
        return Integer.parseInt(number);
    }

    private String[] splitInput(String playerInput) {
        return playerInput.split(",");
    }

    private boolean processMoveOnBoard(int row, int col, int value) {

        SudokuElement element = sudokuBoard.getBoard().get(row).getElements().get(col);
        if (element.getValue() == EMPTY) {
            for (int possibleValue : element.getPossibleValues()) {
                if (value == possibleValue && isValueValid(row, col, value)) {
                    saveBacktrack(sudokuBoard, row, col, value);
                    element.setValue(value);
                    removeValue(row, col, value);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValueValid(int row, int col, int value) {
        return !isValueInRow(row, value) && !isValueInColumn(col, value)
            && !isValueInSection(row, col, value);
    }

    private boolean isValueInRow(int row, int value) {
        SudokuRow sudokuRow = sudokuBoard.getBoard().get(row);
        for (SudokuElement element : sudokuRow.getElements()) {
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInColumn(int col, int value) {
        for (SudokuRow row : sudokuBoard.getBoard()) {
            SudokuElement element = row.getElements().get(col);
            if (element.getValue() == value) {
                return true;
            }
        }
        return false;
    }

    private boolean isValueInSection(int row, int col, int value) {
        int startingRow = row - (row % 3);
        int startingColumn = col - (col % 3);

        for (int i = startingRow; i < startingRow + 3; i++) {
            for (int j = startingColumn; j < startingColumn + 3; j++) {
                SudokuElement element = sudokuBoard.getBoard().get(i).getElements().get(j);
                if (element.getValue() == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void removeValue(int row, int col, Integer value) {
        SudokuElement element = sudokuBoard.getBoard().get(row).getElements().get(col);
        element.getPossibleValues().remove(value);
    }


}
