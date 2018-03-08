/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import com.flopewsserver.controller.Database_Controller;
import com.flopewsserver.converter.JSONStringtoPOJO;
import com.flopewsserver.entities.User;
import java.util.logging.Logger;
import java.io.IOException;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    private final static HashMap<String, SecurityWebsocketEndpoint> sockets = new HashMap<>();
    private String myUniqueId;

    //the #uniqueID is created to create a unique identifier for the client that requested a connection, the ID is then sent back to the client and is stored in a HashMap together
    //with the SecurityWebsocketEndpoint-Objekt to identify established connections
    //https://stackoverflow.com/questions/17080216/how-to-send-message-to-particular-websocket-connection-using-java-server/17089997
    private String getMyUniqueId() {
        // unique ID from this class' hash code
        return Integer.toHexString(this.hashCode());
        
    }

    private void sendClient(String str) {
        try {
            this.session.getBasicRemote().sendText(str);
        } catch (IOException e) {
        }
    }
    
    
    @OnOpen
    public void onConnect(Session session) {
        // save session so we can send
        this.session = session;

        // this unique ID and send ID to client
        this.myUniqueId = this.getMyUniqueId();
        System.out.println(myUniqueId +"IDUnique");
        this.sendClient(myUniqueId);

        // map this unique ID to this connection
        SecurityWebsocketEndpoint.sockets.put(this.myUniqueId, this);}
   
    
    @OnMessage
    public void OnMessage(Session from,String message){
        
    message = message.substring(6);
    
    JSONStringtoPOJO conv = new JSONStringtoPOJO();
    User loginuser;
    loginuser = conv.convertJSONStringtoPOJOUSER(message);
    IncomingMessagesHandler dis;
    dis = new IncomingMessagesHandler();
    dis.test(loginuser);
    System.out.println(dis.test(loginuser));
    
    String loginserver = login(loginuser);
    System.out.println(loginserver);
    
     try {   this.session.getBasicRemote().sendText(loginserver);}
     catch (IOException ex) {
         Logger.getLogger(SecurityWebsocketEndpoint.class.getName()).log(Level.SEVERE, null,ex);}
     }
   
    
private String login(User loginuser) throws IllegalStateException {

String loginsuccess = "false";
User databaseuser = null;
 Database_Controller dc = new Database_Controller(); 
 
try {EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
     EntityManager em = emf.createEntityManager();
                                                                              }
catch (Exception e){e.printStackTrace(out); System.out.println(e.toString()+"stack");return loginsuccess;}

return loginsuccess;
    }

 





/*@OnMessage
public void broadcast(Session from, String msg){
  String senderID = (String) this.epCfg.getUserProperties().get(from.getID()); //check the mapping
  for(Session peer : peers) { //loop over ALL connected clients
    if(peer.isOpen()){
      peer.getBasicRemote().sendText("Message from User "+ senderID + " - " + msg);
    }
  }
}
    
    
  //zweite OnMessage Methode wird definiert um BinaryMessages zu empfangen. Diese wird benötigt, um Dateien zu empfangen und zu versenden
 /* @OnMessage
   
  public void OnMesssage (Binary binary){
   
   }*/
    
//EntityManager em = factory.createEntityManager();
//List<User> samples;
//samples = em.createNamedQuery("find_person_username_and_ident_dto" ).getResultList();
//System.out.println(loginuser);
//databaseuser = new User();
//databaseuser = samples.get(0);





/*IncomingMessagesHandler dis = new IncomingMessagesHandler();
dis.test(user);*/
//if (databaseuser.getUsername() == loginuser.getUsername() && databaseuser.getIdent()==loginuser.getIdent())
    
//{loginsuccess = "true";}

//else {loginsuccess = "false";}
}
    
    
  
