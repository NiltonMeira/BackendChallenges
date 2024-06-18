package com.bosch.example.controllers;

import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bosch.example.dto.Login;
import com.bosch.example.dto.Message;
import com.bosch.example.impl.DatabaseUserService;
import com.bosch.example.impl.KeypairManager;
import com.bosch.example.impl.UserEncoder;
import com.bosch.example.model.User;

@RestController
public class loginController {
    UserEncoder encoder = new UserEncoder();

    @Autowired
    DatabaseUserService repo;

    @Autowired
    KeypairManager keypair;

    @PostMapping("/login")
    public Message validadeUser(@RequestBody Login login) {
        List<User> users = repo.findUser(login.login());

        users = users.size() > 0 ? users : repo.findEmail(login.login());

        if (users.size() == 0)
            return new Message(null, "Usuario não encontrado");

        var user = users.get(0);

        if (!encoder.compare(login.password(), user.getPassword()))
            return new Message(null, "Senha incorreta");

        Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) keypair.getPublicKey(),
                (RSAPrivateCrtKey) keypair.getPrivateKey());
        String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);

        return new Message(token, "Sucesso");
    }
}
