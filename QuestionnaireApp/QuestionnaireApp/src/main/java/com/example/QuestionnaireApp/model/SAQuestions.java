package com.example.QuestionnaireApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "SAQuestions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SAQuestions {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer questionnaireId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String question;

//    @ManyToOne(
//            targetEntity = Questionnaire.class,
//            optional = false
//    )
//    private Questionnaire questionnaire;
}