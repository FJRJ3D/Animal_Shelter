package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/as")
public class PetsController {

  @Autowired PetsService petsService;

  @GetMapping(path = "/pets/{id}")
  public void getPetsById(@PathVariable Integer id){
    petsService.getPetsById(id);
  }

  @PutMapping(path = "/pets/{id}")
  public void updatePets(@RequestBody Pets pets, @PathVariable Integer id) {
    petsService.updatePets(pets, id);
  }
  @DeleteMapping(path = "/pets/{id}")
  public void deletePets(@PathVariable Integer id) {
    petsService.deletePets(id);
  }
}
