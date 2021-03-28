package demo;

import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Class: demo03
 * @Description: websocket server
 */


@ServerEndpoint(value = "/ws/{userId}")
public class demo03 {
    private Logger logger = LoggerFactory.getLogger(demo03.class);

    private String userId;

    @OnOpen
    public void onOpen(@PathParam("userId") String userId, Session session) throws IOException {
        this.userId = userId;
        logger.debug("new connection: {}", userId);
    }

    @OnClose
    public void onClose() {
        logger.debug("connection: {} closing", this.userId);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        logger.debug("received: {} from {}", message, this.userId);
        session.getBasicRemote().sendText("received " + this.userId + " from you");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        logger.debug("error of sending message of user id: {}", this.userId);
        error.printStackTrace();
    }
}
