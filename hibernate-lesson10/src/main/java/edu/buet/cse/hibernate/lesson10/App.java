package edu.buet.cse.hibernate.lesson10;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson10.model.Role;
import edu.buet.cse.hibernate.lesson10.model.User;
import edu.buet.cse.hibernate.lesson10.util.HibernateUtil;

public class App {
  public static void main(String[] args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      Query query = session.createQuery(String.format("from User u where u.id = %d", 1L));
      User user = (User) query.uniqueResult();
      
      System.out.printf("User %s has the following roles : %n", user.getUsername());
      
      for (Role role : user.getRoles()) {
        System.out.printf("%s%n", role.getRoleName());
      }
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
