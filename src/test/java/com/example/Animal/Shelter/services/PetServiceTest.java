package com.example.Animal.Shelter.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.Animal.Shelter.models.Pet;
import com.example.Animal.Shelter.repositories.IPetRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class PetServiceTest {
  @Mock private IPetRepository iPetRepository;
  @InjectMocks private PetService petService;

  private Pet petLolo;
  private Pet petPitu;

  private List<Pet> petList = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    petLolo = new Pet();
    petLolo.setId(1);
    petLolo.setName("Lolo");
    petLolo.setPicture(
        "https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/202931.jpg");
    petLolo.setAnimalType("Dog");
    petLolo.setRace("Rottweiler");
    petLolo.setBirthDate(LocalDate.of(2024, 8, 17));
    petLolo.setGender(false);
    petLolo.setStatus(false);
    petLolo.setSterilized(false);
    petLolo.setTimeInTheShelter(LocalDate.of(2024, 9, 5));
    petLolo.setDescription("Very affectionate and playful puppy");

    petPitu = new Pet();
    petPitu.setId(2);
    petPitu.setName("Pitu");
    petPitu.setPicture("https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg");
    petPitu.setAnimalType("Cat");
    petPitu.setRace("Orange tabby");
    petPitu.setBirthDate(LocalDate.of(2022, 4, 18));
    petPitu.setGender(false);
    petPitu.setStatus(false);
    petPitu.setSterilized(true);
    petPitu.setTimeInTheShelter(LocalDate.of(2023, 5, 5));
    petPitu.setDescription("Playful cat");

    petList.add(petLolo);
    petList.add(petPitu);
  }

  @Test
  void createPets() {
    when(iPetRepository.save(ArgumentMatchers.any(Pet.class))).thenReturn(petLolo);

    Pet result = petService.createPets(petLolo);
    assertEquals(1, result.getId());
    assertEquals("Lolo", result.getName());
    assertEquals(
        "https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/202931.jpg",
        result.getPicture());
    assertEquals("Dog", result.getAnimalType());
    assertEquals("Rottweiler", result.getRace());
    assertEquals(LocalDate.of(2024, 8, 17), result.getBirthDate());
    assertFalse(result.isGender());
    assertFalse(result.isStatus());
    assertFalse(result.isSterilized());
    assertEquals(LocalDate.of(2024, 9, 5), result.getTimeInTheShelter());
    assertEquals("Very affectionate and playful puppy", result.getDescription());
  }

  @Test
  void getAllPets() {
    when(iPetRepository.findAll()).thenReturn(petList);

    List<Pet> result = petService.getAllPets();

    assertEquals(2, result.size());
    assertEquals(1, result.get(0).getId());
    assertEquals("Lolo", result.get(0).getName());
    assertEquals(
        "https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/202931.jpg",
        result.get(0).getPicture());
    assertEquals("Dog", result.get(0).getAnimalType());
    assertEquals("Rottweiler", result.get(0).getRace());
    assertEquals(LocalDate.of(2024, 8, 17), result.get(0).getBirthDate());
    assertFalse(result.get(0).isGender());
    assertFalse(result.get(0).isStatus());
    assertFalse(result.get(0).isSterilized());
    assertEquals(LocalDate.of(2024, 9, 5), result.get(0).getTimeInTheShelter());
    assertEquals("Very affectionate and playful puppy", result.get(0).getDescription());

    assertEquals(2, result.get(1).getId());
    assertEquals("Pitu", result.get(1).getName());
  }

  @Test
  void getPetsById() {
    when(iPetRepository.findById(anyInt())).thenReturn(Optional.of(petLolo));

    Optional<Pet> result = petService.getPetsById(0);

    assertEquals(1, result.get().getId());
    assertEquals("Lolo", result.get().getName());
    assertEquals(
        "https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/"
            + "202931.jpg",
        result.get().getPicture());
    assertEquals("Dog", result.get().getAnimalType());
    assertEquals("Rottweiler", result.get().getRace());
    assertEquals(LocalDate.of(2024, 8, 17), result.get().getBirthDate());
    assertFalse(result.get().isGender());
    assertFalse(result.get().isStatus());
    assertFalse(result.get().isSterilized());
    assertEquals(LocalDate.of(2024, 9, 5), result.get().getTimeInTheShelter());
    assertEquals("Very affectionate and playful puppy", result.get().getDescription());
  }

  @Test
  void updatePets() {
    when(iPetRepository.save(any(Pet.class))).thenReturn(petPitu);
    Pet update = petPitu;
    update.setRace("Orange");

    petService.updatePets(update, 2);
    assertEquals(2, update.getId());
    assertEquals("Pitu", update.getName());
    assertEquals("https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg", update.getPicture());
    assertEquals("Cat", update.getAnimalType());
    assertEquals(LocalDate.of(2022, 4, 18), update.getBirthDate());
    assertEquals(false, update.isGender());
    assertEquals(false, update.isStatus());
    assertEquals(true, update.isSterilized());
    assertEquals(LocalDate.of(2023, 5, 5), update.getTimeInTheShelter());
    assertEquals("Playful cat", update.getDescription());

    verify(iPetRepository, times(1)).save(update);
  }

  @Test
  void deletePets() {
    when(iPetRepository.findById(1)).thenReturn(Optional.of(petLolo));
    petService.deletePets(1);
    verify(iPetRepository, times(1)).deleteById(1);
  }
}
