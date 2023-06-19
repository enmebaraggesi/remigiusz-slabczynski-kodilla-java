package com.kodilla.sudoku.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuBoardTestSuite {

    @Test
    void testBoardIsProperSize() {

        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();

        //When
        int tested = sudokuBoard.getBoard().size();

        //Then
        assertEquals(9, tested);
    }

    @Test
    void testToStringEmpty() {

        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();

        //When
        String tested = sudokuBoard.toString();
        String expected = """
                1   2   3   4   5   6   7   8   9
              |-----------|-----------|-----------|
            1 |   |   |   |   |   |   |   |   |   |
            2 |   |   |   |   |   |   |   |   |   |
            3 |   |   |   |   |   |   |   |   |   |
              |-----------|-----------|-----------|
            4 |   |   |   |   |   |   |   |   |   |
            5 |   |   |   |   |   |   |   |   |   |
            6 |   |   |   |   |   |   |   |   |   |
              |-----------|-----------|-----------|
            7 |   |   |   |   |   |   |   |   |   |
            8 |   |   |   |   |   |   |   |   |   |
            9 |   |   |   |   |   |   |   |   |   |
              |-----------|-----------|-----------|
            """;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    void testToStringWithFewSlotsFilled() {

        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        sudokuBoard.getBoard().get(0).getElements().get(0).setValue(1);
        sudokuBoard.getBoard().get(0).getElements().get(1).setValue(2);
        sudokuBoard.getBoard().get(0).getElements().get(8).setValue(9);

        //When
        String tested = sudokuBoard.toString();
        String expected = """
                1   2   3   4   5   6   7   8   9
              |-----------|-----------|-----------|
            1 | 1 | 2 |   |   |   |   |   |   | 9 |
            2 |   |   |   |   |   |   |   |   |   |
            3 |   |   |   |   |   |   |   |   |   |
              |-----------|-----------|-----------|
            4 |   |   |   |   |   |   |   |   |   |
            5 |   |   |   |   |   |   |   |   |   |
            6 |   |   |   |   |   |   |   |   |   |
              |-----------|-----------|-----------|
            7 |   |   |   |   |   |   |   |   |   |
            8 |   |   |   |   |   |   |   |   |   |
            9 |   |   |   |   |   |   |   |   |   |
              |-----------|-----------|-----------|
            """;

        //Then
        assertEquals(expected, tested);
    }

    @Test
    void deepCopy() {

        //TODO
    }
}