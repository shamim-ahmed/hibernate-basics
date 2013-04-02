package edu.buet.cse.hibernate.lesson01.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  
  static {
    sessionFactory = new Configuration().configure().buildSessionFactory();
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
