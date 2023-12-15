package com.maxi.agenda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.PersonDTO;
import com.maxi.agenda.dtos.PersonUpdateDTO;
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

    @GetMapping("/")
    public ResponseEntity<?> finfAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PersonDTO pDto = service.findById(id);
        return ResponseEntity.ok().body(pDto);
    }

    @GetMapping("/p/{email}")
    public ResponseEntity<?> findByEmail(@PathVariable String email) {
        Person pDto = service.findPersonEmail(email);
        return ResponseEntity.ok().body(pDto);
    }

    @PutMapping("/update/{id}")
    @Modifying
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PersonUpdateDTO obj) {
        PersonDTO personDTO = service.updatePerson(obj.getId(), obj);
        return ResponseEntity.ok().body(personDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deletePerson(id);
        return ResponseEntity.ok().body("User was deletted successfully");
    }
}
