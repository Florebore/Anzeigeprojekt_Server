/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import com.flopewsserver.converter.JSONStringtoPOJO;
import com.flopewsserver.entities.User;
import java.util.logging.Logger;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.websocket.Decoder.*;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Florian
 */
@ServerEndpoint("/security")
public class SecurityWebsocketEndpoint {
    
    private Session session;
    private static final Logger log = Logger.getLogger(SecurityWebsocketEndpoint.class.getName());
 
    @OnOpen
    public void onOpen(Session session) {this.session = session;}
    
    @OnMessage
    
    public void OnMessage(String message){
     
    message = message.substring(6);
    
    JSONStringtoPOJO conv = new JSONStringtoPOJO();
    User loginuser;
    loginuser = conv.convertJSONStringtoPOJOUSER(message);
    IncomingMessagesHandler dis;
    dis = new IncomingMessagesHandler();
    dis.test(loginuser);
        
    System.out.println(dis.test(loginuser));
    
     try {   this.session.getBasicRemote().sendText("Echo"+(dis.test(loginuser)));}
     catch (IOException ex) {
         Logger.getLogger(SecurityWebsocketEndpoint.class.getName()).log(Level.SEVERE, null,ex);}
     }
    
    
  //zweite OnMessage Methode wird definiert um BinaryMessages zu empfangen. Diese wird ben�tigt, um Dateien zu empfangen und zu versenden
 /* @OnMessage
   
  public void OnMesssage (Binary binary){
   
   }*/
    
    }
    
    
  
