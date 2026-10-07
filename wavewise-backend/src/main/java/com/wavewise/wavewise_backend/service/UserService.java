package com.wavewise.wavewise_backend.service;

import com.wavewise.wavewise_backend.dto.LoginRequest;
import com.wavewise.wavewise_backend.dto.LoginResponse;
import com.wavewise.wavewise_backend.entity.User;
import com.wavewise.wavewise_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return new LoginResponse(
                    "User not found",
                    null,
                    null
            );
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new LoginResponse(
                    "Invalid password",
                    null,
                    null
            );
        }

        return new LoginResponse(
                "Login successful",
                user.getRole(),
                user.getId()
        );
    }
}