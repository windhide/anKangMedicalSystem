package com.ankang.user.controller;

import com.ankang.pojo.userService.User;
import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import com.ankang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserLevelTypeService userLevelTypeService;

    Map<Integer, UserLevelType> userLevelTypeMap;

    @RequestMapping("select/list")
    public List<User> queryUserForList() {
        List<User> userList = userService.list();
        userLevelTypeInit();
        userList.replaceAll(this::userLevelTypeInit);
        return userList;
    }

    @RequestMapping("select/{userId}")
    public User queryUserById(@PathVariable("userId") Integer userId) {
        return userLevelTypeInit(userService.getById(userId));
    }

    @RequestMapping("update/{user}")
    public boolean updateUserById(@PathVariable("user") User user) {
        return userService.updateById(user);
    }

    @RequestMapping("remove/{userId}")
    public boolean deleteUserById(@PathVariable("userId") Integer userId) {
        return userService.removeById(userId);
    }

    @RequestMapping("insert/{user}")
    public boolean insertUser(@PathVariable("user") User user) {
        return userService.save(user);
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
