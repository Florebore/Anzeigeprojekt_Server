/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import com.flopewsserver.beans.UserDataServiceBean;
import com.flopewsserver.converter.JSONStringtoPOJO;
import com.flopewsserver.entities.Userdata;
import java.util.logging.Logger;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Florian
 */

@ServerEndpoint("/login")
public class SecurityWebsocketEndpoint {
    
    
    
    
   
    private static final Set<Session> webSocketSessions = Collections.synchronizedSet(new HashSet<Session>());
    private static final Logger log = Logger.getLogger(SecurityWebsocketEndpoint.class.getName());
    private final static HashMap<String, SecurityWebsocketEndpoint> sockets = new HashMap<>();
    private String myUniqueId;
    
    @Inject
    private UserDataServiceBean udsb;
    
    public SecurityWebsocketEndpoint(){}
    
    
   

    //the #uniqueID is created to create a unique identifier for the client that requested a connection, the ID is then sent back to the client and is stored in a HashMap together
    //with the SecurityWebsocketEndpoint-Objekt to identify established connections
    //https://stackoverflow.com/questions/17080216/how-to-send-message-to-particular-websocket-connection-using-java-server/17089997
    private String getMyUniqueId() {
        // unique ID from this class' hash code
        return Integer.toHexString(this.hashCode());
        
    }

   /* private void sendClient(String str) {
        try {
           webSocketSessions..getBasicRemote().sendText(str);
        } catch (IOException e) {
        }
    }*/
    
    
    @OnOpen
    public void onConnect(Session session) throws IOException {
        // save session so we can send
      try{ session.getBasicRemote().sendText("session opened");
        //saves the sessioen in the websocketSession
       webSocketSessions.add(session);
        if (udsb == null) {
                Logger.getLogger(SecurityWebsocketEndpoint.class.getName()).log(Level.INFO, "udsb is null");
            }}
      
       catch (IOException ex) {
            Logger.getLogger(SecurityWebsocketEndpoint.class.getName()).log(Level.SEVERE, null, ex);}
      
        System.out.println(udsb);
        // this unique ID and send ID to client
        this.myUniqueId = this.getMyUniqueId();
        System.out.println(myUniqueId +"IDUnique");
        session.getBasicRemote().sendText(myUniqueId);
        // map this unique ID to this connection
        SecurityWebsocketEndpoint.sockets.put(this.myUniqueId, this); }
    
    
    @OnMessage
    public void OnMessage(String message, final Session client){
        
    message = message.substring(6);
    
    JSONStringtoPOJO conv = new JSONStringtoPOJO();
    Userdata loginuser = conv.convertJSONStringtoPOJOUSER(message);
    System.out.println("vortryInject");
    try{
    udsb.findUser();
    System.out.println("nach new()");
    Userdata userdb = udsb.findbyusername(loginuser);
    System.out.println("nach Methodenaufruf");
    System.out.println(userdb.getUsername());}
    catch(Exception e){e.printStackTrace();}
    //Query q1 = em.createNamedQuery("Userdatalogin").setParameter("username", loginuser.getUsername());
    //Object o = q1.getSingleResult();
    //System.out.println(o);
    //coverts Object ot target class
    //Userdata dbuser = Userdata.class.cast(o);
    //System.out.println(dbuser);
    
    
    
        
    
    try {   client.getBasicRemote().sendText("zurueck");}
     catch (IOException ex) {
         Logger.getLogger(SecurityWebsocketEndpoint.class.getName()).log(Level.SEVERE, null,ex);}
     }
   
    
private String login(Userdata loginuser) throws IllegalStateException {

String loginsuccess = "false";
System.out.println(loginsuccess);

   
                                                                              

return loginsuccess;
    }
//getBeanByName + get BeanManager + getFacade sind Methoden, um ein Bean zu finden, welches in einem WebSocket ein Bean findet, da Beans in Websocket oft nich
//den selben Container gemanaged werden und deswegen null sind
    
//zweite OnMessage Methode wird definiert um BinaryMessages zu empfangen. Diese wird ben�tigt, um Dateien zu empfangen und zu versenden
 /* @OnMessage
   
  public void OnMesssage (Binary binary){
   
   }*/
//if (databaseuser.getUsername() == loginuser.getUsername() && databaseuser.getIdent()==loginuser.getIdent())
    
//{loginsuccess = "true";}

//else {loginsuccess = "false";}

    @OnError
    public void onError(Throwable t) {
    }

    @OnClose
    public void onClose() {
    }
}
    
    
  
