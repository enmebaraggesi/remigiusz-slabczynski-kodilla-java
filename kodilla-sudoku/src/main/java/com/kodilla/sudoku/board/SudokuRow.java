package com.kodilla.sudoku.board;

import com.kodilla.sudoku.misc.Prototype;

import java.util.*;

import static com.kodilla.sudoku.board.SudokuBoard.BOARD_SIZE;

public class SudokuRow extends Prototype<SudokuRow> {

    private List<SudokuElement> elements = new ArrayList<>();

    public void initializeRow() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            elements.add(new SudokuElement());
            elements.get(i).initializeElement();
        }
    }

    public SudokuRow deepCopy() throws CloneNotSupportedException {

        SudokuRow clonedRow = super.clone();
        clonedRow.elements = new ArrayList<>();
        for (SudokuElement element : elements) {
            SudokuElement clonedElement = element.deepCopy();
            clonedRow.elements.add(clonedElement);
        }
        return clonedRow;
    }

    public List<SudokuElement> getElements() {
        return elements;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (SudokuElement element : elements) {
            stringBuilder.append("| ").append(element).append(" ");
        }
        stringBuilder.append("|");
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuRow sudokuRow = (SudokuRow) o;

        return Objects.equals(elements, sudokuRow.elements);
    }

    @Override
    public int hashCode() {
        return elements != null ? elements.hashCode() : 0;
    }
}