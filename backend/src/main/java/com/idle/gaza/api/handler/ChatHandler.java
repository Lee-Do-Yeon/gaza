package com.idle.gaza.api.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.idle.gaza.api.model.ChatMessage;
import com.idle.gaza.api.model.ChatRoom;
import com.idle.gaza.api.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Log4j2
public class ChatHandler extends TextWebSocketHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ChatService chatService;


    /* 웹소캣 클라이언트가 텍스트 메시지를 전송할 때 호출됨 */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload {}", payload);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom chatRoom = chatService.findByRoomId(chatMessage.getChatRoomId());
        chatRoom.handleMessage(session, chatMessage, chatService);
    }

    /* Client가 접속 시 호출됨 */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info(session + " client 접속");
    }

    /* Client가 접속 해제 시 호출됨 */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info(session + " client 접속 해제");
    }

}
