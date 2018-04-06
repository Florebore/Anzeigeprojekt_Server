/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.beans;

import com.flopewsserver.entities.Userdata;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Florian
 */
//https://docs.oracle.com/javaee/6/tutorial/doc/gjbak.html
@Named
//https://docs.oracle.com/javaee/6/tutorial/doc/gjbbk.html 
@ApplicationScoped
public class UserDataServiceBean implements UserDataService {
    
    @PersistenceContext
    EntityManager em;

    public UserDataServiceBean(){}
    
    
    @Override
    public Userdata findbyusername(Userdata loginuser) {
        
        Userdata userdb = null;
        
    Query q1 = em.createNamedQuery("Userdatalogin").setParameter("username", loginuser.getUsername());
    Object o = q1.getSingleResult();
    System.out.println(o);
    //coverts Object ot target class
    Userdata dbuser = Userdata.class.cast(o);
    System.out.println(dbuser);
        
        
        return userdb; 
        
    }
    
    @Override
    public Userdata findUser(){
      
        Userdata userdb = null;
        
    System.out.println(em);
        
    Query q1 = em.createNamedQuery("Userdata.findAll");
    Object o = q1.getResultList().get(0);
    System.out.println(o);
    //coverts Object ot target class
    Userdata dbuser = Userdata.class.cast(o);
    System.out.println(dbuser);
        
        
        return userdb; 
    }
    
    
    
}
