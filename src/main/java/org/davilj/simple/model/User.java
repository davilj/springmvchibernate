package org.davilj.simple.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Users in this services
 * 
 * @author danie
 */
@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = -4060739788760795254L;

  @Id
  @GeneratedValue
  private Long id;

  @NotEmpty
  @Pattern(regexp = "[a-zA-Z0-9]+")
  private String name;

  @NotEmpty
  private String password;

  @Email
  @NotEmpty
  private String email;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + "]";
  }

}
