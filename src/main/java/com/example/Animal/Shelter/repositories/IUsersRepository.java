package com.example.Animal.Shelter.repositories;

import com.example.Animal.Shelter.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
}
