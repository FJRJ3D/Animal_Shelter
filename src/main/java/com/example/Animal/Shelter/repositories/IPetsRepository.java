package com.example.Animal.Shelter.repositories;

import com.example.Animal.Shelter.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPetsRepository extends JpaRepository<Pet, Integer> {
}
