package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.ClassDTO;
import com.example.QuestionnaireApp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassService {
    @Autowired
    private ClassRepository classRepository;

   public String saveClass(ClassDTO classDTO){
   classRepository.save(classDTO);
   }

}