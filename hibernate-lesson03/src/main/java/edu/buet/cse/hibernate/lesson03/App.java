package edu.buet.cse.hibernate.lesson03;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson03.model.User;
import edu.buet.cse.hibernate.lesson03.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      User user = (User) session.get(User.class, 1L);
      System.out.println(user);
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
    } finally {
      if (session != null) {
        session.close();
      }
      
      // call this after all sessions have been closed
      HibernateUtil.cleanUp();
    }
  }
}
