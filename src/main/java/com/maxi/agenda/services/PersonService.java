package com.maxi.agenda.services;

import java.util.List;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.PersonDTO;

public interface PersonService {

    public PersonDTO addPerson(PersonDTO person);

    public Person updatePerson(String personalNumber);

    public void deletePersol(Long id);

    public List<Person> findAll();

    public Person findById(Long id);
}
