package com.example.chatggg.services.message;

import com.example.chatggg.models.Message;
import com.example.chatggg.models.dto.message.MessageDto;

public interface MessageService {
    Message sendMessage(MessageDto messageDto);
}
