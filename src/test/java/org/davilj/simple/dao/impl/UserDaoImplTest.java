package org.davilj.simple.dao.impl;

import java.util.List;

import org.davilj.simple.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserDaoImplTest extends DaoTest {

  @Autowired
  UserDaoImpl userDaoImpl;

  @Test
  public void all_fields_are_persisted() {
    User user = new User();
    user.setName("Name1");
    user.setEmail("simon@domain.com");
    user.setPassword("XXX");

    userDaoImpl.save(user);
    List<User> users = userDaoImpl.findAll();
    Assert.assertEquals("Name1", users.get(0).getName());
    Assert.assertEquals("simon@domain.com", users.get(0).getEmail());
    userDaoImpl.delete(user);
  }

}
