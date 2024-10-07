package com.example.TaskManager.Service;

import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();
    void saveTask(Task task);
    void deleteTask(int id);


}
