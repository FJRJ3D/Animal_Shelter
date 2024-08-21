package com.example.Animal.Shelter.services;

import com.example.Animal.Shelter.repositories.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    IUsersRepository iUsersRepository;


}
