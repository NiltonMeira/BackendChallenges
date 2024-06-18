package com.bosch.example.services;

import java.security.PrivateKey;
import java.security.PublicKey;

public interface LoginService {
    Boolean checkUsername(String username);
    Boolean checkEmail(String email);
    String createToken(PublicKey publicKey, PrivateKey privateKey);
}
