package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.model.views.UserViews;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.repository.UserViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserViewRepository userViewRepository;

    @GetMapping("/getUsers")
    public List<User> getUser () {
        return userRepository.findAll();
    }

    @GetMapping("/admin/view_users")
    public List<UserViews> getUsers () {
        return userViewRepository.findAll();
    }
}
