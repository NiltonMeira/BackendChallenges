package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.Pass;
import com.bosch.example.impl.DatabaseUserService;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.PassService;

@RestController
public class PassController {

    @Autowired
    UserJPARepository repo;

    @Autowired
    PassService service;

    @PatchMapping("/changepassword")
    public String checkPass (@RequestBody Pass pass){
        Boolean checkPass = service.checkPassword(pass);
        var userList = repo.findByUsername(pass.username());
        Boolean userExists = userList.size() > 0;
        Boolean equalPass = userList.get(0).getPassword().equals(pass.password());
        Boolean equalNewPass = pass.newPassword().equals(pass.repeatPassword()); 
        
        if(!checkPass){
            return "Nova senha invalida!";
        }

        if(!userExists)
        {
            return "O usuario não existe!";
        }

        if(!equalPass)
        {
            return "As senhas não são iguais!";
        }

        if (!equalNewPass) {
            return "As novas senhas não são iguais!";
        }

        userList.get(0).setPassword(pass.newPassword());
        repo.save(userList.get(0));
        return "Sucesso!";

    }


    
}
