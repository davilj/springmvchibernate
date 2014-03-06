package org.davilj.simple.web;

import org.davilj.simple.model.User;

public class UserCommand extends User {

  private static final long serialVersionUID = -4686811929329857418L;

  private Boolean selected = false;

  public UserCommand() {
  }

  public UserCommand(User user) {
    setId(user.getId());
    setName(user.getName());
    setPassword(user.getPassword());
    setEmail(user.getEmail());

  }

  public User toUser() {
    User user = new User();
    user.setId(getId());
    user.setName(getName());
    user.setPassword(getPassword());
    user.setEmail(getEmail());
    return user;
  }

  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean changed) {
    this.selected = changed;
  }

  @Override
  public String toString() {
    return "UserCommand [selected=" + selected + ", getId()=" + getId() + ", getName()=" + getName()
        + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + "]";
  }

}