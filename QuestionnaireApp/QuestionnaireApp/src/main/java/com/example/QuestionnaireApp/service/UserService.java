package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.dto.UserDTO;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO getUserByUserName(String stu_username){
        List<User> user = userRepo.getUserByUserName(stu_username);
        return modelMapper.map(user, UserDTO.class);
    }


}
