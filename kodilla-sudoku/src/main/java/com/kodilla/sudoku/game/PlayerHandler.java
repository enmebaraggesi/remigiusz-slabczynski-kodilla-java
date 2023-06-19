package com.kodilla.sudoku.game;

import java.util.Scanner;

public class PlayerHandler {

    private Scanner scanner = new Scanner(System.in);

    public void welcomingContent() {
        System.out.println("""
            Welcome in the game of Sudoku.
            Your task is to put numbers from 1 to 9 into empty fields of 9x9 board.
            Rules are:
            - in one row one number can occur only once;
            - in one column also can be only one occurrence of number;
            - every area 3x3 also can hold each number only once.
                        
            You will place numbers writing coordinates and desired number in console.
            Pattern to do so is 'row,column,number', i.e. 1,1,9.
                        
            By any time you can just press Enter and CPU will start filling gapes on its own.
            Ready?
            """);
    }

    //TODO
    public String askForMove() {
        String answer;
//        do {
        System.out.println("Please make your move (row,col,num):");
        answer = scanner.nextLine();

//        } while(!answer.equalsIgnoreCase("sudoku") || !answer.matches("\\d,\\d,\\d"));
        return answer;
    }
}