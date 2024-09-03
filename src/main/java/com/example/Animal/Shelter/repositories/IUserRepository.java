package com.example.Animal.Shelter.repositories;

import com.example.Animal.Shelter.models.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUsername(String username);
}
