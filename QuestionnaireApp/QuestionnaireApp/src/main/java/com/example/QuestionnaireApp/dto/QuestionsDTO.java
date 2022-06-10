package com.example.QuestionnaireApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "QuestionsDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionsDTO {
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