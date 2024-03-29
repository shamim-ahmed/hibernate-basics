package edu.buet.cse.hibernate.lesson09.model;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "Role")
public class Role {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long roleId;
  
  @Column(name = "name", nullable = false)
  private String roleName;
  
  @Column(name = "description", nullable = true)
  private String roleDescription;
  
  @ManyToMany(mappedBy = "roles")
  private Set<User> users = new LinkedHashSet<>();

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
  
  public String getRoleDescription() {
    return roleDescription;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }

  public Set<User> getUsers() {
    return Collections.unmodifiableSet(users);
  }

  public void setUsers(Set<User> users) {
    this.users = users;
  }
  
  public void addUser(User user) {
    users.add(user);
  }
  
  @Override
  public String toString() {
    ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE);
    builder.append("roleId", roleId)
           .append("roleName", roleName)
           .append("roleDescription", roleDescription)
           .append("userCount", users.size());
    
    return builder.toString();
  }
}
