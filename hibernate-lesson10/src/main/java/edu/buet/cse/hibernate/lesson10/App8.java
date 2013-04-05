package edu.buet.cse.hibernate.lesson10;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import edu.buet.cse.hibernate.lesson10.model.User;
import edu.buet.cse.hibernate.lesson10.util.HibernateUtil;

public class App8 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      long low = 3L;
      long high = 10L;
      
      Criteria criteria = session.createCriteria(User.class);
      criteria.add(Restrictions.ge("id", low));
      criteria.add(Restrictions.le("id", high));
      criteria.addOrder(Order.asc("id"));
      
      @SuppressWarnings("unchecked")
      List<User> users = criteria.list();
      
      for (User user : users) {
        System.out.printf("User name : %s%n", user.getUsername());
      }
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
