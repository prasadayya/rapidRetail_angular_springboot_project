package com.example.my.model;

//import java.util.List;

//import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// @Autowired
// Userser service;

@Entity
@Table(name = "userdata")
public class UserDetail {
    @Id
    @GeneratedValue
    private int id;
    @Column(name = "username")
    private String name;
    private String email;
    private String phone;
    private String password;
    private String newPassword;
    private String oldPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public UserDetail() {

    }

    // public String getName() {
    // return name;
    // }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDetail [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
                + password + ", newPassword=" + newPassword + ", oldPassword=" + oldPassword + "]";
    }

    // public void addAttribute(String string, UserDetail userdetail) {
    // }

    

    
    

}
