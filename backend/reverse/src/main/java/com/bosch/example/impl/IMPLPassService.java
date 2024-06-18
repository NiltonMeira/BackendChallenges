package com.bosch.example.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.bosch.example.dto.Pass;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.PassService;

public class IMPLPassService implements PassService {

    @Override
    public Boolean checkPassword(Pass pass) {
       String password = pass.newPassword();
        
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
