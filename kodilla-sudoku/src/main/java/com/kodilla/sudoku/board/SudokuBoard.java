package com.kodilla.sudoku.board;

import com.kodilla.sudoku.misc.Prototype;

import java.util.*;

public class SudokuBoard extends Prototype<SudokuBoard> {

    public static final int BOARD_SIZE = 9;
    private List<SudokuRow> board = new ArrayList<>();

    public void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new SudokuRow());
            board.get(i).initializeRow();
        }
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {

        SudokuBoard clonedBoard = super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow row : board) {
            SudokuRow clonedRow = row.deepCopy();
            clonedBoard.board.add(clonedRow);
        }
        return clonedBoard;
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("""
                1   2   3   4   5   6   7   8   9
              |-----------|-----------|-----------|
            """);
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (i % 3 == 0 && i != 0) {
                stringBuilder.append("  |-----------|-----------|-----------|\n");
            }
            stringBuilder.append(i + 1).append(" ").append(board.get(i)).append("\n");
        }
        stringBuilder.append("  |-----------|-----------|-----------|\n");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuBoard that = (SudokuBoard) o;

        return Objects.equals(board, that.board);
    }

    @Override
    public int hashCode() {
        return board != null ? board.hashCode() : 0;
    }
}