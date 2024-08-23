package com.example.Animal.Shelter.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.repositories.IPetsRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PetsServiceTest {
  @Mock private IPetsRepository iPetsRepository;
  @InjectMocks private PetsService petsService;

  private Pets petLolo;
  private Pets petPitu;

  private List<Pets> petsList = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    Pets petLolo = new Pets();
    petLolo.setId(1);
    petLolo.setName("Lolo");
    petLolo.setPicture("https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/202931.jpg");
    petLolo.setAnimalType("Dog");
    petLolo.setRace("Rottweiler");
    petLolo.setBirthDate(LocalDate.of(2024,8, 17);
    petLolo.setGender(false);
    petLolo.setStatus(false);
    petLolo.setSterilized(false);
    petLolo.setTimeInTheShelter(LocalDate.of(2024,9,5));
    petLolo.setDescription("Very affectionate and playful puppy");

    Pets petPitu = new Pets();
    petPitu.setId(2);
    petPitu.setName("Pitu");
    petLolo.setPicture("https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg");
    petLolo.setAnimalType("Cat");
    petLolo.setRace("Orange tabby");
    petLolo.setBirthDate(LocalDate.of(2022,4, 18);
    petLolo.setGender(false);
    petLolo.setStatus(false);
    petLolo.setSterilized(true);
    petLolo.setTimeInTheShelter(LocalDate.of(2023,5,5));
    petLolo.setDescription("Playful cat");

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
