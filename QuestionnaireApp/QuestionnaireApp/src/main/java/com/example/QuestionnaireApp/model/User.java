package com.example.QuestionnaireApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    private boolean status;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    public User(long id) {
        this.id = id;
    }

    public User(String username, String password, String email, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.status= true;
    }

    @ManyToOne(
            targetEntity = Role.class,
            optional = false
    )
    private Role role;

    @OneToMany(
            mappedBy = "student",
            fetch = FetchType.LAZY
    )
    private List<IClassStudent> students;

    @OneToMany(
            mappedBy = "student",
            targetEntity = Submission.class,
            fetch = FetchType.LAZY
    )
    private List<Submission> submissions;
}
