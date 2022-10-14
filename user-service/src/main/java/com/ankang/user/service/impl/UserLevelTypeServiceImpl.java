package com.ankang.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.userService.UserLevelType;
import com.ankang.user.mapper.UserLevelTypeMapper;
import com.ankang.user.service.UserLevelTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author WindHide
 * @description 针对表【user_level_type】的数据库操作Service实现
 * @createDate 2022-09-14 20:08:35
 */
@Service
public class UserLevelTypeServiceImpl extends ServiceImpl<UserLevelTypeMapper, UserLevelType>
        implements UserLevelTypeService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public List<UserLevelType> list() {
        String className = UserLevelType.class.getSimpleName();
        if(stringRedisTemplate.opsForValue().get(className)==null){
            List<?> cache = super.list();
            stringRedisTemplate.opsForValue().set(className, JSON.toJSONString(cache), FullConfig.timeout, TimeUnit.MINUTES);
            return super.list();
        }
        return JSON.parseArray(stringRedisTemplate.opsForValue().get(className), UserLevelType.class);

    }
}




