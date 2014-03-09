package org.davilj.simple.service;

import java.util.List;

import org.davilj.simple.model.User;
import org.davilj.simple.web.commands.UserCommand;
import org.davilj.simple.web.vo.UserGrid;

/**
 * Service for managing users
 * 
 * @author danie
 * 
 */
public interface UserService {

  User get(Long id);

  void save(UserCommand userCommand);

  void delete(User user);

  UserGrid findAll();

  void saveAll(UserGrid userGrid);

  void updateWithAll(UserGrid userGrid);

  List<User> listAllUsers();

}
