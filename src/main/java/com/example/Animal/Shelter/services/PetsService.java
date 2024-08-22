package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.repositories.IPetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

  @Autowired IPetsRepository iPetsRepository;

  public Pets createPets(Pets pets){
    return iPetsRepository.save(pets);
  }

  public void updatePets(Pets pets, Integer id) {
    pets.setId(id);
    iPetsRepository.save(pets);
  }

  public void deletePets(Integer id) {
    iPetsRepository.deleteById(id);
  }
}
