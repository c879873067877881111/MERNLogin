package com.example.server.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Please provide username")
    @Size(min = 3, max = 50, message = "Username must be between 3-50 characters")
    private String username;

    @NotBlank(message = "Please provide email")
    @Email(message = "Please provide a valid email")
    private String email;

    @NotBlank(message = "Please provide password")
    @Size(min = 3, message = "Password must be at least 3 characters")
    private String password;
}
