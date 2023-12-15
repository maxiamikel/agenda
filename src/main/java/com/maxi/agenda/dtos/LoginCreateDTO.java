package com.maxi.agenda.dtos;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.domains.Person;

public class LoginCreateDTO {

    private Long id;

    private Person person;

    private String user;
    private String password;

    public LoginCreateDTO() {
    }

    public LoginCreateDTO(Login login) {
        this.person = login.getPerson();
        this.user = login.getUser();
        this.password = login.getPassword();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
