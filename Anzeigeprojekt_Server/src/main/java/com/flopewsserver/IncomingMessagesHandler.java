/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import com.flopewsserver.entities.User;

/**
 *
 * @author Florian
 */
public class IncomingMessagesHandler {
    
    public String test(Object o){
       
        String variante = null;
        
        
        if(o instanceof User){System.out.println("Das Object ist ein User");
        variante = "Das Objekt ist ein User" ; 
        return variante;}
        
        
    return variante;}
    
}
