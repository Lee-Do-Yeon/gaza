package com.idle.gaza.api.pubsub;

import com.idle.gaza.api.model.ChatMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

/*
 * Redis 발행 서비스
 * 메시지를 작성하면 해당 메시지를 Redis Template에 발행하는 기능의 서비스
 * */

@RequiredArgsConstructor
@Service
public class RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;


    public void publish(ChannelTopic topic, ChatMessage message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }


}