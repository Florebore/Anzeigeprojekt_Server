/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.controller;

import com.flopewsserver.entities.User;
import static javafx.application.Application.launch;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Florian
 */
public class TestDatabaseCRUD {

    public TestDatabaseCRUD() {
    }
    
    public static void main(String[] args) {
       
      
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        User a = new User();
        a.setFirstname("Server");
        a.setUsername("server");
        a.setUserID(6);
        em.persist(a);
        System.out.println(a);
        
        
        
        
}
}
