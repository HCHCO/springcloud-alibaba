package com.service.client;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import entity.User;
import org.apache.ibatis.reflection.ExceptionUtil;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="user-service",fallback = UserClientImpl.class)
public interface UserClient {
    @RequestMapping("/user/{uid}")
    User getUserById(@PathVariable("uid")int uid);
}
