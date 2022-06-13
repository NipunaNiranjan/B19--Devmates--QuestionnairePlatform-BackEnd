package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.ClassDTO;
import com.example.QuestionnaireApp.repository.ClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private ModelMapper modelMapper;

   public ClassDTO saveClass(ClassDTO classDTO)
   {
   classRepository.save(modelMapper.map(classDTO, Class.class));
      return classDTO;
   }

}
