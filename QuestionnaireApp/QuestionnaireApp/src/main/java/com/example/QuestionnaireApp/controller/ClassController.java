package com.example.QuestionnaireApp.controller;


import com.example.QuestionnaireApp.dto.ClassDTO;
import com.example.QuestionnaireApp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin

public class ClassController {
     @Autowired
     private ClassService classService;


    @PostMapping("/saveClass")
    public ClassDTO saveClass(@RequestBody ClassDTO classDTO) {
       return classService.saveClass(classDTO);
    }


}
