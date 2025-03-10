package com.example.chatggg.repositories;

import com.example.chatggg.models.WaitingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WaitingUserRepository extends JpaRepository<WaitingUser, Long> {
}
