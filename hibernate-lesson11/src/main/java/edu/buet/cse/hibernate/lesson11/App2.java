package edu.buet.cse.hibernate.lesson11;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson11.model.User;
import edu.buet.cse.hibernate.lesson11.util.HibernateUtil;

// create a User
public class App2 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      User user = new User();
      user.setUsername("linus");
      user.setCreatedDate(new Date());
      
      Transaction tx = session.beginTransaction();
      session.persist(user);
      tx.commit();
      
      System.out.println("New user created successfully");
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
    } finally {
      if (session != null) {
        session.close();
      }
      
      HibernateUtil.cleanUp();
    }
  }
}
