package com.ankang.clients;

import com.ankang.pojo.userService.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-service",contextId = "userService")
public interface UserCilent {
    @RequestMapping("user/userLogin")
    User queryUserByLogin(@RequestBody User user);
}
