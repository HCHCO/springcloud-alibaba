package com.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.entity.UserBorrowDetail;
import com.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    @SentinelResource("getBorrow")
    UserBorrowDetail findUserBorrows(@PathVariable("uid")int uid){
        return service.getUserBorrowDetailByUid(uid);
    }
    @RequestMapping("/borrow2/{uid}")
    @SentinelResource("getBorrow")
    UserBorrowDetail test(@PathVariable("uid")int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/blocked")
    JSONObject blocked(){
        JSONObject object=new JSONObject();
        object.put("code",400);
        object.put("success",false);
        object.put("message","too fast");
        return object;
    }
}
