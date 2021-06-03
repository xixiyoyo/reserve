package com.xixiyoyo.service.impl;


import com.xixiyoyo.dao.UserDao;
import com.xixiyoyo.domain.User;
import com.xixiyoyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {

  @Autowired
  private UserDao userDao;
  @Override
  public List<User> findAllUser() {
    return userDao.findAllUser();
  }

  @Override
  public User login(User user) {
    User user1 = userDao.login(user);
    if(user1 != null){
      return user1;
    }
    return null;
  }

  @Override
  public void save(User user) {
    userDao.addUser(user);

  }

  @Override
  public User findInfo(int uid) {
    return userDao.findUserByUid(uid);
  }

  @Override
  public void changeInfo(User user) {
    userDao.updateUser(user);
  }

  @Override
  public User findAllReByUser(int uid) {
    return userDao.findReByUser(uid);
  }

}
