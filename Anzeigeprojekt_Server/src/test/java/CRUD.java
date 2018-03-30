/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.flopewsserver.IncomingMessagesHandler;
import com.flopewsserver.entities.Userdata;
import java.util.List;
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
public class CRUD {
    
    public CRUD() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
       @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
   @Test
   public void CRUD(){
   
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
   EntityManager em = emf.createEntityManager();
  /* User a = em.find(User.class, 1);
   String pw  = a.getIdent();
   Query q =  em.createNamedQuery("User.findAll");
   List l =  q.getResultList();
   System.out.println(l);
   Query q1 = em.createNamedQuery("User.findByUsername");
   q1.setParameter("username","f.boettinger");
   List l1 =  q1.getResultList();
   System.out.println(l1);*/
    

List<Userdata> samples;
samples = em.createNamedQuery("Userdata.").getResultList();
System.out.println(samples);
Userdata user = new Userdata();
user = samples.get(0);
String username = user.getUsername();
Integer id = user.getId();
System.out.println(id);
System.out.println(username);




   
   
   }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
