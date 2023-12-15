package com.maxi.agenda.domains;

import com.maxi.agenda.enums.PersonGender;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
// @Table(name = "person", uniqueConstraints = { @UniqueConstraint(columnNames =
// "email"),
// @UniqueConstraint(columnNames = "personalNumber"),
// @UniqueConstraint(columnNames = "foneNumber") })
@Getter
@Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The name is requiered")
    private String firstname;
    private String lastname;
    private String personalNumber;
    @NotBlank(message = "The email is requiered")
    @Email(message = "The email is not valid")
    private String email;
    private String foneNumber;
    private String image;
    @Enumerated(EnumType.STRING)
    private PersonGender gender;

    public Person() {
        // super();
    }

    public Person(String firstname, String lastname, String personalNumber, String email, String foneNumber,
            PersonGender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.personalNumber = personalNumber;
        this.email = email;
        this.foneNumber = foneNumber;
        this.gender = gender;
    }

    public Person(String firstname, String lastname, String personalNumber, String email, String foneNumber,
            String image, PersonGender gender) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.personalNumber = personalNumber;
        this.email = email;
        this.foneNumber = foneNumber;
        this.image = image;
        this.gender = gender;
    }
}
