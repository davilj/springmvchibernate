package org.davilj.simple.dao;

/**
 * Data access Interface for managing users in
 * data source
 */
import java.util.List;

import org.davilj.simple.model.User;

public interface UserDao {

  User get(Long id);

  void save(User user);

  void delete(User user);

  List<User> findAll();

  User findByUserName(String username);

}
