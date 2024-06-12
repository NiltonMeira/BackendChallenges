package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.Collatz;
import com.bosch.example.impl.IMPLCollatzService;

@RestController
public class CollatzController {

    @Autowired
    IMPLCollatzService service;   


    @GetMapping("/collatz")
    public Collatz calcCollatz(@RequestParam Integer current, @RequestParam Integer step) {
        return service.collatz(current, step);
    }
}
