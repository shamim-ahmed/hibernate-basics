package edu.buet.cse.hibernate.lesson09.model;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
  
  @ManyToMany
  @JoinTable(name = "User_Role", joinColumns = {@JoinColumn(name = "user_id", nullable = false)},
  inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false)})
  private Set<Role> roles = new LinkedHashSet<>();

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
  
  public Set<Role> getRoles() {
    return Collections.unmodifiableSet(roles);
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
  
  public void addRole(Role role) {
    roles.add(role);
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("userId", userId)
           .append("username", username)
           .append("createdDate", createdDate)
           .append("roleCount", roles.size());

    return builder.toString();
  }
}
