package com.example.QuestionnaireApp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class IClassStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(
            targetEntity = Class.class,
            optional = false
    )
    @JoinColumn(name = "aClass")
    private Class aClass;

    @ManyToOne(
            targetEntity = User.class,
            optional = false
    )
    @JoinColumn(name = "student")
    private User student;

    public IClassStudent(Class aClass, User student) {
        this.aClass = aClass;
        this.student = student;
    }
}
