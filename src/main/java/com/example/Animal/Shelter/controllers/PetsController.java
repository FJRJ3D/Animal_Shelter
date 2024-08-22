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

  @PostMapping(path = "pets")
  public Pets createPets(@RequestBody Pets pets){
    return petsService.createPets(pets);
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
