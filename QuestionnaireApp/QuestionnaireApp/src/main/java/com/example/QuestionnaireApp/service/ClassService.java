package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.ClassDTO;
import com.example.QuestionnaireApp.model.Class;
import com.example.QuestionnaireApp.repository.ClassRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class ClassService {

    @Autowired
    private ClassRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ClassDTO getUserByUserName(String stu_username){
        List<Class> user = userRepo.getUserByUserName(stu_username);
        return modelMapper.map(user, ClassDTO.class);
    }


}
