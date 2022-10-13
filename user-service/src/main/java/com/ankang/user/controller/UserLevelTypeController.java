package com.ankang.user.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("userLevelType")
public class UserLevelTypeController {
    String redisKey = "userLevelType";
    @Autowired
    UserLevelTypeService userLevelTypeService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("select/list")
    public Object queryUserLevelTypeForList() {
        Object cacheData = stringRedisTemplate.opsForValue().get(redisKey);
        if (Objects.equals(cacheData, "") || cacheData == null) {
            return cacheReload();
        }
        return cacheData;
    }

    @RequestMapping("select/{userLevelTypeId}")
    public UserLevelType queryUserLevelTypeById(@PathVariable("userLevelTypeId") Integer userLevelTypeId) {
        return userLevelTypeService.getById(userLevelTypeId);
    }

    @RequestMapping("update")
    public boolean updateUserLevelTypeById(@RequestBody UserLevelType userLevelType) {
        if (userLevelTypeService.updateById(userLevelType)) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteUserLevelTypeById(@RequestBody UserLevelType userLevelType) {
        if (userLevelTypeService.removeById(userLevelType.getUserLevelTypeId())) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertUserLevelType(@RequestBody UserLevelType userLevelType) {
        if (userLevelTypeService.save(userLevelType)) {
            cacheReload();
            return true;
        }
        return false;
    }

    public Object cacheReload() {
        List<UserLevelType> userLevelTypeList = userLevelTypeService.list();
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSON(userLevelTypeList).toString(), FullConfig.timeout, TimeUnit.SECONDS);
        return userLevelTypeList;
    }

}
