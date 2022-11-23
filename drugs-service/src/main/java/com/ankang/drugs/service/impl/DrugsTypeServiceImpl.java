package com.ankang.drugs.service.impl;

import com.ankang.drugs.annotation.AutowireRedis;
import com.ankang.drugs.mapper.DrugsTypeMapper;
import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.pojo.drugsService.DrugsType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【drugs_type】的数据库操作Service实现
 * @createDate 2022-09-14 20:06:53
 */
@Service
public class DrugsTypeServiceImpl extends ServiceImpl<DrugsTypeMapper, DrugsType>
        implements DrugsTypeService {
    @AutowireRedis(targetClass = DrugsType.class)
    @Override
    public List<DrugsType> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(DrugsType entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(DrugsType entity) {
        return super.save(entity);
    }
}




