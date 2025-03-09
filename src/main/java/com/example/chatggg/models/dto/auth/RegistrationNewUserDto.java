package com.example.chatggg.models.dto.auth;

import com.example.chatggg.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class RegistrationNewUserDto {

    private String username;
    private String password;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String token;
}
