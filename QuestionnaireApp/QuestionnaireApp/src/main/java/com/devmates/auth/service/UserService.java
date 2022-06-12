package com.devmates.auth.service;

import com.devmates.auth.dto.SignupRequest;

public interface UserService {
    void signUp(SignupRequest signupRequest);
}
