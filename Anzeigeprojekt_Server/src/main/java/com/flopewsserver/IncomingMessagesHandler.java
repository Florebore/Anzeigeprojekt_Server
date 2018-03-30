/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import com.flopewsserver.entities.Userdata;

/**
 *
 * @author Florian
 */
public class IncomingMessagesHandler {
    
    public IncomingMessagesHandler(){};
    
    public String test(Object o){
       
        String variante = null;
        
        
        if(o instanceof Userdata){System.out.println("Das Object ist ein User");
        variante = "User"; 
        return variante;
        }
        
        
    return variante;}
    
}
