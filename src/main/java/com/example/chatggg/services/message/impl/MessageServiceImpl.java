package com.example.chatggg.services.message.impl;

import com.example.chatggg.models.Message;
import com.example.chatggg.models.dto.message.MessageDto;
import com.example.chatggg.repositories.MessageRepository;
import com.example.chatggg.services.message.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public Message sendMessage(MessageDto messageDto) {
        return null;
    }
}
