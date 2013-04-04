package edu.buet.cse.hibernate.lesson04.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "User")
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;
  
  @Column(name = "name", nullable = false)
  private String username;
  
  @Column(name = "createdDate", nullable = false)
  private Date createdDate;
  
  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  private Address address;
  
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("userId", userId)
           .append("username", username)
           .append("createdDate", createdDate)
           .append("address", String.format("%s, %s, %s, %s", address.getStreet(), address.getCity(), address.getState(), address.getCountry()));
    
    return builder.toString();
  }
}
