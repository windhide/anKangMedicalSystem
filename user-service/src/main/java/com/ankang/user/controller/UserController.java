package com.ankang.user.controller;

import com.ankang.pojo.userService.User;
import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.service.UserLevelTypeService;
import com.ankang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
