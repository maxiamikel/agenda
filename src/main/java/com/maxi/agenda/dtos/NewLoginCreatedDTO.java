package com.maxi.agenda.dtos;

import com.maxi.agenda.enums.PersonRole;

public class NewLoginCreatedDTO {

    private Long id;
    private String user;
    private String firstname;
    private PersonRole role;

    public NewLoginCreatedDTO() {
    }

    public NewLoginCreatedDTO(String user, String firstname, PersonRole role) {
        this.user = user;
        this.firstname = firstname;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

}
