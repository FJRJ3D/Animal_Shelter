package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.models.Pet;
import com.example.Animal.Shelter.repositories.IPetsRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

  @Autowired IPetsRepository iPetsRepository;

  public Pet createPets(Pet pet){
    return iPetsRepository.save(pet);
  }

  public ArrayList<Pet> getAllPets(){
    return (ArrayList<Pet>) iPetsRepository.findAll();
  }

  public Optional<Pet> getPetsById(Integer id){
    return iPetsRepository.findById(id);
  }

  public void updatePets(Pet pet, Integer id) {
    pet.setId(id);
    iPetsRepository.save(pet);
  }

  public void deletePets(Integer id) {
    iPetsRepository.deleteById(id);
  }
}
