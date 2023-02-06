package com.idle.gaza.api.controller;

import com.idle.gaza.api.model.ChatMessage;
import com.idle.gaza.api.model.ChatRoomRepository;
import com.idle.gaza.api.pubsub.RedisPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @Autowired
    private RedisPublisher redisPublisher;
    @Autowired
    private ChatRoomRepository chatRoomRepository;


    /*
    * '/pub/chat/message'로 들어오는 메시징 처리
    * */
    @MessageMapping("/chat/message")
    public void message(ChatMessage message) {
        if (ChatMessage.MessageType.ENTER.equals(message.getMessageType())) {
            chatRoomRepository.enterChatRoom(message.getChatRoomId());
            message.setMessage(message.getWriterName() + "님 입장하셨습니다.");
        }

        //websocket에 발행된 메시지를 redis로 발행한다(publish)
        redisPublisher.publish(chatRoomRepository.getTopic(message.getChatRoomId()), message);
    }

}
