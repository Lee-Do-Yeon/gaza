package com.idle.gaza.api.controller;

import java.util.List;

import com.idle.gaza.api.model.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.idle.gaza.db.entity.ConsultingRoom;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/map")
public class ConsultingRoomController {

//	private final MapRoomRepository mapRoomRepository;
	private final ChatRoomRepository chatRoomRepository;
	@Autowired
	private HttpSession httpSession;

	// 모든 채팅방 목록 반환
	@GetMapping("/rooms")
	@ResponseBody
	public List<ConsultingRoom> room() {
	    return chatRoomRepository.findAllRoom();
	}
	 
	// 채팅방 생성
	@PostMapping("/room")
	@ResponseBody
	public ResponseEntity<?> createRoom(@RequestBody String name) {
		ConsultingRoom room = chatRoomRepository.createRoom(name);
		if (room == null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(room, HttpStatus.OK);
//	    return room;
	}

	 // 특정 채팅방 조회
	@GetMapping("/room/{roomId}")
	@ResponseBody
	public ResponseEntity<?> roomInfo(@PathVariable String roomId) {
		System.out.println("들어온 룸 아이디 : "+roomId);
	    ConsultingRoom room = chatRoomRepository.findByRoomId(roomId);
		if (room == null) return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    return new ResponseEntity<>(room,HttpStatus.OK);
	}
	 
	public ConsultingRoomController(ChatRoomRepository chatRoomRepository) {
		super();
		this.chatRoomRepository = chatRoomRepository;
	}


	@PostMapping("/session")
	public void setSession(@RequestBody String sessionId, @RequestBody int reservationId){
		System.out.println(sessionId);

		String key = String.valueOf(reservationId);
		httpSession.setAttribute(key, sessionId);
	}

	@GetMapping("/session/{reservationId}")
	public ResponseEntity<?> getSession(@PathVariable int reservationId){
		String key = String.valueOf(reservationId);
		return new ResponseEntity<>(httpSession.getAttribute(key), HttpStatus.OK);
	}


}