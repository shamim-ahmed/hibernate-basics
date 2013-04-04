package edu.buet.cse.hibernate.lesson04;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson04.model.User;
import edu.buet.cse.hibernate.lesson04.util.HibernateUtil;

public class App4 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      User user = (User) session.get(User.class, 1L);
      
      Transaction tx = session.beginTransaction();
      // deleting the user will also delete the address, due to ON DELETE CASCADE 
      session.delete(user);
      tx.commit();
      
      System.out.println("User deleted successfully");
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
