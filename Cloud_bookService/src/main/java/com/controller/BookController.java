package com.controller;

import entity.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class BookController {
    @Resource
    BookService bookService;
    @Value("${test.fkd}")
    String test;
    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid){
        System.out.println("hello world");
        //System.out.println(test);
        return bookService.getBookById(bid);
    }

}
