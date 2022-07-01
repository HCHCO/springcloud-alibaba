package com.service.impl;

import com.Mapper.BorrowMapper;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.entity.UserBorrowDetail;
import com.service.BorrowService;
import com.service.client.BookClient;
import com.service.client.UserClient;
import com.sun.deploy.security.BlockedException;
import entity.Book;
import entity.Borrow;
import entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collections;
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


    @Override
    @SentinelResource(value="details",blockHandler = "blocked")
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

    @Override
    public boolean doBorrow(int uid, int bid) {
        if(bookClient.bookRemain(bid)<1)
            throw  new RuntimeException("图书数量不足");
        if(userClient.userRemain(uid)<1)
            throw new RuntimeException("用户借阅量不够");
        if(!bookClient.bookBorrow(bid)){
            throw  new RuntimeException("？error");
        }
        if(mapper.getBorrow(bid,uid)!=null){
            throw new RuntimeException("书被借走了");
        }
        if(mapper.addBorrow(uid,bid)<= 0){
            throw new RuntimeException("录入借阅时出错");
        }
        if(!userClient.userBorrow(uid))
            throw  new RuntimeException("借阅出错");
        return true;
    }

    public UserBorrowDetail getUserBorrowDetailByUid(int uid, BlockedException e){
        return new UserBorrowDetail(null, Collections.emptyList());
    }


}
