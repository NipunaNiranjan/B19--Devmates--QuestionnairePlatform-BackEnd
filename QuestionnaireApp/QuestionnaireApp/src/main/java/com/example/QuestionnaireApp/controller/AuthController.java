package com.example.QuestionnaireApp.controller;

import com.example.QuestionnaireApp.dto.ResponseDTO;
import com.example.QuestionnaireApp.dto.JwtResponse;
import com.example.QuestionnaireApp.dto.LoginRequest;
import com.example.QuestionnaireApp.dto.SignupRequest;
import com.example.QuestionnaireApp.security.jwt.JwtUtils;
import com.example.QuestionnaireApp.security.services.UserDetailsImpl;
import com.example.QuestionnaireApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;

    private final JwtUtils jwtUtils;

    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        userService.signUp(signUpRequest);
        ResponseDTO<?> responseDTO = ResponseDTO.builder()
                .statusCode(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED.toString())
                .body("Your account has been created successfully!").build();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
