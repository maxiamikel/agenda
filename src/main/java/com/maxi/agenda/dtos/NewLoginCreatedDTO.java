package com.maxi.agenda.dtos;

import com.maxi.agenda.enums.PersonRole;

public class NewLoginCreatedDTO {

    private Long id;
    private String username;
    private String firstname;
    private PersonRole role;

    public NewLoginCreatedDTO() {
    }

    public NewLoginCreatedDTO(String username, String firstname, PersonRole role) {
        this.username = username;
        this.firstname = firstname;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
