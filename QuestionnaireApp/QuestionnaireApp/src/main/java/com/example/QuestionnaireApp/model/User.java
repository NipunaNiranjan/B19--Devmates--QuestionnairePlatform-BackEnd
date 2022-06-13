package com.example.QuestionnaireApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    private boolean status;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.status= true;
    }

    public User(long id) {
        this.id = id;
    }

    @ManyToOne(
            targetEntity = Role.class,
            optional = false
    )
    private Role role;
}
