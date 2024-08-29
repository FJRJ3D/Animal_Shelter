package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.models.Donation;
import com.example.Animal.Shelter.repositories.IDonationsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationsService {

    @Autowired
    IDonationsRepository iDonationsRepository;

    public Donation createDonations(Donation newDonation) {
        return iDonationsRepository.save(newDonation);
    }

    public List<Donation> getAllDonations() {
        return (List<Donation>) iDonationsRepository.findAll();
    }

    public Optional<Donation> getDonationsbyId(int id) {
        Donation donation = iDonationsRepository.findById(id).orElseThrow();
        return Optional.of(donation);
    }

    public void updateDonations(Donation donation, int id) {
        donation.setId(id);
        iDonationsRepository.save(donation);
    }

    public void deleteDonations(int id) {
        iDonationsRepository.deleteById(id);
    }


}
