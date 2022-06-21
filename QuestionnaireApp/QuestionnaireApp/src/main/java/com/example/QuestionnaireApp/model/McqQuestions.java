package com.example.QuestionnaireApp.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name= "McqQuestions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class McqQuestions {

        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column
        private String question;
        @Column
        private String option1;
        @Column
        private String option2;
        @Column
        private String option3;
        @Column
        private String option4;
        @Column
        private int  correctAnswer;
        @Column
        private int questionnaireID;


}
