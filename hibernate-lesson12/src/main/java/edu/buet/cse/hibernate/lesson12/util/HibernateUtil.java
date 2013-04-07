package edu.buet.cse.hibernate.lesson12.util;

import java.net.URL;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class HibernateUtil {
  private static final SessionFactory sessionFactory;
  
  static {
    try {
      Properties configProps = new Properties();
      configProps.load(HibernateUtil.class.getResourceAsStream("/hibernate.properties"));
      
      Configuration config = new Configuration();
      config.addProperties(configProps);
      
      URL userMappingUrl = HibernateUtil.class.getResource("/edu/buet/cse/hibernate/lesson12/model/User.hbm.xml");
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
