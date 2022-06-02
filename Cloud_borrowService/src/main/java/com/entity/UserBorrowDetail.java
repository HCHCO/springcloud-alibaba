package com.entity;

import entity.Book;
import entity.User;
import lombok.Data;

import java.util.List;


@Data
public class UserBorrowDetail {
    User user;
    List<Book> bookList;

    public UserBorrowDetail(User user, List<Book> bookList) {
            this.user= user;
            this.bookList=bookList;
    }
}
