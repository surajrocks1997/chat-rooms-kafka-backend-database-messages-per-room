package com.example.chatroomskafkabackenddatabasemessagesperroom.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class ChatRoomMessages {

    @Id
    private String chatRoomName;
    private Long count;
}
