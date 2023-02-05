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

/*
* 채팅방의 생성, 조회, 메시지 발송이 이루어지는 Service 클래스
* */
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


    /* 채팅방 전체 조회 */
    public List<ChatRoom> findAllRoom() {
        return new ArrayList<>(chatRoom.values());
    }

    /* 채팅방 번호로 채팅 방 조회 */
    public ChatRoom findByRoomId(String roomId) {
        return chatRoom.get(roomId);
    }

    /* 채팅방 생성 */
    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom newChatRoom = ChatRoom.builder().roomId(randomId).name(name).build();
        chatRoom.put(randomId, newChatRoom);

        return newChatRoom;
    }

    /* 채팅 메시지 발송 */
    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            //지정한 WebSocket 세션에 메시지를 발송함
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
