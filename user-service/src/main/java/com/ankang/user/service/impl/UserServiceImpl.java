package com.ankang.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ankang.user.pojo.User;
import com.ankang.user.service.UserService;
import com.ankang.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author WindHide
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-09-14 18:58:07
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




