package com.maxi.agenda.dtos;

public class LoginDTO {

    private Long id;

    private String user;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
