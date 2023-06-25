package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.*;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {

        //Given
        String listName = "First List";
        TaskList taskList = new TaskList(listName, "This is the first list");
        taskListDao.save(taskList);

        //When
        List<TaskList> testedList = taskListDao.findByListName(listName);

        //Then
        assertEquals(1, testedList.size());
        assertEquals(taskList, testedList.get(0));

        //CleanUp
        int id = testedList.get(0).getId();
        taskListDao.deleteById(id);
    }

    @Test
    void testTaskListDaoSaveWithTasks() {

        //Given
        Task task = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);

        TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);

        task.setTaskFinancialDetails(tfd);
        task2.setTaskFinancialDetails(tfd2);

        TaskList taskList = new TaskList("First list", "ToDo tasks");
        taskList.getTasks().add(task);
        taskList.getTasks().add(task2);
        task.setTaskList(taskList);
        task2.setTaskList(taskList);

        //When
        taskListDao.save(taskList);
        int id = taskList.getId();

        //Then
        assertNotEquals(0, id);

        //CleanUp
        taskListDao.deleteById(id);
    }
}