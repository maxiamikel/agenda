package com.maxi.agenda.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.LoginCreateDTO;
import com.maxi.agenda.dtos.LoginDTO;
import com.maxi.agenda.dtos.NewLoginCreatedDTO;
import com.maxi.agenda.dtos.PersolLoggedDTO;
import com.maxi.agenda.enums.PersonRole;
import com.maxi.agenda.repositories.LoginRepository;
import com.maxi.agenda.repositories.PersonRepository;
import com.maxi.agenda.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoginServiceImplementation implements LoginService {

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private LoginRepository repo;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public NewLoginCreatedDTO createLogin(LoginCreateDTO obj) {

        Optional<Login> objPerson = repo.findByUsername(obj.getUsername());

        Person person = personRepository.findById(obj.getId()).get();

        if (!objPerson.isPresent() && obj.getId() == person.getId()) {
            Login personLogin = new Login();
            personLogin.setUsername(obj.getUsername());
            personLogin.setPassword(passwordEncoder().encode(obj.getPassword()));
            personLogin.setRole(PersonRole.GUEST);
            personLogin.setPerson(person);

            personLogin = repo.save(personLogin);

            NewLoginCreatedDTO login = new NewLoginCreatedDTO(personLogin.getUsername(), person.getFirstname(),
                    personLogin.getRole());
            return login;
        } else if (!objPerson.isPresent()) {
            throw new NoSuchElementException(
                    "We cannot create your user login because we cannot find you person ID [" + obj.getId() + "]");
        } else {
            throw new RuntimeException(
                    "We cannot create your user login because we detected that some data are duplicated!");
        }

    }

    @Override
    public PersolLoggedDTO login(LoginDTO obj) {
        return null;
    }

}
