package com.idle.gaza.api.model;

import com.idle.gaza.api.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@ToString
@Log4j2
public class ChatRoom {

    private String roomId;
    private String name;
    private Set<WebSocketSession> webSocketSessions = new HashSet<>();

    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleMessage(WebSocketSession session, ChatMessage chatMessage, ChatService chatService) {

        if (chatMessage.getMessageType() == MessageType.ENTER) {//입장한 경우
            joinChatRoom(session);
            chatMessage.setMessage(chatMessage.getWriterName() + "님이 입장했습니다");
        }

        send(chatMessage, chatService);
    }

    private void joinChatRoom(WebSocketSession session) {
        webSocketSessions.add(session);
    }


    private <T> void send(T message, ChatService chatService) {
        webSocketSessions.parallelStream().forEach(session -> chatService.sendMessage(session, message));
    }

}
