package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.SignupRequest;
import com.example.QuestionnaireApp.dto.UserDTO;

public interface UserService {
    void signUp(SignupRequest signupRequest);
    String deactivateUserStatus(Long id);
    String activateUserStatus(long id);
    UserDTO getUsers(Long id);
}
