package edu.buet.cse.hibernate.lesson05;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson05.model.User;
import edu.buet.cse.hibernate.lesson05.util.HibernateUtil;

public class App4 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      User user = (User) session.get(User.class, 1L);
      
      Transaction tx = session.beginTransaction();
      // this will result in user_id being set to NULL in all comments belonging to this user
      // due to ON DELETE SET NULL in table definition
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
