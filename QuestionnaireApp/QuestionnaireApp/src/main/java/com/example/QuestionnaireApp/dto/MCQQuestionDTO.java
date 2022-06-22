package com.example.QuestionnaireApp.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MCQQuestionDTO {
    private Long id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private int  correctAnswer;
    private int questionnaireID;
}
