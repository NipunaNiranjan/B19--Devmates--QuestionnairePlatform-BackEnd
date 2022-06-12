package com.devmates.auth.model;

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

    @Column(unique = true, nullable = false)
    private String email;

    private String phone;




    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    @ManyToOne(
            targetEntity = Role.class,
            optional = false
    )
    private Role role;
}
