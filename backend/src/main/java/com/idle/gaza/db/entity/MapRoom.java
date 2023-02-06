package com.idle.gaza.db.entity;

import java.util.UUID;


public class MapRoom {
    private String roomId;
    private String name;
    
    public static MapRoom create(String name) {
        MapRoom mapRoom = new MapRoom();
        mapRoom.roomId = UUID.randomUUID().toString();
        mapRoom.name = name;
        return mapRoom;
    }

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MapRoom() {
		super();
	}
    
    
}