package com.ankang.user.service.impl;

import com.ankang.pojo.userService.User;
import com.ankang.user.annotation.AutowireRedis;
import com.ankang.user.mapper.UserMapper;
import com.ankang.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-09-14 22:29:42
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @AutowireRedis(targetClass = User.class)
    @Override
    public List<User> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(User entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }


}




