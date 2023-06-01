package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoardTestSuite {

    private ApplicationContext context =
        new AnnotationConfigApplicationContext(BoardConfig.class);

    @Test
    void testGetToDoList() {

        //Given
        //When
        boolean isPresent = context.containsBean("toDoList");

        //Then
        System.out.println("Is 'toDoList' present: " + isPresent);
    }

    @Test
    void testGetInProgressList() {

        //Given
        //When
        boolean isPresent = context.containsBean("inProgressList");

        //Then
        System.out.println("Is 'inProgressList' present: " + isPresent);
        ;
    }

    @Test
    void testGetDoneList() {

        //Given
        //When
        boolean isPresent = context.containsBean("doneList");

        //Then
        System.out.println("Is 'doneList' present: " + isPresent);
    }

    @Test
    void testTaskAdd() {

        //Given
        Board board = (Board) context.getBean("createBoard");
        String taskToDo = "to do";
        String taskInProgress = "in progress";
        String taskDone = "done";

        //When
        board.addToDo(taskToDo);
        board.addInProgress(taskInProgress);
        board.addDone(taskDone);

        //Then
        assertEquals(1, board.getToDoList().getTasks().size());
        System.out.println("To do tasks list: " + board.getToDoList().getTasks());
        assertEquals(1, board.getToDoList().getTasks().size());
        System.out.println("In progress tasks list: " + board.getInProgressList().getTasks());
        assertEquals(1, board.getToDoList().getTasks().size());
        System.out.println("Done tasks list: " + board.getDoneList().getTasks());
    }
}