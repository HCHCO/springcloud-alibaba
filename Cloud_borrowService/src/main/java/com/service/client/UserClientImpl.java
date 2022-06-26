package com.service.client;

import entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient{
    @Override
    public User getUserById(int uid) {
        User user = new User();
        user.setName("fallback");
        return user;
    }
}
