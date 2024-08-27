package com.example.Animal.Shelter.services;

import static org.junit.jupiter.api.Assertions.*;
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
    }

}
