package org.davilj.simple.service.impl;

import org.davilj.simple.dao.UserDao;
import org.davilj.simple.model.User;
import org.davilj.simple.service.UserService;
import org.davilj.simple.web.UserCommand;
import org.davilj.simple.web.UserController;
import org.davilj.simple.web.UserGrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
  final static Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired
  UserDao userDao;

  @Transactional(readOnly = true)
  public User get(Long id) {
    return userDao.get(id);
  }

  @Transactional
  public void delete(User user) {
    userDao.delete(user);
  }

  @Transactional(readOnly = true)
  public UserGrid findAll() {
    return new UserGrid(userDao.findAll());
  }

  @Transactional
  public void save(UserCommand userCommand) {
    log.debug("User: " + userCommand.toUser());
    userDao.save(userCommand.toUser());
  }

  @Transactional
  public void saveAll(UserGrid userGrid) {
    for (User user : userGrid.getUsers())
      userDao.save(user);
  }

  @Transactional(readOnly = true)
  public void updateWithAll(UserGrid userGrid) {
    UserGrid allUsers = findAll();
    allUsers.getUserMap().putAll(userGrid.getUserMap());
    userGrid.setUserMap(allUsers.getUserMap());
  }
}