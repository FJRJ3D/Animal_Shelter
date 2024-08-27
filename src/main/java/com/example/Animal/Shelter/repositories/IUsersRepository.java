package com.example.Animal.Shelter.repositories;

import com.example.Animal.Shelter.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
}
