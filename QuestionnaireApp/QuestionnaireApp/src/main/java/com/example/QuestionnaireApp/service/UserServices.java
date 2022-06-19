package com.example.QuestionnaireApp.service;

import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public String deactivateUserStatus(Long id) {
        User updateUser = userRepository.findById(id).get();

        if(updateUser.isStatus()== true) {
            updateUser.setStatus(false);
            userRepository.save(updateUser);
            return "successfully deactivated";
        }
        else {
            return "Already deactivated the user account = "+ updateUser.getUsername();
        }

    }

    public String activateUserStatus(long id) {
        User updateUser = userRepository.findById(id).get();

        if(updateUser.isStatus()== false) {
            updateUser.setStatus(true);
            userRepository.save(updateUser);
            return "successfully activated";
        }
        else {
            return "Already activated the user account = "+ updateUser.getUsername();
        }
    }
}
