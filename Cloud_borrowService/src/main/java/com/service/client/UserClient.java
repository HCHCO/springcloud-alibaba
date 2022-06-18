package com.service.client;

import entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user-service")
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid")int uid);
}
