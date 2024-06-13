package com.bosch.example.impl;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import com.bosch.example.model.User;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.CreateService;


public class DatabaseUserService implements CreateService{

    @Autowired
    UserJPARepository repo;

    @Override
    public Boolean checkUsername(User user) {
        if (repo.findByUsername(user.getUsername()).size() > 0) {
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public Boolean checkEmail(User user) {
        if (repo.findByEmail(user.getEmail()).size() > 0) {
            return false;
        }
        else{
            return true;
        }


    }

    @Override
    public Boolean isValidEmail(User user) {
        String email = user.getEmail();
        String email_regex = "^([\\w\\.-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$";

        Pattern pattern = Pattern.compile(email_regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    @Override
    public Boolean checkPassword(User user) {
        String password = user.getPassword();
        
        if(password.length() < 8) {
            return false;
        }

        Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher specialCharMatcher = specialCharPattern.matcher(password);

        if (!specialCharMatcher.find()) {
            return false;
        }

        Pattern uppercasePattern = Pattern.compile("[A-Z]");
        Matcher uppercaseMatcher = uppercasePattern.matcher(password);
        
        if (!uppercaseMatcher.find()) {
            return false;
        }

        return true;
    }


    
}
