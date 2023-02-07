package com.idle.gaza.api.controller;

import com.idle.gaza.api.model.ChatRoom;
import com.idle.gaza.api.model.ChatRoomRepository;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/chat")
@RestController
@Api(value = "Chat API", tags = {"Chatting"})
@Log4j2
public class ChatRoomController {

    @Autowired
    private ChatRoomRepository chatRoomRepository;

    //채팅방 생성
    @PostMapping("/room")
    public ResponseEntity<?> roomCreate(@RequestBody String name) {
        ChatRoom chatRoom = chatRoomRepository.createRoom(name);
        if (chatRoom == null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(chatRoom, HttpStatus.OK);
    }

    //채팅방 목록 확인
    @GetMapping("/room")
    public ResponseEntity<?> roomList(){
        List<ChatRoom> chatRoom = chatRoomRepository.findAllRoom();
        log.info("room size = " + chatRoom.size());
        if(chatRoom.size() == 0) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(chatRoom, HttpStatus.OK);
    }


    //특정 채팅방 조회
    @GetMapping("/room/{roomId}")
    public ResponseEntity<?> enterRoom(@PathVariable String roomId) {
        log.info("room enter = " + roomId);
        ChatRoom chatRoom = chatRoomRepository.findByRoomId(roomId);
        if (chatRoom == null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(chatRoom, HttpStatus.OK);
    }


}
