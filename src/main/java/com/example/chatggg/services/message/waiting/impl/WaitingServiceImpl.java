package com.example.chatggg.services.message.waiting.impl;

import com.example.chatggg.enums.UserStatus;
import com.example.chatggg.models.User;
import com.example.chatggg.models.WaitingUser;
import com.example.chatggg.repositories.WaitingUserRepository;
import com.example.chatggg.services.message.waiting.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WaitingServiceImpl implements WaitingService {
    private final WaitingUserRepository waitingUserRepository;

    @Override
    public void addUserToWait(User currentUser) {
        WaitingUser user = WaitingUser.builder()
                .user(currentUser)
                .status(UserStatus.WAITING)
                .timestamp(LocalDateTime.now())
                .build();
        waitingUserRepository.save(user);
    }
}
