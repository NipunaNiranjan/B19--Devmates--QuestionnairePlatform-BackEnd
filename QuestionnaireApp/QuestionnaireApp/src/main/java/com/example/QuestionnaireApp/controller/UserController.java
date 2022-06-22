package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.model.views.UserView;
import com.example.QuestionnaireApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers(@PathVariable("id") Long id) {
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .status(HttpStatus.OK.toString())
                .body(userService.getUsers(id))
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @PutMapping( "/deactivate/{id}" )
    public String deactivateUser(@PathVariable Long id){
         return userService.deactivateUserStatus(id);
    }

    @PutMapping("/admin/active/{id}")
    public String activateUser(@PathVariable long id){
         return userService.activateUserStatus(id);
    }

    @GetMapping("/allUsers")
    public List<UserView> getAllUsers (){
        return userService.getAllUsers();
    }
}
