package edu.buet.cse.hibernate.lesson14.dao;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson14.model.User;

public class UserDao {
  private final Session session;
  
  public UserDao(Session session) {
    this.session = Objects.requireNonNull(session);
  }
  
  public User getUser(Long id) {
    if (id == null) {
      throw new IllegalArgumentException("id cannot be null");
    }
    
    User user = null;
    
    // it is important to use a transaction here.
    // otherwise, script.sql cannot be run while the web app is running 
    Transaction tx = session.beginTransaction();
    user = (User) session.get(User.class, id);
    tx.commit();
    
    return user;
  }
}
