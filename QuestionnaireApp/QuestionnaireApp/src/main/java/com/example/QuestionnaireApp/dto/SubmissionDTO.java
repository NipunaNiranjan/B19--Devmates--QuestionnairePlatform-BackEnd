package com.example.QuestionnaireApp.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubmissionDTO {
    private Long studentId;
    private Long questionnaireId;
    private String type;
    private List<MCQAnswerDTO> mcqAnswers;
    private List<ShortAnswerDTO> shortAnswers;
}
