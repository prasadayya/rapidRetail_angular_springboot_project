package com.example.my.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.my.model.UserDetail;
import com.example.my.repository.UserRepo;

@Service
public class UserserIMPL implements Userser {
    @Autowired
    UserRepo obj;

    public UserserIMPL() {
    }

    @Override
    public void addUser(UserDetail userdatail) {
        obj.save(userdatail);
    }

    // @Override
    // public UserDetail resetPass(UserDetail user){
    // UserDetail r = obj.save(user);

    // return r;
    // }

    // @Override
    // public void deleteUser(int id) {
    //     obj.deleteById(id);
    // }

    @Override
    public void deleteUserByEmail(String email) {
        List<UserDetail> users = obj.findAll(); // Fetch all users
        List<UserDetail> usersToDelete = users.stream()
                .filter(user -> email.equals(user.getEmail()))
                .collect(Collectors.toList());

        if (!usersToDelete.isEmpty()) {
            // Assuming you want to delete all users with the specified email
            obj.deleteAll(usersToDelete);
        }
    }

    @Override
    public UserDetail getUser(int id) {
        return obj.findById(id).orElse(null);
    }

    // @Override
    // public void updatePass(UserDetail user) {
    //     user.setPassword(user.getNewPassword());
    //     obj.save(user);

    // }

    @Override
    public void updateUserPassword(UserDetail user, String newPassword) {
        System.out.println("Before Update: " + user); // Log the user object before update

        if (newPassword != null && !newPassword.isEmpty()) {
            // Update the 'password' field with the new password
            user.setPassword(newPassword);

            // Clear the 'newPassword' and 'oldPassword' fields
            user.setNewPassword(null);
            user.setOldPassword(null);

            obj.save(user);

            System.out.println("After Update: " + user); // Log the user object after update
        } else {
            System.out.println("No new password provided. Skipping update.");
        }
    }

    public UserDetail findUserByEmail(String email) {
        return obj.findByEmail(email);
    }
   
   
    @Override
    public List<UserDetail> getAllUser(){
        return obj.findAll();
    }

}
