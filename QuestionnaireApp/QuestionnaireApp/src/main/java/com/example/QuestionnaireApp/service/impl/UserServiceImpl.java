package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.SignupRequest;
import com.example.QuestionnaireApp.dto.UserDTO;
import com.example.QuestionnaireApp.exception.BadRequestException;
import com.example.QuestionnaireApp.model.ERole;
import com.example.QuestionnaireApp.model.Role;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.model.views.UserView;
import com.example.QuestionnaireApp.repository.RoleRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.repository.UserViewRepository;
import com.example.QuestionnaireApp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserViewRepository userViewRepository;

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository, UserViewRepository userViewRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userViewRepository = userViewRepository;
    }

    @Override
    public void signUp(SignupRequest signupRequest) {
        Optional<User> userOptionalByUsername = userRepository.findUserByUsername(signupRequest.getUsername());
        if(userOptionalByUsername.isPresent()) throw new BadRequestException("The given username already exists!");
        Optional<User> userOptionalByEmail = userRepository.findUserByEmail(signupRequest.getEmail());
        if(userOptionalByEmail.isPresent()) throw new BadRequestException("The given Email already exists!");
        User user = new User(signupRequest.getUsername(), passwordEncoder.encode(signupRequest.getPassword()),
                signupRequest.getEmail(), signupRequest.getPhone());
        ERole role;
        try {
            role = ERole.valueOf(signupRequest.getRole());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("The given user role is not exists.");
        }
        Role userRole = roleRepository.findByRole(role)
                .orElseThrow(() -> new BadRequestException("The given user role is not exists."));
        user.setRole(userRole);
        userRepository.save(user);
    }

    @Override
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

    @Override
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

    @Override
    public UserDTO getUsers(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty())
            throw new BadRequestException("No any user found for given user id!");
        User user = userOptional.get();
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .status(user.isStatus())
                .phone(user.getPhone())
                .build();
    }

    @Override
    public List<UserView> getAllUsers () {
        return userViewRepository.findAll();
    }
}
