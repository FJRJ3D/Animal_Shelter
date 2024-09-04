package com.example.Animal.Shelter.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.Animal.Shelter.models.Pet;
import com.example.Animal.Shelter.services.PetService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PetControllerTest {
  @Mock
  private PetService petService;

  @InjectMocks
  private PetController petController;

  private MockMvc mockController;

  private Pet petLolo;
  private Pet petPitu;
  private ArrayList<Pet> petsList = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);

    mockController = MockMvcBuilders.standaloneSetup(petController).build();

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

    petsList.add(petLolo);
    petsList.add(petPitu);
  }

  @Test
  void createPets() throws Exception {
    when(petService.createPets(any(Pet.class))).thenReturn(petLolo);

    String petsJson =
        "{\"id\": 1,\n"
            + "\"name\": \"Lolo\",\n"
            + "\"picture\": \"https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/"
            + "202931.jpg\",\n"
            + "\"animalType\": \"Dog\",\n"
            + "\"race\": \"Rottweiler\",\n"
            + "\"gender\": false,\n"
            + "\"status\": false,\n"
            + "\"birthDate\": \"17-08-2024\",\n"
            + "\"sterilized\": false,\n"
            + "\"timeInTheShelter\": \"05-09-2024\",\n"
            + "\"description\": \"Very affectionate and playful puppy\"}";

    //Testeo el controller
    mockController
        .perform(post("/api/v1/news/post").contentType(MediaType.APPLICATION_JSON).content(petsJson))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    "{\"id\": 1,\n"
                        + "\"name\": \"Lolo\",\n"
                        + "\"picture\": \"https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/"
                        + "202931.jpg\",\n"
                        + "\"animalType\": \"Dog\",\n"
                        + "\"race\": \"Rottweiler\",\n"
                        + "\"gender\": false,\n"
                        + "\"status\": false,\n"
                        + "\"birthDate\": \"17-08-2024\",\n"
                        + "\"sterilized\": false,\n"
                        + "\"timeInTheShelter\": \"05-09-2024\",\n"
                        + "\"description\": \"Very affectionate and playful puppy\"}"));
  }

  @Test
  void getAllPets() throws Exception {
    when(petService.getAllPets()).thenReturn(petsList);

    mockController
        .perform(MockMvcRequestBuilders.get("/api/v1/news/get"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    "[\n"
                        + "    {\n"
                        + "        \"id\": 1,\n"
                        + "        \"name\": \"Lolo\",\n"
                        + "        \"picture\": \"https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/"
                        + "w_1600,c_limit/202931.jpg\",\n"
                        + "        \"animalType\": \"Dog\",\n"
                        + "        \"race\": \"Rottweiler\",\n"
                        + "        \"gender\": false,\n"
                        + "        \"status\": false,\n"
                        + "        \"birthDate\": \"17-08-2024\",\n"
                        + "        \"sterilized\": false,\n"
                        + "        \"timeInTheShelter\": \"05-09-2024\",\n"
                        + "        \"description\": \"Very affectionate and playful puppy\"\n"
                        + "    },\n"
                        + "    {\n"
                        + "        \"id\": 2,\n"
                        + "        \"name\": \"Pitu\",\n"
                        + "        \"picture\": \"https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg\",\n"
                        + "        \"animalType\": \"Cat\",\n"
                        + "        \"race\": \"Orange tabby\",\n"
                        + "        \"gender\": false,\n"
                        + "        \"status\": false,\n"
                        + "        \"birthDate\": \"18-04-2022\",\n"
                        + "        \"sterilized\": true,\n"
                        + "        \"timeInTheShelter\": \"05-05-2023\",\n"
                        + "        \"description\": \"Playful cat\"\n"
                        + "    }\n"
                        + "]"));
  }

  @Test
  void getPetsById() throws Exception {
    when(petService.getPetsById(anyInt())).thenReturn(Optional.ofNullable(petLolo));
    mockController
        .perform(MockMvcRequestBuilders.get("/api/v1/news/get/1"))
        .andExpect(status().isOk())
        .andExpect(
            content()
                .json(
                    "{\"id\": 1,\n"
                        + "\"name\": \"Lolo\",\n"
                        + "\"picture\": \"https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/w_1600,c_limit/"
                        + "202931.jpg\",\n"
                        + "\"animalType\": \"Dog\",\n"
                        + "\"race\": \"Rottweiler\",\n"
                        + "\"gender\": false,\n"
                        + "\"status\": false,\n"
                        + "\"birthDate\": \"17-08-2024\",\n"
                        + "\"sterilized\": false,\n"
                        + "\"timeInTheShelter\": \"05-09-2024\",\n"
                        + "\"description\": \"Very affectionate and playful puppy\"}"));
  }

  @Test
  void updatePets() throws Exception {
    Pet updatePets = new Pet();
    updatePets.setId(2);
    updatePets.setDescription("Playful cat but a little unsociable");
    updatePets.setRace("Orange cat");

    String updatePetsJson =
        "{\"id\": 2,\n"
            + "\"Description\": \"Playful cat but a little unsociable\",\n"
            + "\"Race\": \"Orange cat\"}";

    mockController
        .perform(
            MockMvcRequestBuilders.put("/api/v1/news/put/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updatePetsJson))
        .andExpect(status().isOk());

    verify(petService).updatePets(any(Pet.class), any(Integer.class));
  }

  @Test
  void deletePets() throws Exception {
    doNothing().when(petService).deletePets(1);

    mockController.perform(MockMvcRequestBuilders.delete("/api/v1/news/delete/1")).andExpect(status().isOk());
  }
}
