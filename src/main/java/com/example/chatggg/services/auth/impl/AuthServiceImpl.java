package com.example.chatggg.services.auth.impl;

import com.example.chatggg.enums.Role;
import com.example.chatggg.models.User;
import com.example.chatggg.models.dto.auth.LoginUserDto;
import com.example.chatggg.models.dto.auth.RegistrationNewUserDto;
import com.example.chatggg.repositories.UserRepository;
import com.example.chatggg.services.auth.AuthService;
import com.example.chatggg.services.token.TokenService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    // Registration new user
    @Override
    public User registrationNewUser(RegistrationNewUserDto userDto, HttpServletResponse response) {
        User newUser = User.builder()
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(newUser);

        return newUser;
    }

    // Login
    @Override
    public User login(LoginUserDto userDto, HttpServletResponse response) {
        User userDb = userRepository.findByUsername(userDto.getUsername());

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDto.getUsername(),
                        userDto.getPassword()
                )
        );

        tokenService.addTokenToCookie(userDb, response);

        return userDb;
    }
}
