package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Donations;
import com.example.Animal.Shelter.models.Pets;
import com.example.Animal.Shelter.repositories.IPetsRepository;
import com.example.Animal.Shelter.services.DonationsService;
import com.example.Animal.Shelter.services.PetsService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class DonationsControllerTest {
    @Mock 
    private DonationsService donationsService;
    @InjectMocks
    private DonationsController donationsController;
    private MockMvc mockMvc;

    private Donations donorBruce;
    private Donations donorAnon;
    private List<Donations> donationsList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(donationsController).build();

        donorBruce = new Donations();
        donorBruce.setId(1);
        donorBruce.setQuantity(20000);
        donorBruce.setDate(LocalDate.of(2024, 06, 24));
        donorBruce.setDonor("Bruce Wayne");

        donorAnon = new Donations();
        donorAnon.setId(2);
        donorAnon.setQuantity(500);
        donorAnon.setDate(LocalDate.of(2024, 02, 10));
        donorAnon.setDonor("Anonymous Donor");

        donationsList.add(donorBruce);
        donationsList.add(donorAnon);
    }

    @Test
    void createDonations() {

       when(donationsService.createDonations(any(Donations.class))).thenReturn(donorBruce);

        Donations result = donationsController.createDonations(donorBruce);

        assertNotNull(result);
        assertEquals(donorBruce.getId(), result.getId());
        assertEquals(donorBruce.getQuantity(), result.getQuantity());
        assertEquals(LocalDate.of(2024, 06, 24), result.getDate());
        assertEquals("Bruce Wayne", result.getDonor());
    }

    @Test
    void getAllDonations() throws Exception{
        when(donationsService.getAllDonations()).thenReturn(donationsList);
        mockMvc.perform(get("/api/as/Donations"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].quantity").value(20000))
            .andExpect(jsonPath("$[0].date").value("24-06-2024"))
            .andExpect(jsonPath("$[0].donor").value("Bruce Wayne"))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].quantity").value(500))
            .andExpect(jsonPath("$[1].date").value("10-02-2024"))
            .andExpect(jsonPath("$[1].donor").value("Anonymous Donor"));
    }

    @Test
    void getDonationsById() throws Exception{
        when(donationsService.getDonationsbyId(1)).thenReturn(Optional.of(donorBruce));
        mockMvc.perform(get("/api/as/Donations/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.quantity").value(20000))
            .andExpect(jsonPath("$.date").value("24-06-2024"))
            .andExpect(jsonPath("$.donor").value("Bruce Wayne"));
    }

    @Test
    void updateDonations() throws Exception {
        Donations updatedDonations = new Donations();
        updatedDonations.setId(1);
        updatedDonations.setQuantity(40000);
        updatedDonations.setDate(LocalDate.of(2023,05,12));
        updatedDonations.setDonor("Bruce Wayne");


        mockMvc.perform(put("/api/as/Donations/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"quantity\":40000.0,\"date\":\"12-05-2024\",\"donor\":\"Bruce Wayne\"}"))
                .andExpect(status().isOk());
                verify(donationsService).updateDonations(any(Donations.class), any(Integer.class));

                
    }

    @Test
    void deleteDonations() throws Exception {
        doNothing().when(donationsService).deleteDonations(2);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/as/Donations/2")).andExpect(status().isOk());
    }

}
