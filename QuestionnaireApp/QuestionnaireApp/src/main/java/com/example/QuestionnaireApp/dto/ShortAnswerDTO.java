package com.example.QuestionnaireApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ShortAnswerDTO {
    private Long questionId;
    private String answer;
}
