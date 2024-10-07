package com.example.TaskManager.Repository;

import com.example.TaskManager.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);
    User findByEmail(String email);
}
