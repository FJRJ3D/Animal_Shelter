package com.example.Animal.Shelter.repositories;

import com.example.Animal.Shelter.models.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDonationRepository extends JpaRepository<Donation, Integer> {}
