/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.beans;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Florian
 */
public class BeanSearcher {
    
    
    
    private Object getBeanByName(String name) throws NamingException // eg. name="Beanname"
    {
        BeanManager bm = getBeanManager();
        Bean bean = bm.getBeans(name).iterator().next();
        CreationalContext ctx = bm.createCreationalContext(bean); // could be inlined below
        Object o = bm.getReference(bean, bean.getClass(), ctx); // could be inlined with return
        return o;
    }

 public BeanManager getBeanManager() throws NamingException
    {
        try{
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");}
        catch (NamingException e) {
            System.out.println("Couldn't get BeanManager through JNDI");
            return null;
        }}
        
  public UserDataServiceBean getFacade() throws NamingException
    {
        BeanManager bm = getBeanManager();
        Bean<UserDataServiceBean> bean = (Bean<UserDataServiceBean>) bm.getBeans(UserDataServiceBean.class).iterator().next();
        CreationalContext<UserDataServiceBean> ctx = bm.createCreationalContext(bean);
        UserDataServiceBean dao = (UserDataServiceBean) bm.getReference(bean, UserDataServiceBean.class, ctx); // this could be inlined, but intentionally left this way
        return dao;
    }   
    
}
