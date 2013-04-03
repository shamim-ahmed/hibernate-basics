package edu.buet.cse.hibernate.lesson07;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson07.model.Role;
import edu.buet.cse.hibernate.lesson07.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      Role role = (Role) session.get(Role.class, 2L);
      System.out.println(role);
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
