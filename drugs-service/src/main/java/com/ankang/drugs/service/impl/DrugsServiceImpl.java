package com.ankang.drugs.service.impl;

import com.ankang.drugs.annotation.AutowireRedis;
import com.ankang.drugs.mapper.DrugsMapper;
import com.ankang.drugs.service.DrugsService;
import com.ankang.pojo.drugsService.Drugs;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【drugs】的数据库操作Service实现
 * @createDate 2022-09-14 20:06:53
 */
@Service
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs> implements DrugsService {
    @AutowireRedis(targetClass = Drugs.class)
    @Override
    public List<Drugs> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Drugs entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Drugs entity) {
        return super.save(entity);
    }
}




