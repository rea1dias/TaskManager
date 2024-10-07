package com.example.TaskManager.Repository;

import com.example.TaskManager.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {


}
