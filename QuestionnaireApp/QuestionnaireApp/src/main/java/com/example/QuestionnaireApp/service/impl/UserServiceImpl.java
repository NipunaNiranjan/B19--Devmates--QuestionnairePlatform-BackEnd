package com.example.QuestionnaireApp.service.impl;

import com.example.QuestionnaireApp.dto.SignupRequest;
import com.example.QuestionnaireApp.exception.BadRequestException;
import com.example.QuestionnaireApp.model.ERole;
import com.example.QuestionnaireApp.model.Role;
import com.example.QuestionnaireApp.model.User;
import com.example.QuestionnaireApp.repository.RoleRepository;
import com.example.QuestionnaireApp.repository.UserRepository;
import com.example.QuestionnaireApp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
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
}
