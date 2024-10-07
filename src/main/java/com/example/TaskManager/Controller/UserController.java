package com.example.TaskManager.Controller;

import org.springframework.ui.Model;
import com.example.TaskManager.Model.User;
import com.example.TaskManager.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String registerPage() {
        return "register";
    }

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String register(User user, Model model) {

        if (userService.existsByEmail(user.getEmail())) {
            model.addAttribute("error", "Account with this email already exists!");
            return "user/register";
        }

        userService.register(user);
        model.addAttribute("message", "Registration successful!");
        return "user/register";
    }


    @PostMapping("/login")
    public String login(String email, String password, Model model) {
        User user = userService.login(email, password);
        if (user != null) {
            model.addAttribute("message", "Login successful!");
            return "redirect:/";
        }
        model.addAttribute("error", "Invalid email or password");
        return "/user/login";
    }




}
