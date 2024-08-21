package com.example.Animal.Shelter.repositories;

import com.example.Animal.Shelter.models.Donations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonationsRepository extends JpaRepository<Donations, Integer> {
}
