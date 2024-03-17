package com.example.chatroomskafkabackenddatabasemessagesperroom.config;

import com.example.chatroomskafkabackenddatabasemessagesperroom.dao.ChatRoomMessagesRepository;
import com.example.chatroomskafkabackenddatabasemessagesperroom.pojo.ChatRoomMessages;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class ChatKafkaConsumerMessagesPerRoomConfig {

    private final ChatRoomMessagesRepository chatRoomMessagesRepository;

    @Bean
    public Consumer<KStream<String, Long>> messagePerRoom() {
        return kStream -> kStream
                .foreach((key, value) -> {
                    ChatRoomMessages currentChatRoom = chatRoomMessagesRepository.findById(key).orElse(new ChatRoomMessages(key, 0L));
                    currentChatRoom.setCount(currentChatRoom.getCount() + value);
                    chatRoomMessagesRepository.save(currentChatRoom);
                });
    }
}
