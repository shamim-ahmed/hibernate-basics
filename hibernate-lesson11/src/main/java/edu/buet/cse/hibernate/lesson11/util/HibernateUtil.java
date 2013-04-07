package edu.buet.cse.hibernate.lesson11.util;

import java.net.URL;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  
  static {
    try {
      URL configUrl = HibernateUtil.class.getResource("/config/hibernate.cfg.xml");
      URL userMappingUrl = HibernateUtil.class.getResource("/edu/buet/cse/hibernate/lesson11/model/User.hbm.xml");
      
      Configuration config = new Configuration().configure(configUrl);
      config.addURL(userMappingUrl);
      
      sessionFactory = config.buildSessionFactory();
    } catch (Exception ex) {
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
