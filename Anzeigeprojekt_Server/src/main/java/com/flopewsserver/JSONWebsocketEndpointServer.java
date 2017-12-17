/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import java.util.logging.Logger;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
@ServerEndpoint("/websocket")
public class JSONWebsocketEndpointServer {
    
    private Session session;
 
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
    
    
  
