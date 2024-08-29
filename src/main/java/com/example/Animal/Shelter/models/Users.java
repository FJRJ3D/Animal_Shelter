package com.example.Animal.Shelter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "Name")
  private String name;

  @Column(name = "Password")
  private String password;

  @Column(name = "Adopted Animals")
  private String adoptedAnimals;

  @Column(name = "Role")
  private String role;

  @OneToMany(
      mappedBy = "users",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Pets> pets = new ArrayList<>();
}
