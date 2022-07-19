package com.controller;

import entity.Book;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RefreshScope
public class BookController {
    @Resource
    BookService bookService;
    @Value("${test.fkd}")
    String test;
    @RequestMapping("/book/{bid}")
    Book findBookById(@PathVariable("bid") int bid, HttpSession session){
        System.out.println("hello world");
        System.out.println(test);
        SecurityContext context = (SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");

        System.out.println(context.getAuthentication());
        return bookService.getBookById(bid);
    }

}
