package com.example.QuestionnaireApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MCQAnswerDTO {
    private Long questionId;
    private int option;
}
