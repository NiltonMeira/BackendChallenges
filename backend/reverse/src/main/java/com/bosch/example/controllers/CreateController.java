package com.bosch.example.controllers;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.impl.DatabaseUserService;
import com.bosch.example.model.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class CreateController {

    @Autowired
    DatabaseUserService repo;

    @PostMapping("/create")
    public String validadeUser(@RequestBody User user) {
        Boolean checkName = repo.checkUsername(user);
        Boolean checkEmail = repo.checkEmail(user);
        Boolean checkPAss = repo.checkPassword(user);
        Boolean validateEmail = repo.isValidEmail(user);

        if (!checkName) {
            return "Usuario já existe";
        }

        if ((!checkEmail)) {
            return "Email ja existe";
        }

        if (!checkPAss) {
            return "Senha invalida";
        }

        if (!validateEmail) {
            return "Email invalido";
            
        }

        return "Usuario criado com sucesso";  
    
    }
}
