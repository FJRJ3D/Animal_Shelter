package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Pet;
import com.example.Animal.Shelter.services.PetsService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/news")
public class PetsController {

  @Autowired PetsService petsService;

  @PostMapping(path = "/pets")
  public Pet createPets(@RequestBody Pet pet){
    return petsService.createPets(pet);
  }

  @GetMapping
  public ArrayList<Pet> getAllPets(){
    return petsService.getAllPets();
  }

  @GetMapping(path = "/pets/{id}")
  public Optional<Pet> getPetsById(@PathVariable Integer id){
    return petsService.getPetsById(id);
  }

  @PutMapping(path = "/pets/{id}")
  public void updatePets(@RequestBody Pet pet, @PathVariable Integer id) {
    petsService.updatePets(pet, id);
  }

  @DeleteMapping(path = "/pets/{id}")
  public void deletePets(@PathVariable Integer id) {
    petsService.deletePets(id);
  }
}
