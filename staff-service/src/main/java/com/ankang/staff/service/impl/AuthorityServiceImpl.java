package com.ankang.staff.service.impl;

import com.ankang.pojo.staffService.Authority;
import com.ankang.staff.annotation.AutowireRedis;
import com.ankang.staff.mapper.AuthorityMapper;
import com.ankang.staff.service.AuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【authority】的数据库操作Service实现
 * @createDate 2022-09-14 20:07:57
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority>
    implements AuthorityService{
    @AutowireRedis(targetClass = Authority.class)
    @Override
    public List<Authority> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Authority entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Authority entity) {
        return super.save(entity);
    }
}




