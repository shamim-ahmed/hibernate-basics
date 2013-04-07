package edu.buet.cse.hibernate.lesson13.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson13.dao.UserDao;
import edu.buet.cse.hibernate.lesson13.util.HibernateUtil;

public class CustomContextListener implements ServletContextListener {
  private static final String ATTRIBUTE_NAME = "userDao";
  
  @Override
  public void contextInitialized(ServletContextEvent event) {
    Session session = HibernateUtil.getSession();
    UserDao userDao = new UserDao(session);
    event.getServletContext().setAttribute(ATTRIBUTE_NAME, userDao);
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {  
    HibernateUtil.cleanUp();
  }
}
