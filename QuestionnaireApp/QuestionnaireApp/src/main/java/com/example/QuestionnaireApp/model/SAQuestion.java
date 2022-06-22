package com.example.QuestionnaireApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class SAQuestion {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long questionnaireId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String question;

    @OneToMany(
            targetEntity = Submission.class,
            fetch = FetchType.LAZY,
            mappedBy = "saQuestion"
    )
    private List<Submission> submissions;

    public SAQuestion(Long id) {
        this.id = id;
    }
}