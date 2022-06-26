package com.controller;

import com.service.UserService;
import entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/user/{uid}")
    public User findUserById(@PathVariable("uid")int uid){
        return userService.getUserById(uid);
    }

    @RequestMapping("/user/remain/{uid}")
    public int userRemain(@PathVariable("uid")int uid){
        return userService.getUserBookRemain(uid);
    }
    @RequestMapping("/user/borrow/{uid}")
    public boolean userBorrow(@PathVariable("uid")int uid){
        int remain =userService.getUserBookRemain(uid);
        return userService.updateBookCount(uid,remain-1);
    }
}
