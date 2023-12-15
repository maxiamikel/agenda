package com.maxi.agenda.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.agenda.domains.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    // @Query("SELECT p FROM Login p WHERE p.username =:username and p.password
    // =:password")
    public Login findByUserAndPassword(String user, String password);

    Optional<Login> findByUser(String user);

}
