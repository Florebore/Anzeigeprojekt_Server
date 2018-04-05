/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.beans;


import com.flopewsserver.entities.Userdata;
import javax.ejb.Local;
import javax.inject.Named;

/**
 *
 * @author Florian
 */
@Local
public interface UserDataService {
    
    Userdata findbyusername(Userdata loginuser);
    Userdata findUser ();    
    
    
}
