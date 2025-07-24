package com.summer.library.controller;

import com.summer.library.dao.UserDAO;
import com.summer.library.models.Book;
import com.summer.library.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/userApi")
public class UserController {

    public final UserDAO userDao;
    {
        try {
            userDao = new UserDAO();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/Users")
    public ArrayList<User> getUser(){
        return userDao.getUser();
    }

    @PostMapping("/Users")
    public boolean storeUser(@RequestBody User user){
        return userDao.insertUser(user);
    }

    @GetMapping("/user/{userID}")
    public User oneUser(@PathVariable int userID){
        return userDao.getUserInfo(userID);
    }

    @PutMapping("/updateUser")
    public String updateUser(@RequestParam int userID, @RequestParam int contact) {
        userDao.updateUserDetail(userID, contact);
        return "Updated";
    }

    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable int userID){
        if(userDao.deleteUserDetail(userID)){
            return "deleted";
        }
        else {
            return "failed to delete";
        }
    }
}
