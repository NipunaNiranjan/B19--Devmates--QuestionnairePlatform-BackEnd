package com.example.QuestionnaireApp.dto;

import lombok.Builder;

@Builder
public class UserDTO {
    private String username;
    private boolean status;
    private String email;
    private String phone;
}
