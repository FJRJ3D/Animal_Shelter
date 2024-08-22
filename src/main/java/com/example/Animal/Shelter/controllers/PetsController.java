package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/as")
public class PetsController {

  @Autowired PetsService petsService;

  @DeleteMapping(path = "/pets/{id}")
  public void deletePets(@PathVariable Integer id) {
    petsService.deletePets(id);
  }
  public void
}
