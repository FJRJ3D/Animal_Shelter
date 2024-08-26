package com.example.Animal.Shelter.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.services.PetsService;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
class PetsControllerTest {
  @Mock private PetsService petsService;
  @InjectMocks private PetsController petsController;
  private MockMvc mockMvc;

  private Pets petLolo;
  private Pets petPitu;
  private ArrayList<Pets> petsList = new ArrayList<>();

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(petsController).build();

    petLolo = new Pets();
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

    petPitu = new Pets();
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
  void createPets() {}

  @Test
  void getAllPets() throws Exception {
    when(petsService.getAllPets()).thenReturn(petsList);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/as/pets"))
            .andExpect(status().isOk())
            .andExpect(content().json(
           "[\n" +
                   "    {\n" +
                   "        \"id\": 1,\n" +
                   "        \"name\": \"Lolo\",\n" +
                   "        \"picture\": \"https://media.traveler.es/photos/613760adcb06ad0f20e11980/master/" +
                   "w_1600,c_limit/202931.jpg\",\n" +
                   "        \"animalType\": \"Dog\",\n" +
                   "        \"race\": \"Rottweiler\",\n" +
                   "        \"gender\": false,\n" +
                   "        \"status\": false,\n" +
                   "        \"birthDate\": \"17-08-2024\",\n" +
                   "        \"sterilized\": false,\n" +
                   "        \"timeInTheShelter\": \"05-09-2024\",\n" +
                   "        \"description\": \"Very affectionate and playful puppy\"\n" +
                   "    },\n" +
                   "    {\n" +
                   "        \"id\": 2,\n" +
                   "        \"name\": \"Pitu\",\n" +
                   "        \"picture\": \"https://img2.rtve.es/i/?w=1600&i=1618587961630.jpg\",\n" +
                   "        \"animalType\": \"Cat\",\n" +
                   "        \"race\": \"Orange tabby\",\n" +
                   "        \"gender\": false,\n" +
                   "        \"status\": false,\n" +
                   "        \"birthDate\": \"18-04-2022\",\n" +
                   "        \"sterilized\": true,\n" +
                   "        \"timeInTheShelter\": \"05-05-2023\",\n" +
                   "        \"description\": \"Playful cat\"\n" +
                   "    }\n" +
                   "]"));
  }

  @Test
  void getPetsById() {}

  @Test
  void updatePets() {}

  @Test
  void deletePets() {}
}
