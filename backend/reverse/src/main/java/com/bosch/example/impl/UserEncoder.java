package com.bosch.example.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserEncoder  {

    public static String getEncoder(String pass){
        BCryptPasswordEncoder enconder = new BCryptPasswordEncoder();
        return enconder.encode(pass);
    }

    public boolean compare(String pass, String expected){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(pass, expected);
    }
   

    
}
