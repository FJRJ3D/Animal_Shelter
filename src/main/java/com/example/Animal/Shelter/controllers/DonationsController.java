package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Donation;
import com.example.Animal.Shelter.services.DonationsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/as")
public class DonationsController {

    @Autowired
    DonationsService donationsService;

    @PostMapping(path = "/Donations")
    public Donation createDonations(@RequestBody Donation donation){
        return donationsService.createDonations(donation);
    }

    @GetMapping(path = "/Donations")
    public List<Donation> getAllDonations() {
        return donationsService.getAllDonations();
    }

    @GetMapping(path = "/Donations/{id}")
        public Optional<Donation> getDonationsbyId(@PathVariable int id) {
            return donationsService.getDonationsbyId(id);
        }

    @PutMapping(path = "/Donations/{id}")
        public void updateDonations(@RequestBody Donation donation, @PathVariable int id) {
            donationsService.updateDonations(donation, id);
        }
    
    @DeleteMapping(path = "/Donations/{id}")
        public void deleteDonations(@PathVariable int id) {
            donationsService.deleteDonations(id);
        }
}
