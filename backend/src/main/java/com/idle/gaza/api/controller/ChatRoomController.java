package com.idle.gaza.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idle.gaza.db.entity.ChatRoom;
import com.idle.gaza.db.repository.ChatRoomRepository;

@Controller
@RequestMapping("/chat")
public class ChatRoomController {

	private final ChatRoomRepository chatRoomRepository;

	// 모든 채팅방 목록 반환
	@GetMapping("/rooms")
	@ResponseBody
	public List<ChatRoom> room() {
	    return chatRoomRepository.findAllRoom();
	}
	 
	// 채팅방 생성
	@PostMapping("/room")
	@ResponseBody
	public ChatRoom createRoom(@RequestBody String name) {
		ChatRoom room = chatRoomRepository.createChatRoom(name);
	    return room;
	}
	 
	// 채팅방 입장 화면 (x)
	@GetMapping("/room/enter/{roomId}")
	public String roomDetail(Model model, @PathVariable String roomId) {
	    model.addAttribute("roomId", roomId);
	    return "/chat/roomdetail";
	}
	 
	 // 특정 채팅방 조회
	@GetMapping("/room/{roomId}")
	@ResponseBody
	public ResponseEntity<?> roomInfo(@PathVariable String roomId) {
		System.out.println("들어온 룸 아이디 : "+roomId);
	    ChatRoom room = chatRoomRepository.findRoomById(roomId);
	    System.out.println(room.toString());
	    return new ResponseEntity<>(room,HttpStatus.OK);
	}
	 
	public ChatRoomController(ChatRoomRepository chatRoomRepository) {
		super();
		this.chatRoomRepository = chatRoomRepository;
	}
	 
}