package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.repositories.IDonationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationsService {

    @Autowired
    IDonationsRepository iDonationsRepository;


}
