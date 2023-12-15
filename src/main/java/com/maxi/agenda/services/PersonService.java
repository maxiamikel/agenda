package com.maxi.agenda.services;

import java.util.List;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.PersonDTO;
import com.maxi.agenda.dtos.PersonUpdateDTO;

public interface PersonService {

    public PersonDTO addPerson(PersonDTO person);

    public PersonDTO updatePerson(Long id, PersonUpdateDTO person);

    public void deletePerson(Long id);

    public List<PersonDTO> findAll();

    public PersonDTO findById(Long id);

    public PersonDTO findByPersonalNumberb(Long id);

    public PersonDTO findBy(String foneNumber);

    public Person findPersonEmail(String email);
}
