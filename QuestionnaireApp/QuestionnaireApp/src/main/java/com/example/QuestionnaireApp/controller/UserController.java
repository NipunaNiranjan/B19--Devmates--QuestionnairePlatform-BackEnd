package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.UserRepository;
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

    @GetMapping("/getUsers")
    public List<User> getUser () {
        return userRepository.findAll();
    }
}
