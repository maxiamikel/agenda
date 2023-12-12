package com.maxi.agenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.agenda.domains.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    Optional<Person> findByPersonalNumber(String personalNumber);

    Optional<Person> findByFoneNumber(String foneNumber);

}
