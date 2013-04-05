package edu.buet.cse.hibernate.lesson10;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson10.model.Role;
import edu.buet.cse.hibernate.lesson10.util.HibernateUtil;

public class App3 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      Query query = session.createQuery("from Role r where r.roleName = :rn");
      query.setParameter("rn", "user");
      Role role = (Role) query.uniqueResult();
      System.out.println(role);
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
