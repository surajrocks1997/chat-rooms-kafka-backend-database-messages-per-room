package com.example.chatroomskafkabackenddatabasemessagesperroom.dao;

import com.example.chatroomskafkabackenddatabasemessagesperroom.pojo.ChatRoomMessages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomMessagesRepository extends JpaRepository<ChatRoomMessages, String> {
}
