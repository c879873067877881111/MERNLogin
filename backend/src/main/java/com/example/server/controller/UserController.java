package com.example.server.controller;

import com.example.server.dto.AuthResponse;
import com.example.server.dto.LoginRequest;
import com.example.server.dto.RegisterRequest;
import com.example.server.entity.User;
import com.example.server.service.JwtService;
import com.example.server.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody RegisterRequest request) {
        User user = userService.register(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("person", user));
    }

    @GetMapping("/dashboard")
    public ResponseEntity<Map<String, String>> dashboard(
            @RequestAttribute("userId") String userId,
            @RequestAttribute("userName") String userName) {

        int luckyNumber = new Random().nextInt(100);

        return ResponseEntity.ok(Map.of(
                "msg", "Hello, " + userName,
                "secret", "Here is your authorized data, your lucky number is " + luckyNumber
        ));
    }

    @GetMapping("/users")
    public ResponseEntity<Map<String, List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(Map.of("users", users));
    }
}
