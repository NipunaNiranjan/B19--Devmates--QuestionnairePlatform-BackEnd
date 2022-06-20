package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.ClassTable;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.ClassRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class JoinClassController {

    @Autowired
    UserRepository  userRepository;

    @Autowired
    ClassRepository classRepository;

    @GetMapping("/addStudent")
    public String addStudentToClass(){

        User user= userRepository.findById(Long.valueOf(3)).get();
        ClassTable classTable= classRepository.findById(Long.valueOf(1)).get();

        //add reference to user
        user.getClassTables().add(classTable);

        //add reference to table
        classTable.getUsers().add(user);

        this.userRepository.save(user);

        return "succesfull";

    }
}
