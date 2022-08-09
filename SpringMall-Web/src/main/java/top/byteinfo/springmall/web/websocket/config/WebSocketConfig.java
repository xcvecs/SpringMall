package top.byteinfo.springmall.web.websocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import top.byteinfo.springmall.web.websocket.handler.WSHandler;


@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(getHandler(),"/ws")/*.setAllowedOrigins("*")*/;
    }

    @Bean
    WSHandler getHandler() {
        return new WSHandler();
    }
}