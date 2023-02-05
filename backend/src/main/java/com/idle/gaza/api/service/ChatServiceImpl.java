package com.idle.gaza.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idle.gaza.api.model.ChatRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@Log4j2
@RequiredArgsConstructor
@Service("chatService")
public class ChatServiceImpl implements ChatService{

    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRoom;


    @PostConstruct
    private void init() {
        chatRoom = new LinkedHashMap<>();
    }


    public List<ChatRoom> findAllRoom() {
        return new ArrayList<>(chatRoom.values());
    }

    public ChatRoom findByRoomId(String roomId) {
        return chatRoom.get(roomId);
    }

    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom newChatRoom = ChatRoom.builder().roomId(randomId).name(name).build();
        chatRoom.put(randomId, newChatRoom);

        return newChatRoom;
    }

    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
