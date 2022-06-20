package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.model.ClassTable;
import com.example.QuestionnaireApp.service.ClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ClassController {

    @Autowired
    ClassServices classServices;

    @PostMapping("/createClass")
    public String saveClass(@RequestBody ClassTable newClass){
        return classServices.saveClass(newClass);

    }

    @GetMapping("/viewClasses")
    public List<ClassTable> getClasses(){
        return classServices.getClasses();
    }

    @DeleteMapping("/admin/deleteClass/{id}")
    public String deleteClass(@PathVariable Long id){
        return classServices.deleteClass(id);

    }

}
