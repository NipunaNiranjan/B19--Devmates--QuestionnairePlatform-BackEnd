package com.example.QuestionnaireApp.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SAQuestionDTO {
    private Long id;
    private Long questionnaireId;
    private String name;
    private String question;
}
