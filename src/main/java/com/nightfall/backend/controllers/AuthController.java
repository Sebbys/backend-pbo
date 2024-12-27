package com.nightfall.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.nightfall.backend.service.UserService;
import com.nightfall.backend.dto.LoginDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        boolean authenticated = userService.authenticate(loginDTO.getUsername(), loginDTO.getPassword());
        if (authenticated) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
