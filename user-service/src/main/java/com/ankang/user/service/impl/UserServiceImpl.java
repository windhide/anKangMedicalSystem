package com.ankang.user.service.impl;

import com.ankang.pojo.userService.User;
import com.ankang.user.mapper.UserMapper;
import com.ankang.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author WindHide
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-09-14 22:29:42
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




