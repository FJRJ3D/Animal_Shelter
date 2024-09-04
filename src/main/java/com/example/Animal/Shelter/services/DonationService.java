package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.models.Donation;
import com.example.Animal.Shelter.repositories.IDonationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonationService {

  @Autowired IDonationRepository iDonationRepository;

  public Donation createDonations(Donation newDonation) {
    return iDonationRepository.save(newDonation);
  }

  public List<Donation> getAllDonations() {
    return (List<Donation>) iDonationRepository.findAll();
  }

  public Optional<Donation> getDonationsbyId(int id) {
    Donation donation = iDonationRepository.findById(id).orElseThrow();
    return Optional.of(donation);
  }

  public void updateDonations(Donation donation, int id) {
    donation.setId(id);
    iDonationRepository.save(donation);
  }

  public void deleteDonations(int id) {
    iDonationRepository.deleteById(id);
  }
}
