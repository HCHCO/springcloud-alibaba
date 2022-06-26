package com.service.Impl;

import com.Mapper.BookMapper;
import com.service.BookService;
import entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;
    @Override
    public Book getBookById(int bid) {
        return bookMapper.getBookById(bid);
    }

    @Override
    public int getBookRemain(int bid) {
        return bookMapper.getBookRemain(bid);
    }

    @Override
    public boolean updateBookCount(int bid,int count) {
        return bookMapper.setRemain(bid,count-1)>0;
    }
}
