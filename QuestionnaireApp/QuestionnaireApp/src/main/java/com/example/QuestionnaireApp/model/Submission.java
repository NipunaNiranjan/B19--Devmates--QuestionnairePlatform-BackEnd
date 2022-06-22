package com.example.QuestionnaireApp.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortAnswer;
    private int mcqOption;

    @ManyToOne(
            targetEntity = User.class,
            optional = false
    )
    @JoinColumn(name = "student")
    private User student;

    @ManyToOne(
            targetEntity = Questionnaire.class,
            optional = false
    )
    @JoinColumn(name = "questionnaire")
    private Questionnaire questionnaire;

    @ManyToOne(
            targetEntity = MCQQuestion.class
    )
    @JoinColumn(name = "mcqQuestion")
    private MCQQuestion mcqQuestion;

    @ManyToOne(
            targetEntity = SAQuestion.class
    )
    @JoinColumn(name = "saQuestion")
    private SAQuestion saQuestion;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS Z")
    private Date date;
}
