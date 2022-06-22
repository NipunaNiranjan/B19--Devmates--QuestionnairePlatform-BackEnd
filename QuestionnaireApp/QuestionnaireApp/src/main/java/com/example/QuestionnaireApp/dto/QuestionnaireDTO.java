package com.example.QuestionnaireApp.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionnaireDTO {
    private Long id;
    private String name;
    private String description;
    private String type;
}
