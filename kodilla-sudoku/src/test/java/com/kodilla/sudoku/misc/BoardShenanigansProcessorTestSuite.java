package com.kodilla.sudoku.misc;

import com.kodilla.sudoku.board.*;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static com.kodilla.sudoku.misc.BoardShenanigansProcessor.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardShenanigansProcessorTestSuite {

    @Test
    void testisGameFinished_WithNotFinishedBoard() {

        //Given
        SudokuBoard emptyBoard = new SudokuBoard();
        emptyBoard.initializeBoard();

        //When
        boolean testedEmpty = isGameFinished(emptyBoard.getBoard());
        emptyBoard.getBoard().get(1).getElements().get(1).setValue(9);
        emptyBoard.getBoard().get(2).getElements().get(2).setValue(8);
        boolean testedWithNumbers = isGameFinished(emptyBoard.getBoard());

        //Then
        assertFalse(testedEmpty);
        assertFalse(testedWithNumbers);
    }

    @Test
    void testisGameFinished_WithFinishedBoard() {

        //Given

        SudokuBoard filledBoard = new SudokuBoard();
        for (SudokuRow row : filledBoard.getBoard()) {
            for (int i = 0; i < row.getElements().size(); i++) {
                row.getElements().get(i).setValue(i);
            }
        }

        //When
        boolean tested = isGameFinished(filledBoard.getBoard());

        //Then
        assertTrue(tested);
    }

    @Test
    void testSaveBacktrack() {

        //Given
        SudokuBoard emptyBoard = new SudokuBoard();
        emptyBoard.initializeBoard();

        //When
        saveBacktrack(emptyBoard, 1, 2, 3);
        SudokuBoard testedBoard = Objects.requireNonNull(getSavedBacktrackStack().peek()).getBoardCopy();
        int testedValue = Objects.requireNonNull(getSavedBacktrackStack().peek()).getLastValue();

        //Then
        assertNotNull(getSavedBacktrackStack().peek());
        assertNotEquals(emptyBoard, testedBoard);
//        assertTrue(emptyBoard.equals(testedBoard)); TODO
        assertEquals(1, getSavedBacktrackStack().size());
        assertEquals(3, testedValue);
    }
}