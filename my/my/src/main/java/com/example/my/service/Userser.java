package com.example.my.service;

import java.util.List;

import com.example.my.model.UserDetail;

public interface Userser {
  public void addUser(UserDetail userdatail);

  // public UserDetail resetPass(UserDetail user);

  // public void deleteUser(int id);

  public void deleteUserByEmail(String email);
  public UserDetail getUser(int id);

  public List<UserDetail> getAllUser();

   void updateUserPassword(UserDetail user, String newPassword);
  // public void updatePass(UserDetail user);
  public UserDetail findUserByEmail(String email);

}
