package com.example.QuestionnaireApp.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ViewActivity {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(
            targetEntity = Class.class,
            optional = false
    )
    private Class classID;

    @OneToOne(
            targetEntity = Questionnaire.class,
            optional = false
    )
    private Questionnaire questionnaireID;
}
