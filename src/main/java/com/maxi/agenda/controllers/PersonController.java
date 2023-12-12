package com.maxi.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.agenda.dtos.PersonDTO;
import com.maxi.agenda.services.PersonServiceImplementation;

@RestController
@RequestMapping("/api/agenda")
public class PersonController {

    @Autowired
    private PersonServiceImplementation service;

    @PostMapping("/create")
    public ResponseEntity<?> createNew(@RequestBody PersonDTO obj) {
        return ResponseEntity.ok().body(service.addPerson(obj));
    }

}
