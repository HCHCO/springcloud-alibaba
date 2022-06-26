package com.service;


import entity.Book;

public interface BookService {
    Book getBookById(int bid);
    int getBookRemain(int bid);
    boolean updateBookCount(int bid,int count);
}
