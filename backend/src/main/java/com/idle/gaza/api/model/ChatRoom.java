package com.idle.gaza.api.model;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.UUID;

@Getter
@ToString
@Log4j2
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 3014076092847700094L;
    private String roomId;
    private String name;


    public static ChatRoom create(String name){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.name = name;
        return chatRoom;
    }


}
