package com.service.impl;

import com.Mapper.BorrowMapper;
import com.entity.UserBorrowDetail;
import com.service.BorrowService;
import com.service.client.BookClient;
import com.service.client.UserClient;
import entity.Book;
import entity.Borrow;
import entity.User;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper mapper;
    @Resource
    UserClient userClient;
    @Resource
    BookClient bookClient;

    @Resource
    OAuth2RestTemplate template;
    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrows=mapper.getBorrowByUid(uid);
        //RestTemplate template = new RestTemplate();
        //User user = template.getForObject("http://localhost:1236/user/"+uid,User.class);
        User user =userClient.getUserById(uid);
        List<Book> bookList= borrows
                .stream()
                //.map(b->template.getForObject("http://localhost:1234/book/"+b.getBid(),Book.class))
                .map(b->bookClient.getBookById(b.getBid()))
                .collect(Collectors.toList());
        return new UserBorrowDetail(user,bookList);
    }
}
