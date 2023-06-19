package com.kodilla.sudoku.board;

import com.kodilla.sudoku.misc.Prototype;

import java.util.*;

public class SudokuElement extends Prototype<SudokuElement> {

    public static final int EMPTY = -1;
    protected List<Integer> possibleValues;
    private int value;

    public void initializeElement() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<>(
            List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
        );
    }

    public SudokuElement deepCopy() throws CloneNotSupportedException {
        SudokuElement clonedElement = super.clone();
        clonedElement.possibleValues = new ArrayList<>();
        for (int value : possibleValues) {
            Integer clonedValue = value;
            clonedElement.possibleValues.add(clonedValue);
        }
        return clonedElement;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    @Override
    public String toString() {

        if (value == -1) {
            return " ";
        } else {
            return Integer.toString(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SudokuElement element = (SudokuElement) o;

        if (value != element.value) return false;
        return Objects.equals(possibleValues, element.possibleValues);
    }

    @Override
    public int hashCode() {
        int result = value;
        result = 31 * result + (possibleValues != null ? possibleValues.hashCode() : 0);
        return result;
    }
}