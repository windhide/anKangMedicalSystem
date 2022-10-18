package com.ankang.user.service.impl;

import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.annotation.AutowireRedis;
import com.ankang.user.mapper.UserLevelTypeMapper;
import com.ankang.user.service.UserLevelTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WindHide
 * @description 针对表【user_level_type】的数据库操作Service实现
 * @createDate 2022-09-14 20:08:35
 */
@Service
public class UserLevelTypeServiceImpl extends ServiceImpl<UserLevelTypeMapper, UserLevelType>
        implements UserLevelTypeService {

    @AutowireRedis(targetClass = UserLevelType.class)
    @Override
    public List<UserLevelType> list() {
        return super.list();
    }

    @AutowireRedis
    @Override
    public boolean updateById(UserLevelType entity) {
        return super.updateById(entity);
    }

    @AutowireRedis
    @Override
    public boolean removeById(UserLevelType entity) {
        return super.removeById(entity);
    }

    @AutowireRedis
    @Override
    public boolean save(UserLevelType entity) {
        return super.save(entity);
    }
}




