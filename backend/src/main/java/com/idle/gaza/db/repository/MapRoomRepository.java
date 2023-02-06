package com.idle.gaza.db.repository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.idle.gaza.db.entity.MapRoom;

// 채팅방을 생성하고 정보를 조회하는 레포.
// 채팅방 정보를 현재는 Map으로 관리.
// DB 등에 채팅방 정보를 저장하도록 구현해야함. (서비스할거면..)

@Repository
public class MapRoomRepository {
    private Map<String, MapRoom> chatRoomMap;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<MapRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public MapRoom findRoomById(String id) {
        return chatRoomMap.get(id);
    }

    public MapRoom createChatRoom(String name) {
        MapRoom mapRoom = MapRoom.create(name);
        chatRoomMap.put(mapRoom.getRoomId(), mapRoom);
        return mapRoom;
    }
}
