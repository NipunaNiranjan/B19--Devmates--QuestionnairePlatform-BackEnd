package com.example.QuestionnaireApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class MCQQuestion {
        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY)
        private Long id;
        private String question;
        private String option1;
        private String option2;
        private String option3;
        private String option4;
        private int  correctAnswer;
        private int questionnaireID;

        @OneToMany(
                targetEntity = Submission.class,
                fetch = FetchType.LAZY,
                mappedBy = "mcqQuestion"
        )
        private List<Submission> submissions;

        public MCQQuestion(Long id) {
                this.id = id;
        }
}
