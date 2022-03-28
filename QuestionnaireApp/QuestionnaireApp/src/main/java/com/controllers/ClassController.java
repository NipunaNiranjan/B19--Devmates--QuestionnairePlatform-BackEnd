package com.controllers;


import com.model.NewClass;
import com.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassController {

    @Autowired
    ClassRepository classRepository;

    @GetMapping( path = "/classes")
    public List<NewClass> getClasses () {
        return classRepository.findAll();
    }

    @PostMapping(path = "/create_class")
    public String saveClass(@RequestBody NewClass newClass){
        classRepository.save(newClass);
        return "class created successfully";
    }

    @DeleteMapping(path = "/deleteClass/{classid}")
    public String deleteClass(@PathVariable Long classid){
        NewClass deleteClass= classRepository.findById(classid).get();
        classRepository.delete(deleteClass);
        return "class deleted successfully";
    }
}

