package com.example.TaskManager.ServiceImpl;

import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Repository.TaskRepository;
import com.example.TaskManager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Optional<Task> getTaskById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public void updateTask(int id, Task updatedTask) {
        taskRepository.save(updatedTask);
    }

}
