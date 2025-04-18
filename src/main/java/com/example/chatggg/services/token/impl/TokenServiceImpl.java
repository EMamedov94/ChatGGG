package com.example.chatggg.services.token.impl;

import com.example.chatggg.config.JwtService;
import com.example.chatggg.models.User;
import com.example.chatggg.services.token.TokenService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final JwtService jwtService;

    @Override
    public void addTokenToCookie(User user, HttpServletResponse response) {
        String token = jwtService.generateToken(user);

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        cookie.setPath("/");
        cookie.setMaxAge(7 * 24 * 60 * 60);
        response.addCookie(cookie);

        user.setToken(token);
    }
}
