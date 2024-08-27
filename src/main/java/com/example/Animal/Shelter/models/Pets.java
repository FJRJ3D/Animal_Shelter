package com.example.Animal.Shelter.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Picture")
    private String picture;

    @Column(name = "Animal Type")
    private String animalType;

    @Column(name = "Race")
    private String race;

    @Column(name = "Gender")
    private boolean gender;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "Birth Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birthDate;

    @Column(name = "Sterilized")
    private boolean sterilized;

    @Column(name = "Time in the Shelter")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate timeInTheShelter;

    @Column(name = "Description")
    private String description;
}
