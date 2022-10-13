package com.ankang.user.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.userService.User;
import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import com.ankang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    String redisKey = "user";
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserLevelTypeService userLevelTypeService;


    Map<Integer, UserLevelType> userLevelTypeMap;

    @RequestMapping("select/list")
    public Object queryUserForList() {
        if (Objects.equals(redisTemplate.opsForValue().get(redisKey), "")) {
            cacheReload();
        }
        return redisTemplate.opsForValue().get(redisKey);
    }

    @RequestMapping("select/{userId}")
    public User queryUserById(@PathVariable("userId") Integer userId) {
        return userLevelTypeInit(userService.getById(userId));
    }

    @RequestMapping("update")
    public boolean updateUserById(@RequestBody User user) {
        return userService.updateById(user);
    }

    @RequestMapping("remove")
    public boolean deleteUserById(@RequestBody User user) {
        return userService.removeById(user.getUserId());
    }

    @RequestMapping("insert")
    public boolean insertUser(@RequestBody User user) {
        return userService.save(user);
    }

    public void cacheReload() {
        List<User> userList = userService.list();
        userLevelTypeInit();
        userList.replaceAll(this::userLevelTypeInit);
        redisTemplate.opsForValue().set(redisKey, JSON.toJSON(userList), FullConfig.timeout);
    }

    /**
     * 载入用户等级
     */
    public void userLevelTypeInit() {
        userLevelTypeMap = userLevelTypeService.list().stream().collect(Collectors.toMap(UserLevelType::getUserLevelTypeId, userLevelType -> userLevelType));
    }

    /**
     * 植入用户等级
     *
     * @param user
     * @return User
     */
    public User userLevelTypeInit(User user) {
        UserLevelType tempUserLevelType = userLevelTypeMap.get(user.getUserLevelTypeId());
        user.setUserLevelType(tempUserLevelType);
        return user;
    }

}
