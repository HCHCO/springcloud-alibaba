package com.service.impl;

import com.entity.User;
import com.mapper.UserMappers;
import com.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMappers userMappers;
    @Override
    public User getUserById(int uid) {
        return userMappers.getUserById(uid);
    }
}
