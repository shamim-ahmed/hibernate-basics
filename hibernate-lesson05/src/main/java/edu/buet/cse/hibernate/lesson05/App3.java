package edu.buet.cse.hibernate.lesson05;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson05.model.Comment;
import edu.buet.cse.hibernate.lesson05.model.User;
import edu.buet.cse.hibernate.lesson05.util.HibernateUtil;

public class App3 {
  public static void main(String... args) {
    Session session = null;
    
    try {
      session = HibernateUtil.getSession();
      
      // construct the domain objects
      User user = new User();
      user.setUsername("richie");
      user.setCreatedDate(new Date());
      
      Comment comment1 = new Comment();
      comment1.setContent("A successful man is one who makes more money than his wife can spend.");
      comment1.setUser(user);
      Comment comment2 = new Comment();
      comment2.setContent("A successful woman is one who can find such a man");
      comment2.setUser(user);
      
      user.addComment(comment1);
      user.addComment(comment2);
      
      // save the domain objects
      Transaction tx = session.beginTransaction();
      session.save(user);
      tx.commit();
      
      System.out.println("New user is saved successfully along with his comments");
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
