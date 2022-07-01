package com.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSONObject;
import com.entity.UserBorrowDetail;
import com.service.BorrowService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
public class BorrowController {
    @Resource
    BorrowService service;

    @RequestMapping("/borrow/{uid}")
    @SentinelResource(value = "details",blockHandler = "blocked")
    UserBorrowDetail findUserBorrows(@PathVariable("uid")int uid){
        return service.getUserBorrowDetailByUid(uid);
    }

    @RequestMapping("/test2")
    @SentinelResource(value =" test2",blockHandler = "test")
    String test(@RequestParam("a")String a,
                @RequestParam("b")String b,
                @RequestParam("c")String c){
        System.out.println("hello wolrd");
        return "yes a="+a+"b="+b+"c="+c;

    }

    @RequestMapping("/blocked")
    JSONObject blocked(){
        JSONObject object=new JSONObject();
        object.put("code",400);
        object.put("success",false);
        object.put("message","too fast");
        return object;
    }
    @RequestMapping("/test")
    @SentinelResource(value = "test",
            fallback = "expect",
            exceptionsToIgnore = IOException.class)
    String test(){
        return "test";
    }
    String expect(Throwable t){
        return t.getMessage();
    }


    @RequestMapping("/borrow/take/{uid}/{bid}")
    JSONObject borrow(@PathVariable("uid")int uid,@PathVariable("bid")int bid){
        service.doBorrow(uid,bid);
        JSONObject object=new JSONObject();
        object.put("code",200);
        object.put("success",false);
        object.put("messaeg","借阅");
        return object;
    }
}
