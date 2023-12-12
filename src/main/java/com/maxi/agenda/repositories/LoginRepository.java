package com.maxi.agenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.domains.Person;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Person> findByUsernameAndPassword(String username, String password);

}
