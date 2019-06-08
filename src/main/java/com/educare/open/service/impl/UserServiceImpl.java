package com.educare.open.service.impl;

import com.educare.open.model.User;
import com.educare.open.repository.UserRepository;
import com.educare.open.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
