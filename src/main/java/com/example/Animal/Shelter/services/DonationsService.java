package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.models.Donations;
import com.example.Animal.Shelter.repositories.IDonationsRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationsService {

    @Autowired
    IDonationsRepository iDonationsRepository;

    public Donations createDonations(Donations newDonations) {
        return iDonationsRepository.save(newDonations);
    }

    public List<Donations> getAllDonations() {
        return (List<Donations>) iDonationsRepository.findAll();
    }

    public Optional<Donations> getDonationsbyId(int id) {
        Donations donations = iDonationsRepository.findById(id).orElseThrow();
        return Optional.of(donations);
    }


}
