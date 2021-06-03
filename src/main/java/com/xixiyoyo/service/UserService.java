package com.xixiyoyo.service;

import com.xixiyoyo.domain.User;

import java.util.List;

public interface UserService {

  public List<User> findAllUser();
  public User login(User user);
  public void save(User user);
  public User findInfo(int uid);
  public void changeInfo(User user);
  public User findAllReByUser(int uid);



}
