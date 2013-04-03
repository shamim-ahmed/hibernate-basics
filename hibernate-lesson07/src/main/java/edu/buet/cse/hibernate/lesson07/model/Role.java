package edu.buet.cse.hibernate.lesson07.model;

import java.util.Collections;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Role {
  private Long roleId;
  private String roleName;
  private Set<User> users;

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public Set<User> getUsers() {
    return Collections.unmodifiableSet(users);
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("roleId", roleId)
           .append("roleName", roleName)
           .append("userCount", users.size());
    
    return builder.toString();
  }
}