package com.bosch.example.services;

import java.util.List;

import com.bosch.example.model.User;

public interface CreateService {
    Boolean checkUsername(User user);
    Boolean checkPassword(User user);
    Boolean checkEmail(User user);
    Boolean isValidEmail(User user);
} 
