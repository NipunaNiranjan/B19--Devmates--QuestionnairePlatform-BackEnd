package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.UserDTO;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.UserRepo;
import com.example.QuestionnaireApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/getUserByUserName/{name}")
    public ResponseEntity<List<User>> getUserByUserName(@PathVariable String stu_username) {
        return new ResponseEntity<List<User>>(userRepo.getUserByUserName(stu_username), HttpStatus.OK);
    }


}
