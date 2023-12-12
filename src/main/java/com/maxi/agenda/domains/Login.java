package com.maxi.agenda.domains;

import com.maxi.agenda.enums.PersonRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @NoArgsConstructor
// @AllArgsConstructor
@Table(name = "login", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;

    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    public Login() {
        // super();
    }

    public Login(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.role = PersonRole.GUEST;
    }
}
