package com.example.Animal.Shelter.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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
    @GeneratedValue
    Integer id;

    @Column(nullable = false)
    String username;
    String email;
    String password;

    @Enumerated(EnumType.STRING)
    ERole role;

    @Column(name = "Password")
    private String password;

    @Column(name = "Adopted Animals")
    private String adoptedAnimals;

    @Column(name = "Role")
    private String role;

    @OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Pets> pets = new ArrayList<Pets>();
}
