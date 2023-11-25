package com.example.my.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.my.model.UserDetail;
import com.example.my.service.Userser;
import com.example.my.service.UserserIMPL;

//@Controller
@RestController
//@RequestMapping("/base")
@CrossOrigin (origins = "http://localhost:4200/")

public class UserController {

    @Autowired
    UserserIMPL us;



    @GetMapping("/index")
    public String home() {
        return "index";

    }

    @PostMapping("/saveUser")
    public String register(@RequestBody UserDetail userdatail) {

        us.addUser(userdatail);
        System.out.println("user added");
        return "user added sucessfully";
    }

    @GetMapping("/resetpass")
    public String resetpass() {

        return "resetpass";

    }

    // @RequestMapping("/deleteUser/{id}")
    // public String deleteUser(@PathVariable("id") int id) {
    //     System.out.println(id + " : data deleted successfully ");
    //     us.deleteUser(id);
    //     return "redirect:/";
    // }

     
    @DeleteMapping("/getAllUsers/{email}")
     public String deleteUserByEmail(@PathVariable("email") String email) {
          us.deleteUserByEmail(email);
          return "delete";
     }

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable int id) {
        UserDetail userdetail = us.getUser(id);
        if (userdetail == null) {
            System.out.println("Invalid user");
        } else {
            System.out.println(userdetail.toString());
        }
        return "redirect:/";

    }
    
    @Autowired
    private Userser serv;

    @GetMapping("/getAllUsers") // Specify the endpoint URL
    public List<UserDetail> listUser() {
        return serv.getAllUser();
    }

    // @GetMapping("/getAllUser")
    // public String getAllUser(@ModelAttribute UserDetail userdetail){
    //     List<UserDetail>getAllUser = us.getAllUser();
    //     userdetail.addAttribute("users", userdetail);
    //     //userdetail.forEach(data -> System.out.println(data.toString()));
    //     System.out.println("all user is readable");
    //     return "getAllUser";

    // }



    @Autowired
    private Userser service;

    // @RequestMapping("/resetpass")
    // public String processResetPassword(
    //         @RequestParam("email") String email,
    //         @RequestParam("oldPassword") String oldPassword,
    //         @RequestParam("newPassword") String newPassword) {

    //     UserDetail user = service.findUserByEmail(email);

    //     if (user != null) {
    //         if (user.getPassword().equals(oldPassword)) {
    //             user.setOldPassword(oldPassword);
    //             user.setNewPassword(newPassword);
    //             service.updatePass(user);
    //             return "newpassword";
    //         } else {
    //             return "wrongpass";
    //         }
    //     } else {
    //         return "wrongpass";

    //     }

    // }

    @PostMapping("/getAllUsers/update-password")
    @ResponseBody
    public String processUpdatePassword(@RequestBody UserDetail updateData) {
        String email = updateData.getEmail();
        String oldPassword = updateData.getOldPassword();
        String newPassword = updateData.getNewPassword();

        UserDetail existingUser = service.findUserByEmail(email);

        if (existingUser != null) {
            if (existingUser.getPassword().equals(oldPassword)) {
                // Update the password in the Spring Boot service
                service.updateUserPassword(existingUser, newPassword);
                return "Password updated successfully.";
            } else {
                return "Old password doesn't match.";
            }
        } else {
            return "User not found.";
        }
    }

    @PostMapping("/check-password")
    @ResponseBody
    public boolean checkPassword(@RequestBody Map<String, String> data) {
        String email = data.get("email");
        String oldPassword = data.get("oldPassword");
        UserDetail user = service.findUserByEmail(email);
        return user != null && user.getPassword().equals(oldPassword);
    }

}
