package com.devmates.auth.dto;

import com.devmates.auth.annotation.StrongPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequest {

    private Long id;

    @NotBlank(message = "{NotEmpty.username}")
    @Size(min = 6, max = 20, message = "{Size.username}")
    private String username;
    
    @NotBlank(message = "{NotEmpty.password}")
    @StrongPassword(message = "{Strong.password}")
    private String password;

    @NotBlank(message = "{NotEmpty.role}")
    private String role;






    public SignupRequest(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;


    }
}
