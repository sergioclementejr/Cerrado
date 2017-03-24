package com.cerradoSic.model.valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
  @Id
  @Column(name="idt_user")
  private String id;
  
  @Column(name="psw_user")
  private String password;
  
  @Column(name="nme_user")
  private String nome;
  
  @Column(name="email_user")
  private String email;
  
  @Column(name="role_user")
  private String role;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((email == null)? 0: email.hashCode());
    result = prime * result + ((id == null)? 0: id.hashCode());
    result = prime * result + ((nome == null)? 0: nome.hashCode());
    result = prime * result + ((password == null)? 0: password.hashCode());
    result = prime * result + ((role == null)? 0: role.hashCode());
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
    Usuario other = (Usuario) obj;
    if (email == null) {
      if (other.email != null)
        return false;
    }
    else if (!email.equals(other.email))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    }
    else if (!id.equals(other.id))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    }
    else if (!nome.equals(other.nome))
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
    return true;
  }

  @Override
  public String toString() {
    return "Usuario [id=" + id + ", password=" + password + ", nome=" +
      nome + ", email=" + email + ", role=" + role + "]";
  }
}
