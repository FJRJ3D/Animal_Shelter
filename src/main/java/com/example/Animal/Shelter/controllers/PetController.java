package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Pet;
import com.example.Animal.Shelter.services.PetService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/news")
public class PetController {

  @Autowired
  PetService petService;

  @PostMapping(path = "/post")
  public Pet createPets(@RequestBody Pet pet){
    return petService.createPets(pet);
  }

  @GetMapping(path = "/get")
  public ArrayList<Pet> getAllPets(){
    return petService.getAllPets();
  }

  @GetMapping(path = "/get/{id}")
  public Optional<Pet> getPetsById(@PathVariable Integer id){
    return petService.getPetsById(id);
  }

  @PutMapping(path = "/put/{id}")
  public void updatePets(@RequestBody Pet pet, @PathVariable Integer id) {
    petService.updatePets(pet, id);
  }

  @DeleteMapping(path = "/delete/{id}")
  public void deletePets(@PathVariable Integer id) {
    petService.deletePets(id);
  }

  @PutMapping(path = "/owner/put/{id}")
  public void updateOwner(@RequestBody Pet pet, @PathVariable Integer id) {
    petService.updateOwner(pet, id);
  }
}
