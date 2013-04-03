package edu.buet.cse.hibernate.lesson04;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson04.model.Address;
import edu.buet.cse.hibernate.lesson04.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      Address address = (Address) session.get(Address.class, 1L);
      System.out.println(address);
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
