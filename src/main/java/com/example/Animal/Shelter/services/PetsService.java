package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.repositories.IPetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetsService {

  @Autowired IPetsRepository iPetsRepository;

  public void deletePets(Integer id) {
    iPetsRepository.deleteById(id);
  }
}
