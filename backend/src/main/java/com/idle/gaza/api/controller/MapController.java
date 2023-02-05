package com.idle.gaza.api.controller;
import com.idle.gaza.db.entity.MapMessage;
import com.idle.gaza.db.entity.Point;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class MapController {
	private final SimpMessageSendingOperations messagingTemplate;

	// 웹소켓으로 들어오는 메시지 발행 처리.
	// /pub/chat/message로 발행 요청 -> 컨트롤러가 메세지를 받아서 처리
	// 발행되면 /sub/chat/room/{roomId}로 메세지를 send. 저게 Topic 역할.
	@MessageMapping("/chat/message")
	public void message(@RequestBody MapMessage message) {
		if (MapMessage.MessageType.ENTER.equals(message.getType()))
			message.setMessage(message.getSender() + "님이 입장하셨습니다.");
		messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomId(), message);
	}

	// 웹소켓으로 들어오는 메시지 발행 처리.
	// /pub/chat/message로 발행 요청 -> 컨트롤러가 메세지를 받아서 처리
	// 발행되면 /sub/chat/room/{roomId}로 메세지를 send. 저게 Topic 역할.
	@MessageMapping("/chat/point")
	public void point(@RequestBody Point point) {
		messagingTemplate.convertAndSend("/sub/chat/room2/" + point.getRoomId(), point);
	}

	public MapController(SimpMessageSendingOperations messagingTemplate) {
		super();
		this.messagingTemplate = messagingTemplate;
	}

}
