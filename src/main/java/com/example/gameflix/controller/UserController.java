package com.example.gameflix.controller;
import com.example.gameflix.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.gameflix.service.UserService;
import org.springframework.web.bind.annotation.*;

    @RestController
    public class UserController {
        @Autowired
        private UserService userService;
        @PostMapping("/register")
        public String registerUser(@RequestBody User user) {
            return userService.registerUser(user);
        }
        @PostMapping("/login")
        public String loginUser(@RequestBody User user) {
            return userService.loginUser(user.getUsername(),  user.getPassword());
        }
    }



