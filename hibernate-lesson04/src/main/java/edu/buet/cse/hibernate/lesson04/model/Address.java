package edu.buet.cse.hibernate.lesson04.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Address")
public class Address {
  @Id
  @GenericGenerator(name = "generator", strategy = "foreign", parameters = {@Parameter(name="property", value="user")})
  @GeneratedValue(generator = "generator")
  @Column(name = "userId")
  private Long userId;
  
  @Column(name = "street")
  private String street;
  
  @Column(name = "city")
  private String city;
  
  @Column(name = "state")
  private String state;
  
  @Column(name = "country")
  private String country;
  
  @OneToOne
  @PrimaryKeyJoinColumn
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
           .append("userName", user.getUsername())
           .append("street", street)
           .append("city", city)
           .append("state", state)
           .append("country", country);
    
    return builder.toString();
  }
}
