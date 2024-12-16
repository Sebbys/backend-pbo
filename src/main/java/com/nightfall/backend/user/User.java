package com.nightfall.backend.user;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nightfall.backend.person.Person;

@Entity
@Table(name = "app_user")
@JsonIgnoreProperties({"person"})
public class User {
    @Id
    private String userId;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
