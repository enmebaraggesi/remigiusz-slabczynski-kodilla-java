package com.kodilla.sudoku.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuRowTestSuite {

    @Test
    void testDeepCopy() {

        //TODO
    }

    @Test
    void testToString() {

        //Given
        SudokuRow sudokuRow = new SudokuRow();
        sudokuRow.initializeRow();

        //When
        String expectedEmpty = "|   |   |   |   |   |   |   |   |   |";
        String actualEmpty = sudokuRow.toString();
        String expectedFilled = "| 1 | 2 | 3 |   |   |   |   |   | 4 |";
        sudokuRow.getElements().get(0).setValue(1);
        sudokuRow.getElements().get(1).setValue(2);
        sudokuRow.getElements().get(2).setValue(3);
        sudokuRow.getElements().get(8).setValue(4);
        String actualFilled = sudokuRow.toString();

        //Then
        assertEquals(expectedEmpty, actualEmpty);
        assertEquals(expectedFilled, actualFilled);
    }
}