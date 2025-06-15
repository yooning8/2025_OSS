package com.example.re_wear.service;

import com.example.re_wear.entity.User;
import com.example.re_wear.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public boolean verifyLogin(String userId, String password) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null && user.getPassword().equals(password);
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
