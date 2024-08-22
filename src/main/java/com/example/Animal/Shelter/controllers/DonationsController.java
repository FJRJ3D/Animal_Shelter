package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Donations;
import com.example.Animal.Shelter.services.DonationsService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Donations createDonations(@RequestBody Donations donations){
        return donationsService.createDonations(donations);
    }

    @GetMapping(path = "/Donations")
    public List<Donations> getAllDonations() {
        return donationsService.getAllDonations();
    }

    @GetMapping(path = "/Donations/{id}")
        public Optional<Donations> getDonationsbyId(@PathVariable int id) {
            return donationsService.getDonationsbyId(id);
        }
    }
