package edu.buet.cse.hibernate.lesson02;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson02.model.User;
import edu.buet.cse.hibernate.lesson02.util.HibernateUtil;

// update a User
public class App3 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      User user = (User) session.get(User.class, 1L);
      user.setUsername(user.getUsername().concat("updated"));
      user.setCreatedDate(new Date());
      tx.commit();
      
      System.out.println("User updated successfully");
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
