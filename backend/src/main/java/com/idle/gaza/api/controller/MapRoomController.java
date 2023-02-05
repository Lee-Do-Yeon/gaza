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

import com.idle.gaza.db.entity.MapRoom;
import com.idle.gaza.db.repository.MapRoomRepository;

@Controller
@RequestMapping("/chat")
public class MapRoomController {

	private final MapRoomRepository mapRoomRepository;

	// 모든 채팅방 목록 반환
	@GetMapping("/rooms")
	@ResponseBody
	public List<MapRoom> room() {
	    return mapRoomRepository.findAllRoom();
	}
	 
	// 채팅방 생성
	@PostMapping("/room")
	@ResponseBody
	public MapRoom createRoom(@RequestBody String name) {
		MapRoom room = mapRoomRepository.createChatRoom(name);
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
	    MapRoom room = mapRoomRepository.findRoomById(roomId);
	    System.out.println(room.toString());
	    return new ResponseEntity<>(room,HttpStatus.OK);
	}
	 
	public MapRoomController(MapRoomRepository mapRoomRepository) {
		super();
		this.mapRoomRepository = mapRoomRepository;
	}
	 
}