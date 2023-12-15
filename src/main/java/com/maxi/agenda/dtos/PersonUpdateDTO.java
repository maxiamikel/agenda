package com.maxi.agenda.dtos;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.enums.PersonGender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class PersonUpdateDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String foneNumber;
    private String personalNumber;
    private String image;
    private String email;
    @Enumerated(EnumType.STRING)
    private PersonGender gender;

    public PersonUpdateDTO() {
    }

    public PersonUpdateDTO(Person person) {
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
        this.foneNumber = person.getFoneNumber();
        this.personalNumber = person.getPersonalNumber();
        this.image = person.getImage();
        this.email = person.getEmail();
        this.gender = person.getGender();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonGender getGender() {
        return gender;
    }

    public void setGender(PersonGender gender) {
        this.gender = gender;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFoneNumber() {
        return foneNumber;
    }

    public void setFoneNumber(String foneNumber) {
        this.foneNumber = foneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
