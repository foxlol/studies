package br.com.fox.jee7;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat")
public class ChatServer {

	private static final Logger LOGGER = Logger.getLogger(ChatServer.class.getName());
	
	@OnOpen
	public void onOpen(Session session) {
		
		LOGGER.log(Level.INFO, "New client: {0}", session.getId());
	}
	
	@OnMessage
	public void onMessage(String message, Session session) throws IOException {
		
		LOGGER.log(Level.INFO, 
			"New message from client {0}: {1}", 
				new Object[] {session.getId(), message});
		
		for (Session clientSession : session.getOpenSessions()) {
			
			clientSession.getBasicRemote().sendText(message);
		}
	}
	
	@OnClose
    public void onClose(Session session) {
		
        LOGGER.log(Level.INFO, "Closed connection for client: {0}", session.getId());
    }
	
	@OnError
    public void onError(Throwable exception, Session session) {
		
        LOGGER.log(Level.SEVERE, "Error for client: {0}", session.getId());
    }
	
}
