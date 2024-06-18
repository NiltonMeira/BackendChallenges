package com.bosch.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bosch.example.impl.DatabaseCityService;
import com.bosch.example.impl.DatabaseUserService;
import com.bosch.example.impl.IMPLCollatzService;
import com.bosch.example.impl.IMPLLoginService;
import com.bosch.example.impl.IMPLNumberService;
import com.bosch.example.impl.IMPLPassService;
import com.bosch.example.impl.IMPLReverseService;
import com.bosch.example.impl.KeypairManager;
import com.bosch.example.services.CityService;
import com.bosch.example.services.CreateService;
import com.bosch.example.services.LoginService;
import com.bosch.example.services.PassService;

@Configuration
public class DependenciesConfiguration {

    @Bean
    @Scope("singleton")
    public IMPLReverseService userService(){
        return new IMPLReverseService();
    }

    @Bean
    @Scope("singleton")
    public IMPLNumberService numberService(){
        return new IMPLNumberService();
    }

    @Bean
    @Scope("singleton")
    public IMPLCollatzService collatzService(){
        return new IMPLCollatzService();
    }

    @Bean
    @Scope("singleton")
    public CityService cityService(){
        return new DatabaseCityService();
    }

    @Bean
    @Scope("singleton")
    public CreateService createService(){
        return new DatabaseUserService();
    }

    @Bean
    @Scope("singleton")
    public PassService passService(){
        return new IMPLPassService();
    }

    @Bean
    @Scope("singleton")
    public LoginService loginService(){
        return new IMPLLoginService();
    }

    @Bean
    @Scope("singleton")
    public KeypairManager keyService(){
        return new KeypairManager();
    }


    
}
