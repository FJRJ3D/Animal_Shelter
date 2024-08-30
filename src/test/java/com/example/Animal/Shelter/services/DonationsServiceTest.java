package com.example.Animal.Shelter.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.example.Animal.Shelter.models.Donations;
import com.example.Animal.Shelter.repositories.IDonationsRepository;
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

class DonationsServiceTest {
    @Mock private IDonationsRepository iDonationsRepository;
    @InjectMocks private DonationsService donationsService;

    private Donations donorBruce;
    private Donations donorAnon;

    private List<Donations> donationsList = new ArrayList<>();
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
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
        when(iDonationsRepository.save(ArgumentMatchers.any(Donations.class))).thenReturn(donorAnon);

        Donations result = donationsService.createDonations(donorAnon);
        assertEquals(2, result.getId());
        assertEquals(500, result.getQuantity());
        assertEquals(LocalDate.of(2024, 02, 10), result.getDate());
        assertEquals("Anonymous Donor", result.getDonor());
    }

    @Test

    void getAllDonations() {
        when(iDonationsRepository.findAll()).thenReturn(donationsList);

        List<Donations> result = donationsService.getAllDonations();

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).getId());
        assertEquals(20000, result.get(0).getQuantity());
        assertEquals(LocalDate.of(2024, 06, 24), result.get(0).getDate());
        assertEquals("Bruce Wayne", result.get(0).getDonor());

        assertEquals(2, result.get(1).getId());
        assertEquals(500, result.get(1).getQuantity());
        assertEquals(LocalDate.of(2024, 02, 10), result.get(1).getDate());
        assertEquals("Anonymous Donor", result.get(1).getDonor());
    }

    @Test
    public void getAppointmentId(){
        when(iDonationsRepository.findById(2)).thenReturn(Optional.of(donorAnon));
        Optional<Donations> donationsId = donationsService.getDonationsbyId(2);
        assertEquals("Anonymous Donor", donationsId.get().getDonor());
          }

    @Test
  void deleteDonations() {
    when(iDonationsRepository.findById(2)).thenReturn(Optional.of(donorAnon));

    donationsService.deleteDonations(2);

    verify(iDonationsRepository, times(1)).deleteById(2);      
}

    @Test
    void updateDonations() {
         when(iDonationsRepository.save(any(Donations.class))).thenReturn(donorAnon);
    Donations update = donorAnon;
    update.setQuantity(650);

    donationsService.updateDonations(update, 2);
    assertEquals(2, update.getId());
    assertEquals(650, update.getQuantity());
    assertEquals(LocalDate.of(2024, 2, 10), update.getDate());
    assertEquals("Anonymous Donor", update.getDonor());
    

    verify(iDonationsRepository, times(1)).save(update);

    }

}
