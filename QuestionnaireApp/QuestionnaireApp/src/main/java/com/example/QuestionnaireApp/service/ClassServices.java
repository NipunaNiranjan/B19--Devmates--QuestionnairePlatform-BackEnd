package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.model.ClassTable;
import com.example.QuestionnaireApp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServices {

    @Autowired
    ClassRepository classRepository;

    public String saveClass( ClassTable newClass) {
        classRepository.save(newClass);
        return "class created successfully";
    }

    public List<ClassTable> getClasses(){
        return classRepository.findAll();
    }

    public String deleteClass(Long id){
        classRepository.deleteById(id);
        return "class deleted successfully";

    }
}