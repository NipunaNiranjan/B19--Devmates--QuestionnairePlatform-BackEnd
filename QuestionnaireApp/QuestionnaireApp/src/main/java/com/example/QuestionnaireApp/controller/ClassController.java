package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.Class;
import com.example.QuestionnaireApp.repository.ClassRepo;
import com.example.QuestionnaireApp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class ClassController {

    @Autowired
    private ClassRepo userRepo;

    @Autowired
    private ClassService userService;

    @GetMapping("/getUserByUserName/{name}")
    public ResponseEntity<List<Class>> getUserByUserName(@PathVariable String stu_username) {
        return new ResponseEntity<List<Class>>(userRepo.getUserByUserName(stu_username), HttpStatus.OK);
    }


}
