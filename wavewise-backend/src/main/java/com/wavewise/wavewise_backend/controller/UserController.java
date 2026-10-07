package com.wavewise.wavewise_backend.controller;

import com.wavewise.wavewise_backend.dto.LoginRequest;
import com.wavewise.wavewise_backend.dto.LoginResponse;
import jakarta.validation.Valid;

import com.wavewise.wavewise_backend.entity.User;
import com.wavewise.wavewise_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@Valid @RequestBody User user) {
        return userService.registerUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
