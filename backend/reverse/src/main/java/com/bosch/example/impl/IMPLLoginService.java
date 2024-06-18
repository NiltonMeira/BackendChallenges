package com.bosch.example.impl;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Autowired;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.bosch.example.repositories.UserJPARepository;
import com.bosch.example.services.LoginService;

public class IMPLLoginService implements LoginService {

    @Autowired
    UserJPARepository repo;

    @Override
    public Boolean checkUsername(String username) {
        if (repo.findByUsername(username).size() > 0)
            return true;
        else
            return false;

    }

    @Override
    public Boolean checkEmail(String email) {
        if (repo.findByUsername(email).size() > 0)
            return true;
        else
            return false;
    }

    @Override
    public String createToken(PublicKey publicKey, PrivateKey privateKey) {
        try {
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey)publicKey, (RSAPrivateKey)privateKey);
            String token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            return "Não foi possivel criar o token";
        }
    }
}
