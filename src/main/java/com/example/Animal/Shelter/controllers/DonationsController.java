package com.example.Animal.Shelter.controllers;

import com.example.Animal.Shelter.models.Donations;
import com.example.Animal.Shelter.services.DonationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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


}
