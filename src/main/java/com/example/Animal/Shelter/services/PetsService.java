package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.models.Pet;
import com.example.Animal.Shelter.repositories.IPetRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

  @Autowired IPetRepository iPetRepository;

  public Pet createPets(Pet pet) {
    return iPetRepository.save(pet);
  }

  public ArrayList<Pet> getAllPets() {
    return (ArrayList<Pet>) iPetRepository.findAll();
  }

  public Optional<Pet> getPetsById(Integer id) {
    return iPetRepository.findById(id);
  }

  public void updatePets(Pet pet, Integer id) {
    pet.setId(id);
    iPetRepository.save(pet);
  }

  public void updateOwner(Pet pet, Integer id) {
    pet.getUser().setId(id);
    iPetRepository.save(pet);
  }

  public void deletePets(Integer id) {
    iPetRepository.deleteById(id);
  }
}
