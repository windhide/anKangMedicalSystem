package com.ankang.user.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.userService.User;
import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import com.ankang.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    String redisKey = "user";
    @Autowired
    UserService userService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    UserLevelTypeService userLevelTypeService;

    Map<Integer, UserLevelType> userLevelTypeMap;

    @RequestMapping("select/list")
    public Object queryUserForList() {
        Object cacheData = stringRedisTemplate.opsForValue().get(redisKey);
        if (Objects.equals(cacheData, "") || cacheData == null) {
            return cacheReload();
        }
        return cacheData;
    }

    @RequestMapping("select/{userId}")
    public User queryUserById(@PathVariable("userId") Integer userId) {
        return userLevelTypeInit(userService.getById(userId));
    }

    @RequestMapping("select/UserData")
    public User queryUserByUserData(@RequestBody User user){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userUserName",user.getUserUserName());
        userQueryWrapper.eq("userId",user.getUserId());
        return userService.getOne(userQueryWrapper);
    }

    @RequestMapping("userLogin")
    public User queryUserByLogin(@RequestBody User user){
        return userService.getOne(new QueryWrapper<>(user));
    }

    @RequestMapping("update")
    public boolean updateUserById(@RequestBody User user) {
        if (userService.updateById(user)) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteUserById(@RequestBody User user) {
        if (userService.removeById(user.getUserId())) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertUser(@RequestBody User user) {
        if (userService.save(user)) {
            cacheReload();
            return true;
        }
        return false;
    }

    public Object cacheReload() {
        List<User> userList = userService.list();
        userLevelTypeInit();
        userList.replaceAll(this::userLevelTypeInit);
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSON(userList).toString(), FullConfig.timeout, TimeUnit.SECONDS);
        return userList;
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
