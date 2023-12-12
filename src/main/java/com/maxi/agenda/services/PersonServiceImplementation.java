package com.maxi.agenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.PersonDTO;
import com.maxi.agenda.repositories.PersonRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImplementation implements PersonService {

    @Autowired
    private PersonRepository repo;

    @Override
    public PersonDTO addPerson(PersonDTO person) {
        Person newPerson = new Person();
        newPerson.setId(null);
        newPerson.setFirstname(person.getFirstname());
        newPerson.setLastname(person.getLastname());
        newPerson.setEmail(person.getEmail());
        newPerson.setFoneNumber(person.getFoneNumber());
        newPerson.setPersonalNumber(person.getPersonalNumber());
        newPerson.setGender(person.getGender());
        newPerson.setImage(person.getImage());

        newPerson = repo.save(newPerson);

        PersonDTO obj = new PersonDTO(newPerson);
        return obj;
    }

    @Override
    public Person updatePerson(String personalNumber) {
        return new Person();
    }

    @Override
    public void deletePersol(Long id) {

    }

    @Override
    public List<Person> findAll() {
        return null;
    }

    @Override
    public Person findById(Long id) {
        return new Person();
    }

}
