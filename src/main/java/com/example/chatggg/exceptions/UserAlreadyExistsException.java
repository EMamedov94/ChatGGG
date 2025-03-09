package com.example.chatggg.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("Такой пользователь уже существует");
    }
}
