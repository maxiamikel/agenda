package com.maxi.agenda.dtos;

import com.maxi.agenda.domains.Person;
import com.maxi.agenda.enums.PersonGender;

import jakarta.validation.constraints.Email;

public class PersonDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private String personalNumber;
    @Email(message = "The email is not valid")
    private String email;
    private String foneNumber;
    private String image;
    private PersonGender gender;

    public PersonDTO() {
        // super();
    }

    public PersonDTO(Person person) {
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
        this.personalNumber = person.getPersonalNumber();
        this.email = person.getEmail();
        this.foneNumber = person.getFoneNumber();
        this.image = person.getImage();
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

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public PersonGender getGender() {
        return gender;
    }

    public void setGender(PersonGender gender) {
        this.gender = gender;
    }

}
