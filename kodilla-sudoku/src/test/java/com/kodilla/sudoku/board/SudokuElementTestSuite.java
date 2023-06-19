package com.kodilla.sudoku.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SudokuElementTestSuite {

    @Test
    void testToString() {

        //Given
        SudokuElement sudokuElementEmpty = new SudokuElement();
        sudokuElementEmpty.initializeElement();
        SudokuElement sudokuElement7 = new SudokuElement();
        sudokuElement7.initializeElement();
        sudokuElement7.setValue(7);

        //When
        String testedEmpty = sudokuElementEmpty.toString();
        String tested7 = sudokuElement7.toString();

        //Then
        assertEquals("7", tested7);
        assertEquals(" ", testedEmpty);
    }

    @Test
    void testDeepCopy() {

        //TODO
    }
}