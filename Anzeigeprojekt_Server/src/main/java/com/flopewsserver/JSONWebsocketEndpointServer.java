/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import java.util.logging.Logger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Florian
 */
@ServerEndpoint("/endpoint")
public class JSONWebsocketEndpointServer {
    
    private Session session;
    
    //private static final Set<Session> sessions = Collections.synchronizedSet(new HashSet<Session>());
   
    @OnOpen
    public void onOpen(Session session) {this.session = session;}
    
    @OnMessage
    
    public void OnMessage(String message){
        
        System.out.println("----"+message);
     try {   this.session.getBasicRemote().sendText("Echo"+message);}
     catch (IOException ex) {
         Logger.getLogger(JSONWebsocketEndpointServer.class.getName()).log(Level.SEVERE, null,ex);}
     }
    
   
    
    }
    
    
   /* @OnClose
    public void OnClose(Session session) {sessions.remove(session);}
    
   
    
    public String onMessage(ByteBuffer bytebuffer) {
        sessions.forEach((Session session) -> {
            try {session.getBasicRemote().sendBinary(bytebuffer);}
            catch (IOException ex) {
                Logger.getLogger(WebsocketEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return null;
    }
    
}*/
