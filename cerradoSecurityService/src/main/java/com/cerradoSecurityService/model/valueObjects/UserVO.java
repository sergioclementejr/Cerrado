package com.cerradoSecurityService.model.valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class UserVO {
  @Id
  @Column(name="username")
  private String username;
  
  @Column(name="password")
  private String password;
  
  @Column(name="full_name")
  private String name;
  
  @Column(name="role")
  private String role;
  
  @Column(name="enabled")
  private String enabled;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getEnabled() {
    return enabled;
  }

  public void setEnabled(String enabled) {
    this.enabled = enabled;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((enabled == null)? 0: enabled.hashCode());
    result = prime * result + ((name == null)? 0: name.hashCode());
    result = prime * result + ((password == null)? 0: password.hashCode());
    result = prime * result + ((role == null)? 0: role.hashCode());
    result = prime * result + ((username == null)? 0: username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserVO other = (UserVO) obj;
    if (enabled == null) {
      if (other.enabled != null)
        return false;
    }
    else if (!enabled.equals(other.enabled))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    }
    else if (!name.equals(other.name))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    }
    else if (!password.equals(other.password))
      return false;
    if (role == null) {
      if (other.role != null)
        return false;
    }
    else if (!role.equals(other.role))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    }
    else if (!username.equals(other.username))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Usuario [username=" + username + ", password=" + password +
      ", name=" + name + ", role=" + role + ", enabled=" + enabled + "]";
  }
}
