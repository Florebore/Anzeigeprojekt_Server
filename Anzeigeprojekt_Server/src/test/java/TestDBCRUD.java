/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.flopewsserver.entities.User;
import java.util.List;
import static javafx.application.Application.launch;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Florian
 */
public class TestDBCRUD {
   
    // TODO add test methods here.
   
    
    
    @Test
    public void CRUD(){
       
        User u = new User();
        u.setFirstname("server");
        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        
        User c = em.find(User.class,1);
        User d = em.find(User.class,6);
        Query createNamedQuery = em.createNamedQuery("User.findAll");
        List resultList = createNamedQuery.getResultList();
        Object get = resultList.get(0);
        System.out.println(get);
        System.out.print(resultList);
        System.out.println(c);
        System.out.println(d);
        
        
       
        
}
    
    
    
}

    
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

