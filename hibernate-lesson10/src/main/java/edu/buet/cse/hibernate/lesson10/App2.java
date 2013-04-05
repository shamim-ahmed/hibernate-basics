package edu.buet.cse.hibernate.lesson10;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson10.model.Role;
import edu.buet.cse.hibernate.lesson10.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      // note that in the query string, we refer to the property of the entity object
      // rather than the column of the table
      Query query = session.createQuery(String.format("from Role r where r.roleName = '%s'", "admin"));
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
