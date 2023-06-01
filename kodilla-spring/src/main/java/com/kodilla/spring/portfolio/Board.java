package com.kodilla.spring.portfolio;

public class Board {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDo(String toDo) {
        toDoList.getTasks().add(toDo);
    }

    public void addInProgress(String toDo) {
        inProgressList.getTasks().add(toDo);
    }

    public void addDone(String toDo) {
        doneList.getTasks().add(toDo);
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}
