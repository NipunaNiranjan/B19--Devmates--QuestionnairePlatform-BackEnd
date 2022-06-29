package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.SignupRequest;
import com.example.QuestionnaireApp.dto.UpdateUserRequest;
import com.example.QuestionnaireApp.dto.UserDTO;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.model.views.UserView;

import java.util.List;

public interface UserService {
    void signUp(SignupRequest signupRequest);
    String deactivateUserStatus(Long id);
    String activateUserStatus(long id);
    UserDTO getUsers(Long id);
    List<UserView> getAllUsers();
    void editUser(UpdateUserRequest updateUserRequest);
}
