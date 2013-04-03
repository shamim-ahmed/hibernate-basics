package edu.buet.cse.hibernate.lesson03.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Address {
  private Long userId;
  private String street;
  private String city;
  private String state;
  private String country;
  private User user;
  
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
  
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
  
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("userId", userId)
           .append("username", user.getUsername())
           .append("street", street)
           .append("city", city)
           .append("state", state)
           .append("country", country);
    
    return builder.toString();
  }
}
