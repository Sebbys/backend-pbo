package com.nightfall.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nightfall.backend.repository.SuperUserRepository;

@Service
public class UserService {
    @Autowired
    private SuperUserRepository superUserRepository;

    public boolean authenticate(String username, String password) {
        return superUserRepository.findByUsername(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}