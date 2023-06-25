package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "TASKLISTS")
public class TaskList {

    private int id;
    private String listName;
    private String description;
    private List<Task> tasks = new ArrayList<>();

    public TaskList() {
    }

    public TaskList(String listName, String description) {
        this.listName = listName;
        this.description = description;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @Column(name = "LISTNAME")
    public String getListName() {
        return listName;
    }

    private void setListName(String listName) {
        this.listName = listName;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        if (id != taskList.id) return false;
        if (!listName.equals(taskList.listName)) return false;
        return description.equals(taskList.description);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (listName != null ? listName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @OneToMany(
        targetEntity = Task.class,
        mappedBy = "taskList",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
