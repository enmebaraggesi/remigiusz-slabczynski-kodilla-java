package com.kodilla.spring.portfolio;

import java.util.*;

public class TaskList {

    private final List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return tasks;
    }
}
