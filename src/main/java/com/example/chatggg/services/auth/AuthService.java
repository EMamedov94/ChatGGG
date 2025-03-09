package com.example.chatggg.services.auth;

import com.example.chatggg.models.User;
import com.example.chatggg.models.dto.auth.LoginUserDto;
import com.example.chatggg.models.dto.auth.RegistrationNewUserDto;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    User registrationNewUser(RegistrationNewUserDto userDto, HttpServletResponse response);
    User login(LoginUserDto userDto, HttpServletResponse response);
}
