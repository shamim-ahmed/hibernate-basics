package edu.buet.cse.hibernate.lesson10;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson10.model.User;
import edu.buet.cse.hibernate.lesson10.util.HibernateUtil;

public class App4 {
  public static void main(String... args) {
    Session session = null;

    try {
      session = HibernateUtil.getSession();
      Query query = session.createQuery("from User u where u.id = :id");
      query.setParameter("id", 1L);
      User user = (User) query.uniqueResult();
      System.out.println(user);
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
