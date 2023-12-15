package com.maxi.agenda.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.PersonDTO;
import com.maxi.agenda.dtos.PersonUpdateDTO;
import com.maxi.agenda.repositories.PersonRepository;
import com.maxi.agenda.services.exceptions.NoSuchElementException;
import com.maxi.agenda.services.exceptions.ObjectClassDuplicateException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonServiceImplementation implements PersonService {

    @Autowired
    private PersonRepository repo;

    @Override
    public PersonDTO addPerson(PersonDTO person) {
        Optional<Person> personEmail = repo.findByEmail(person.getEmail());
        Optional<Person> personPno = repo.findByPersonalNumber(person.getPersonalNumber());
        Optional<Person> personFone = repo.findByFoneNumber(person.getFoneNumber());

        if (personEmail.isPresent()) {
            throw new ObjectClassDuplicateException("Error!! Use another email to complete this work");
        }

        if (personPno.isPresent()) {
            throw new ObjectClassDuplicateException("Error!! Use another ID number to complete this work");
        }

        if (personFone.isPresent()) {
            throw new ObjectClassDuplicateException("Error!! Use another Fone number to complete this work");
        }
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
    public void deletePerson(Long id) {

        Optional<Person> person = repo.findById(id);
        if (!person.isPresent()) {
            throw new RuntimeException("The informated ID is not found");
        }
        repo.deleteById(id);
    }

    @Override
    public List<PersonDTO> findAll() {
        List<Person> list = repo.findAll();
        if (list.size() != 0) {
            List<PersonDTO> listDTO = list.stream().map(x -> new PersonDTO(x)).collect(Collectors.toList());
            return listDTO;
        } else {
            throw new ObjectClassDuplicateException("No content in this container");
        }
    }

    @Override
    public PersonDTO findById(Long id) {
        Optional<Person> person = repo.findById(id);
        if (person.isPresent()) {
            Person person2 = person.get();
            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(id);
            personDTO.setFirstname(person2.getFirstname());
            personDTO.setLastname(person2.getLastname());
            personDTO.setPersonalNumber(person2.getPersonalNumber());
            personDTO.setEmail(person2.getEmail());
            personDTO.setGender(person2.getGender());
            personDTO.setImage(person2.getImage());
            return personDTO;
        } else {
            throw new NoSuchElementException("Regist ID not found");
        }
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonUpdateDTO obj) {

        Person person = repo.findById(obj.getId()).get();
        if (person != null && person.getPersonalNumber().equals(obj.getPersonalNumber())) {
            person.setFirstname(obj.getFirstname());
            person.setLastname(obj.getLastname());
            person.setEmail(person.getEmail());
            person.setPersonalNumber(person.getPersonalNumber());
            person.setFoneNumber(person.getFoneNumber());
            person.setImage(obj.getImage());
            repo.save(person);

            PersonDTO pDTO = new PersonDTO(person);
            return pDTO;
        } else {
            throw new RuntimeException("The Personal ID is incorrect");
        }
    }

    @Override
    public PersonDTO findByPersonalNumberb(Long id) {
        return null;
    }

    @Override
    public PersonDTO findBy(String foneNumber) {
        return null;
    }

    @Override
    public Person findPersonEmail(String email) {

        return null;
    }

}
