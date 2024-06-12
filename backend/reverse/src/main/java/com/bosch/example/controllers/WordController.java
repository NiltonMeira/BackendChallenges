package com.bosch.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bosch.example.dto.Word;
import com.bosch.example.impl.IMPLReverseService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController

public class WordController {

    @Autowired
    IMPLReverseService service;


    @GetMapping("/reverse/{word}")
    public Word getWord(@PathVariable String word) {
        return service.WordReverse(word);
    }
    
    
}
