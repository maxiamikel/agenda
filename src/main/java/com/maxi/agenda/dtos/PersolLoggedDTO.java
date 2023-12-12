package com.maxi.agenda.dtos;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.enums.PersonRole;

public class PersolLoggedDTO {

    private Long id;
    private String status;
    private PersonRole role;

    public PersolLoggedDTO() {
    }

    public PersolLoggedDTO(Login login) {
        this.status = "Disconnect!";
        this.role = login.getRole();
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

}
