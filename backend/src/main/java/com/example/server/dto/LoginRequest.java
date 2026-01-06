package com.example.server.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Please provide email")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotBlank(message = "Please provide password")
    private String password;
}
