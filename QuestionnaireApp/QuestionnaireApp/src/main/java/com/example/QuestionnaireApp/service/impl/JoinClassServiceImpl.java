package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.model.ClassTable;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.ClassRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.service.JoinClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JoinClassServiceImpl implements JoinClassService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClassRepository classRepository;

    @Override
    public String AddStudentToClass(long s_id, long c_id) {
        try {

            User user= userRepository.findById(s_id).get();
            ClassTable classTable= classRepository.findById(c_id).get();

            //add reference to user
            user.getClassTables().add(classTable);

            //add reference to table
            classTable.getUsers().add(user);

            this.userRepository.save(user);

            return "successful";
        }catch (Exception e){
            return "unsuccessful";
        }
    }
}
