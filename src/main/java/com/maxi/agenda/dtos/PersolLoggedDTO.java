package com.maxi.agenda.dtos;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.domains.Person;
import com.maxi.agenda.enums.PersonRole;

public class PersolLoggedDTO {

    private String pno;
    private String username;
    private String email;
    private PersonRole role;

    public PersolLoggedDTO() {
    }

    public PersolLoggedDTO(Login login, Person obj) {
        this.pno = obj.getPersonalNumber();
        this.username = login.getUser();
        this.email = obj.getEmail();
        this.role = login.getRole();
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public String getPno() {
        return pno;
    }

    public void setPno(String pno) {
        this.pno = pno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
