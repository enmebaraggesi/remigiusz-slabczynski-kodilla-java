package com.kodilla.spring.portfolio;

import org.springframework.context.annotation.*;

@Configuration
public class BoardConfig {

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList createToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList createInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList createDoneList() {
        return new TaskList();
    }

    @Bean
    public Board createBoard() {
        return new Board(createToDoList(), createInProgressList(), createDoneList());
    }
}
