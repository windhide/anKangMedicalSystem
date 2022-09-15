package com.ankang.user.controller;

import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("userLevelType")
public class UserLevelTypeController {
    @Autowired
    UserLevelTypeService userLevelTypeService;

    @RequestMapping("select/list")
    public List<UserLevelType> queryUserLevelTypeForList() {
        return userLevelTypeService.list();
    }

    @RequestMapping("select/{userLevelTypeId}")
    public UserLevelType queryUserLevelTypeById(@PathVariable("userLevelTypeId") Integer userLevelTypeId) {
        return userLevelTypeService.getById(userLevelTypeId);
    }

    @RequestMapping("update/{userLevelType}")
    public boolean updateUserLevelTypeById(@PathVariable("userLevelType") UserLevelType userLevelType) {
        return userLevelTypeService.updateById(userLevelType);
    }

    @RequestMapping("remove/{userLevelTypeId}")
    public boolean deleteUserLevelTypeById(@PathVariable("userLevelTypeId") Integer userLevelTypeId) {
        return userLevelTypeService.removeById(userLevelTypeId);
    }

    @RequestMapping("insert/{userLevelType}")
    public boolean insertUserLevelType(@PathVariable("userLevelType") UserLevelType userLevelType) {
        return userLevelTypeService.save(userLevelType);
    }
}
