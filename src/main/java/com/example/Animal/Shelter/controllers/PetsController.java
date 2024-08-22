package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.services.PetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/as")
public class PetsController {

  @Autowired PetsService petsService;

  @PostMapping(path = "/pets")
  public Pets createPets(@RequestBody Pets pets){
    return petsService.createPets(pets);
  }

  @GetMapping(path = "/pets")
  public ArrayList<Pets> getAllPets(){
    return petsService.getAllPets();
  }

  @GetMapping(path = "/pets/{id}")
  public Optional<Pets> getPetsById(@PathVariable Integer id){
    return petsService.getPetsById(id);
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
