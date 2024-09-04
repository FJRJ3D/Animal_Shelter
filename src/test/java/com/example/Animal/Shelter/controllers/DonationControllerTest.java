package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Donation;
import com.example.Animal.Shelter.services.DonationService;
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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class DonationControllerTest {
    @Mock 
    private DonationService donationService;
    @InjectMocks
    private DonationController donationController;
    private MockMvc mockMvc;

    private Donation donorBruce;
    private Donation donorAnon;
    private List<Donation> donationsList = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(donationController).build();

        donorBruce = new Donation();
        donorBruce.setId(1);
        donorBruce.setQuantity(20000);
        donorBruce.setDate(LocalDate.of(2024, 06, 24));
        donorBruce.setDonor("Bruce Wayne");

        donorAnon = new Donation();
        donorAnon.setId(2);
        donorAnon.setQuantity(500);
        donorAnon.setDate(LocalDate.of(2024, 02, 10));
        donorAnon.setDonor("Anonymous Donor");

        donationsList.add(donorBruce);
        donationsList.add(donorAnon);
    }

    @Test
    void createDonations() {

       when(donationService.createDonations(any(Donation.class))).thenReturn(donorBruce);

        Donation result = donationController.createDonations(donorBruce);

        assertNotNull(result);
        assertEquals(donorBruce.getId(), result.getId());
        assertEquals(donorBruce.getQuantity(), result.getQuantity());
        assertEquals(LocalDate.of(2024, 06, 24), result.getDate());
        assertEquals("Bruce Wayne", result.getDonor());
    }

    @Test
    void getAllDonations() throws Exception{
        when(donationService.getAllDonations()).thenReturn(donationsList);
        mockMvc.perform(get("/api/v1/donations/get"))
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
        when(donationService.getDonationsbyId(1)).thenReturn(Optional.of(donorBruce));
        mockMvc.perform(get("/api/v1/donations/get/1"))
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.quantity").value(20000))
            .andExpect(jsonPath("$.date").value("24-06-2024"))
            .andExpect(jsonPath("$.donor").value("Bruce Wayne"));
    }

    @Test
    void updateDonations() throws Exception {
        Donation updatedDonations = new Donation();
        updatedDonations.setId(1);
        updatedDonations.setQuantity(40000);
        updatedDonations.setDate(LocalDate.of(2023,05,12));
        updatedDonations.setDonor("Bruce Wayne");


        mockMvc.perform(put("/api/v1/donations/put/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"quantity\":40000.0,\"date\":\"12-05-2024\",\"donor\":\"Bruce Wayne\"}"))
                .andExpect(status().isOk());
                verify(donationService).updateDonations(any(Donation.class), any(Integer.class));

                
    }

    @Test
    void deleteDonations() throws Exception {
        doNothing().when(donationService).deleteDonations(2);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/donations/delete/1")).andExpect(status().isOk());
    }

}
