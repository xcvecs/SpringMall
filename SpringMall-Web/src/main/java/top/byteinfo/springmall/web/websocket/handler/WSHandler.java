package top.byteinfo.springmall.web.websocket.handler;

import org.apache.tomcat.websocket.WsSession;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.adapter.AbstractWebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.Session;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 聊天记录
 * 在线人数
 * 撤回消息
 */

public class WSHandler extends TextWebSocketHandler {

    private static  List<WebSocketSession> sessionList = new ArrayList<>();

    LinkedBlockingDeque<TextMessage> messageArrayDeque = new LinkedBlockingDeque<>();


    private static boolean ws;

    private static ExecutorService bootstrap = Executors.newSingleThreadExecutor();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        messageConsumer(message);

    }

    public WSHandler() {
        super();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (sessionList.isEmpty()) bootstrap.submit(this::webSocketServerHandler);

        sessionList.add(session);
        TextMessage textMessage = new TextMessage("Established");
        messageConsumer(textMessage);

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        TextMessage textMessage = new TextMessage("ConnectionClosed");
        messageArrayDeque.push(textMessage);


    }

    @Override
    public boolean supportsPartialMessages() {
        return super.supportsPartialMessages();
    }

    public void messageConsumer(TextMessage message) {
        messageArrayDeque.push(message);


    }

    public void webSocketServerHandler() {
        int count = 0;
        ws = true;
        while (ws) {

            if (!messageArrayDeque.isEmpty()) {
                TextMessage pop = messageArrayDeque.pop();
                messageLocalServerHandler(pop);
                messageMqHandler(pop);

            }

        }
    }

    /**
     * handler message
     * @param message
     */
    public void messageLocalServerHandler(TextMessage message) {

        for (WebSocketSession webSocketSession : sessionList) {
            if (webSocketSession == null) break;

            AbstractWebSocketSession<Session> abstractWebSocketSession = (AbstractWebSocketSession<Session>) webSocketSession;
            Session nativeSession = abstractWebSocketSession.getNativeSession();
            WsSession wsSession = (WsSession) nativeSession;
            try {
                wsSession.getBasicRemote().sendBinary(ByteBuffer.wrap(" ".getBytes()));

                nativeSession.getBasicRemote().sendText(String.valueOf(message));
            } catch (IOException e) {
                System.out.println("error");
//                WsSocketServerHandler();
            }
        }
    }

    /**
     * handler message
     * @param message
     */
    public void messageMqHandler(TextMessage message) {


    }


}




