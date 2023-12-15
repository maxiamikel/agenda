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

@Entity
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
@Table(name = "login", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Person person;
    // private Long personId;
    private String user;
    private String password;
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    public Login() {
        // super();
    }

    public Login(String user, String password, Person person) {
        this.user = user;
        this.password = password;
        this.person = person;
        this.role = PersonRole.GUEST;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
