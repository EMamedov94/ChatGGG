package com.example.chatggg.controllers;

import com.example.chatggg.models.User;
import com.example.chatggg.models.dto.auth.LoginUserDto;
import com.example.chatggg.models.dto.auth.RegistrationNewUserDto;
import com.example.chatggg.services.auth.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/registrationNewUser")
    public ResponseEntity<User> registerUser(@RequestBody RegistrationNewUserDto userDto,
                                             HttpServletResponse response) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.registrationNewUser(userDto, response));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginUserDto userDto,
                                      HttpServletResponse response) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authService.login(userDto, response));
    }
}
