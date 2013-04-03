package edu.buet.cse.hibernate.lesson06;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import edu.buet.cse.hibernate.lesson06.model.Comment;
import edu.buet.cse.hibernate.lesson06.util.HibernateUtil;

public class App2 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      Comment comment = (Comment) session.get(Comment.class, 1L);
      System.out.println(comment);
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
