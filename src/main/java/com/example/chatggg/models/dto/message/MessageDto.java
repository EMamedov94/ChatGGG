package com.example.chatggg.models.dto.message;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageDto {
    private String message;
    private Long senderId;
    private Long receiverId;
    private Long chatRoomId;
    private LocalDateTime timestamp;
}
