package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.JoinClassRequest;
import com.example.QuestionnaireApp.service.JoinClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class JoinClassController {

    @Autowired
    JoinClassService joinClassService;

    public JoinClassController(JoinClassService joinClassService) {
        this.joinClassService = joinClassService;
    }

    @PostMapping("/addStudent")
    public String addStudentToClass(@RequestBody JoinClassRequest joinClassRequest){
        return joinClassService.AddStudentToClass(joinClassRequest.getC_id(),joinClassRequest.getC_id());
    }
}
