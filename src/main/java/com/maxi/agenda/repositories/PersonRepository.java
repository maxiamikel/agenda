package com.maxi.agenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.agenda.domains.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);

    Optional<Person> findByPersonalNumber(String personalNumber);

    Optional<Person> findByFoneNumber(String foneNumber);

    @Query("SELECT p FROM Person p WHERE p.email =:email")
    Optional<Person> findPersonEmail(@Param("email") String email);

}
