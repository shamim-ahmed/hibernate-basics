package edu.buet.cse.hibernate.lesson14.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
  private static final Logger logger = LogManager.getLogger(HibernateUtil.class);
  private static final SessionFactory sessionFactory;
  
  static {
    try {
      sessionFactory = new Configuration().configure().buildSessionFactory();
    } catch (HibernateException ex) {
      logger.error("Error while initializing Hibernate", ex);
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
