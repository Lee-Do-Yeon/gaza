package com.idle.gaza.api.service;

import com.idle.gaza.api.model.ChatRoom;
import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface ChatService {


    List<ChatRoom> findAllRoom();

    ChatRoom findByRoomId(String roomId);

    ChatRoom createRoom(String name);

    <T> void sendMessage(WebSocketSession session, T message);
}
