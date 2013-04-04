package edu.buet.cse.hibernate.lesson07.model;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User {
  private Long userId;
  private String username;
  private Date createdDate;
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
