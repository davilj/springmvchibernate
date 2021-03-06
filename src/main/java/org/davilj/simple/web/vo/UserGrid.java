package org.davilj.simple.web.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.davilj.simple.model.User;
import org.davilj.simple.web.commands.UserCommand;

public class UserGrid {

  @Valid
  private Map<Long, UserCommand> userMap;

  public UserGrid() {
  }

  public UserGrid(List<User> users) {
    userMap = new LinkedHashMap<Long, UserCommand>();
    for (User user : users)
      userMap.put(user.getId(), new UserCommand(user));
  }

  public List<User> getUsers() {
    List<User> users = new ArrayList<User>();
    for (UserCommand userCommand : userMap.values()) {
      users.add(userCommand.toUser());
    }
    return users;
  }

  public Map<Long, UserCommand> getUserMap() {
    return userMap;
  }

  public void setUserMap(Map<Long, UserCommand> users) {
    this.userMap = users;
  }

  public boolean haveUsers() {
    if (userMap == null)
      return false;
    return userMap.size() > 0;
  }

}
