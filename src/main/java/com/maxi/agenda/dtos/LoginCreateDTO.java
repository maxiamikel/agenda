package com.maxi.agenda.dtos;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.domains.Person;

public class LoginCreateDTO {

    private Long id;

    private Person person;

    private String username;
    private String password;

    public LoginCreateDTO() {
    }

    public LoginCreateDTO(Login login) {
        this.person = login.getPerson();
        this.username = login.getUsername();
        this.password = login.getPassword();
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
