package org.davilj.simple.web.commands;

import org.davilj.simple.model.User;
import org.davilj.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OwnerConverter implements Converter<String, User> {

  @Autowired
  UserService userService;

  @Override
  public User convert(String source) {
    for (User user : userService.listAllUsers()) {
      if (user.getName().equals(source))
        return user;
    }
    return null;
  }

}
