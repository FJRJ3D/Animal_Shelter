package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/as")
public class PetsController {

    @Autowired
    PetsService petsService;


}
