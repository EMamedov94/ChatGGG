package com.example.chatggg.services.message;

import com.example.chatggg.models.ChatRoom;
import com.example.chatggg.models.Message;
import com.example.chatggg.models.User;
import com.example.chatggg.models.dto.message.MessageDto;

import java.security.Principal;
import java.util.List;

public interface MessageService {
    Message sendMessage(MessageDto messageDto);
    ChatRoom getOrCreateChatRoom(User currentUser);
}
