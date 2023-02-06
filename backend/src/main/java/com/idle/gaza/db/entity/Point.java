package com.idle.gaza.db.entity;

public class Point {

    private String lat; // 메시지 보낸사람
    private String lng; // 메시지
    private String roomId; // 방번호
    
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public String getRoomId() {
		return roomId;
	}
	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
    
    
}