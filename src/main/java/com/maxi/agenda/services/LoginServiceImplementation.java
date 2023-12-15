package com.maxi.agenda.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.domains.Person;
import com.maxi.agenda.dtos.LoginCreateDTO;
import com.maxi.agenda.dtos.NewLoginCreatedDTO;
import com.maxi.agenda.enums.PersonRole;
import com.maxi.agenda.repositories.LoginRepository;
import com.maxi.agenda.repositories.PersonRepository;

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
    public Login login(String user, String password) {
        Login userLog = repo.findByUserAndPassword(user, password);
        return userLog;
    }

    @Override
    public NewLoginCreatedDTO createLogin(LoginCreateDTO obj) {
        Optional<Login> objPerson = repo.findByUser(obj.getUser());

        Person person = personRepository.findById(obj.getId()).get();

        if (!objPerson.isPresent() && obj.getId() == person.getId()) {
            Login personLogin = new Login();
            personLogin.setUser(obj.getUser());
            personLogin.setPassword(passwordEncoder().encode(obj.getPassword()));
            personLogin.setRole(PersonRole.GUEST);
            personLogin.setPerson(person);

            personLogin = repo.save(personLogin);

            NewLoginCreatedDTO login = new NewLoginCreatedDTO(personLogin.getUser(), person.getFirstname(),
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

}
