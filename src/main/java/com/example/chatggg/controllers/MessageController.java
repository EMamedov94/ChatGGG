package com.example.chatggg.controllers;

import com.example.chatggg.models.ChatRoom;
import com.example.chatggg.models.User;
import com.example.chatggg.services.message.MessageService;
import com.example.chatggg.services.message.waiting.WaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class MessageController {
    private final MessageService messageService;
    private final WaitingService waitingService;

    @PostMapping("/findChatRoom")
    public ResponseEntity<?> findChatRoom(@AuthenticationPrincipal User currentUser) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(messageService.getOrCreateChatRoom(currentUser));
    }

    @PostMapping("/addToWait")
    public ResponseEntity<?> addToWait(@AuthenticationPrincipal User currentUser) {
        waitingService.addUserToWait(currentUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("waiting");
    }
}
