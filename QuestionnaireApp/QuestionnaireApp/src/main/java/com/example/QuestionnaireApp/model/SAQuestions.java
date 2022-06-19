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
    @Column
    private Integer questionnaireId;
    @Column
    private String name;
    @Column
    private String question;
}