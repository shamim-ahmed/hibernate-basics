package edu.buet.cse.hibernate.lesson11;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson11.model.User;
import edu.buet.cse.hibernate.lesson11.util.HibernateUtil;

// example of User deletion
public class App4 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      User user = (User) session.get(User.class, 1L);
      
      Transaction tx = session.beginTransaction();
      session.delete(user);
      tx.commit();
      
      System.out.println("User deleted successfully");
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
