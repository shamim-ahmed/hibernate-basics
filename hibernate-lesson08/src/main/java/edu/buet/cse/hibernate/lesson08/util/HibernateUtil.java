package edu.buet.cse.hibernate.lesson08.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  
  static {
    try {
      sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static Session getSession() {
    return sessionFactory.openSession();
  }
  
  public static void cleanUp() {
    sessionFactory.close();
  }
  
  private HibernateUtil() {
  }
}
