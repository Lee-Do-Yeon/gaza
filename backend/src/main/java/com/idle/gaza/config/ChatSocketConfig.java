package com.idle.gaza.config;

import com.idle.gaza.api.handler.ChatHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;


@Configuration
@EnableWebSocket
public class ChatSocketConfig implements WebSocketConfigurer {

    @Autowired
    private ChatHandler chatHandler;
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //해당 endpoint로 handshake가 이루어짐
        registry.addHandler(chatHandler, "/ws/chat").setAllowedOriginPatterns("*");
    }
    
}
