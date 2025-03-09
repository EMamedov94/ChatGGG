package com.example.chatggg.services.token;

import com.example.chatggg.models.User;
import jakarta.servlet.http.HttpServletResponse;

public interface TokenService {
    void addTokenToCookie(User user, HttpServletResponse response);
}
