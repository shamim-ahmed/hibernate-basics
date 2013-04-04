package edu.buet.cse.hibernate.lesson04;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.buet.cse.hibernate.lesson04.model.Address;
import edu.buet.cse.hibernate.lesson04.model.User;
import edu.buet.cse.hibernate.lesson04.util.HibernateUtil;

// create a new user and address
public class App3 {
  public static void main(String... args) {
    Session session = null;

    try {
      session = HibernateUtil.getSession();
      
      // create the domain objects
      User user = new User();
      user.setUsername("thompson");
      user.setCreatedDate(new Date());
      
      Address address = new Address();
      address.setStreet("35/160 Balaclava Road");
      address.setState("NSW");
      address.setCity("Sydney");
      address.setCountry("Australia");
      
      // note that both properties need to be set
      address.setUser(user);
      user.setAddress(address);
      
      // save the domain objects
      Transaction tx = session.beginTransaction();
      // we only save the user. The address gets saved automatically.
      session.save(user);  
      tx.commit();
      
      System.out.println("User and address created successfully");
    } catch (HibernateException ex) {
      ex.printStackTrace(System.err);
    }
  }
}
