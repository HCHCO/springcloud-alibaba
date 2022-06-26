package com.service;


import entity.User;

public interface UserService {
    User getUserById(int uid);

    int getUserBookRemain(int uid);

    boolean updateBookCount(int uid,int count);
}
