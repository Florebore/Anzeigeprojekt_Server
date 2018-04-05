/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


/**
 *
 * @author Florian
 */
public class Security_Controller_shiro {
    
    public static final Logger log = Logger.getLogger(Security_Controller_shiro.class.getName());
       
public Boolean logincheck(){
    
      Boolean logincheck = false;

     // The easiest way to create a Shiro SecurityManager with configured
        // realms, users, roles and permissions is to use the simple INI config.
        // We'll do that by using a factory that can ingest a .ini file and
        // return a SecurityManager instance:

        // Use the shiro.ini file at the root of the classpath
        // (file: and url: prefixes load from files and urls respectively):
    
    Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
    org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
    
     // for this simple example quickstart, make the SecurityManager
        // accessible as a JVM singleton.  Most applications wouldn't do this
        // and instead rely on their container configuration or web.xml for
        // webapps.  That is outside the scope of this simple quickstart, so
        // we'll just do the bare minimum so you can continue to get a feel
        // for things.
        
     // to use Shiro you always need a subject, which represents the current user, who is unknown at the time of instantiation und has to be filled with 
     // attributes e.g. from a database or a login screen
        
     SecurityUtils.setSecurityManager(securityManager);
     Subject currentUser = SecurityUtils.getSubject();
     
    Session session = currentUser.getSession();
    session.setAttribute( "someKey", "aValue" );
     
        // let's login the current user so we can check against roles and permissions:
        if (!currentUser.isAuthenticated()) {
    //im folgenden m�ssen die Daten des aktuellen Subjects z.B. aus einer Eingabemaske gesammelt werden und mit dem Subjekt in der Datenbank verglichen werden....        
               UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {currentUser.login(token);} 
            
            catch (UnknownAccountException uae) {log.log(Level.INFO, "There is no user with username of {0}", token.getPrincipal());}
            
            catch (IncorrectCredentialsException ice) {log.log(Level.INFO, "Password for account {0} was incorrect!", token.getPrincipal());} 
            
            catch (LockedAccountException lae) {log.log(Level.INFO, "The account for username {0} is locked.  Please contact your administrator to unlock it.", token.getPrincipal());}
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {//unexpected condition?  error?
            }
        }
        
        
       return logincheck;
    
    
    


}    
    
    
    
    
    
}