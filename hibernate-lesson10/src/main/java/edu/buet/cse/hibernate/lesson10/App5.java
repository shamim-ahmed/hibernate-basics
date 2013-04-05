package edu.buet.cse.hibernate.lesson10;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson10.util.HibernateUtil;

public class App5 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      
      Transaction tx = session.beginTransaction();
      Query query = session.createQuery(String.format("update Role r set r.roleDescription = '%s' where r.id = %d", "The modified description", 1));
      int result = query.executeUpdate();
      tx.commit();
   
      System.out.printf("Result : %d%n", result);
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
