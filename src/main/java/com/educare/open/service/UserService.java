package com.educare.open.service;

import com.educare.open.model.User;

public interface UserService {
    User findByUsername(String username);
}
