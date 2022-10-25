package com.ankang.drugs.service.impl;

import com.ankang.drugs.annotation.AutowireRedis;
import com.ankang.drugs.mapper.DrugsUnitMapper;
import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.DrugsUnit;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WindHide
 * @description 针对表【drugs_unit】的数据库操作Service实现
 * @createDate 2022-09-14 20:06:53
 */
@Service
public class DrugsUnitServiceImpl extends ServiceImpl<DrugsUnitMapper, DrugsUnit>
        implements DrugsUnitService {
    @AutowireRedis(targetClass = DrugsUnit.class)
    @Override
    public List<DrugsUnit> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(DrugsUnit entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(DrugsUnit entity) {
        return super.removeById(entity);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(DrugsUnit entity) {
        return super.save(entity);
    }
}




