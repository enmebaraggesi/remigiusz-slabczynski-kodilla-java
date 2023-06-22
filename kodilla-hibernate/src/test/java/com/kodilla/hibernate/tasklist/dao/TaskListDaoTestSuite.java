package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}