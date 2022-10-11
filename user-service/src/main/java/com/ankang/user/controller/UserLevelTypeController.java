package com.ankang.user.controller;

import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("update")
    public boolean updateUserLevelTypeById(@RequestBody UserLevelType userLevelType) {
        return userLevelTypeService.updateById(userLevelType);
    }

    @RequestMapping("remove")
    public boolean deleteUserLevelTypeById(@RequestBody UserLevelType userLevelType) {
        return userLevelTypeService.removeById(userLevelType.getUserLevelTypeId());
    }

    @RequestMapping("insert")
    public boolean insertUserLevelType(@RequestBody UserLevelType userLevelType) {
        return userLevelTypeService.save(userLevelType);
    }
}
