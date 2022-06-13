package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.model.views.UserViews;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.repository.UserViewRepository;
import com.example.QuestionnaireApp.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserViewRepository userViewRepository;

    @Autowired
    private UserServices userServices;

    @GetMapping("/getUsers")
    public List<User> getUser () {
        return userRepository.findAll();
    }

    @GetMapping("/admin/view_users")
    public List<UserViews> getUsers () {
        return userViewRepository.findAll();
    }

    @PutMapping ( "/admin/deactivate/{id}" )
    public String deactivateUser(@PathVariable Long id){

         return userServices.deactivateUserStatus(id);

    }

    @PutMapping("/admin/activate_user/{id}")
    public  String activateUser(@PathVariable long id){
         return userServices.activateUserStatus(id);
    }


}
