package com.example.QuestionnaireApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Questionnaire {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String type;

    @ManyToOne(
            targetEntity = Class.class,
            optional = false
    )
    @JoinColumn(name = "aClass")
    private Class aClass;

    @OneToMany(
            targetEntity = Submission.class,
            fetch = FetchType.LAZY,
            mappedBy = "questionnaire"
    )
    private List<Submission> submissions;

    public Questionnaire(Long id) {
        this.id = id;
    }
}