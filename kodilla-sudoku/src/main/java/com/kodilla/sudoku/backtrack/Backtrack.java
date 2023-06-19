package com.kodilla.sudoku.backtrack;

import com.kodilla.sudoku.board.SudokuBoard;

public class Backtrack {

    private SudokuBoard boardCopy;
    private int lastRow;
    private int lastCol;
    private int lastValue;

    public Backtrack(SudokuBoard board, int row, int col, int value) {
        boardCopy = new SudokuBoard();
        try {
            boardCopy = board.deepCopy();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        lastRow = row;
        lastCol = col;
        lastValue = value;
    }

    public SudokuBoard getBoardCopy() {
        return boardCopy;
    }

    public int getLastRow() {
        return lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }

    public int getLastValue() {
        return lastValue;
    }
}