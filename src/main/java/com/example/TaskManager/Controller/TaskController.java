package com.example.TaskManager.Controller;


import org.springframework.ui.Model;
import com.example.TaskManager.Model.Task;
import com.example.TaskManager.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String listTasks(Model model) {
        List<Task> tasks = taskService.getTasks();
        model.addAttribute("tasks", tasks);
        return "task/view";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("task", new Task());
        return "task/create";
    }

    @PostMapping("/")
    public String createTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }


}
