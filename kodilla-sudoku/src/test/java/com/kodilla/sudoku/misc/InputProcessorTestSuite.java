package com.kodilla.sudoku.misc;

import com.kodilla.sudoku.board.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputProcessorTestSuite {

    @Test
    void testProcessPlayerInput() {

        //Given
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.initializeBoard();
        InputProcessor tested = new InputProcessor(sudokuBoard);

        //When
        String input = "1,2,3";
        try {
            tested.processPlayerInput(input);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        SudokuElement expected = new SudokuElement();
        expected.initializeElement();
        expected.setValue(3);
        expected.getPossibleValues().remove(2);
        SudokuElement actual = sudokuBoard.getBoard().get(0).getElements().get(1);

        //Then
        assertEquals(expected, actual);
    }
}