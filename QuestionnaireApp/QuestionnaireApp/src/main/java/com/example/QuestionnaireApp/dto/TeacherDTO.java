package com.example.QuestionnaireApp.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeacherDTO {
    private long id;
    private String email;
    private String phone;
}
