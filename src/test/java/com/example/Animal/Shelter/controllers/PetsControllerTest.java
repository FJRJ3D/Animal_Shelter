package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.repositories.IPetsRepository;
import com.example.Animal.Shelter.services.PetsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetsControllerTest {
    @Mock
    private PetsService petsService;
    @InjectMocks
    private PetsController petsController;
    private MockMvc mockMvc;

    private Pets petLolo;
    private Pets petPitu;
    private List<Pets> petsList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(petsController).build();

        petLolo = new Pets();
        petLolo.setId(1);
        petLolo.setName("Lolo");
        petLolo.setPicture("https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/202931.jpg");
        petLolo.setAnimalType("Dog");
        petLolo.setRace("Rottweiler");
        petLolo.setBirthDate(LocalDate.of(2024,8, 17));
        petLolo.setGender(false);
        petLolo.setStatus(false);
        petLolo.setSterilized(false);
        petLolo.setTimeInTheShelter(LocalDate.of(2024,9,5));
        petLolo.setDescription("Very affectionate and playful puppy");

        petPitu = new Pets();
        petPitu.setId(2);
        petPitu.setName("Pitu");
        petPitu.setPicture("https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg");
        petPitu.setAnimalType("Cat");
        petPitu.setRace("Orange tabby");
        petPitu.setBirthDate(LocalDate.of(2022,4, 18));
        petPitu.setGender(false);
        petPitu.setStatus(false);
        petPitu.setSterilized(true);
        petPitu.setTimeInTheShelter(LocalDate.of(2023,5,5));
        petPitu.setDescription("Playful cat");

        petsList.add(petLolo);
        petsList.add(petPitu);
    }

    @Test
    void createPets() {
    }

    @Test
    void getAllPets() {
    }

    @Test
    void getPetsById() {
    }

    @Test
    void updatePets() {
    }

    @Test
    void deletePets() {
    }
}