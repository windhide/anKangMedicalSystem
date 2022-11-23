package com.ankang.staff.service.impl;

import com.ankang.pojo.staffService.OperatorType;
import com.ankang.staff.annotation.AutowireRedis;
import com.ankang.staff.mapper.OperatorTypeMapper;
import com.ankang.staff.service.OperatorTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【operator_type】的数据库操作Service实现
 * @createDate 2022-09-14 20:07:57
 */
@Service
public class OperatorTypeServiceImpl extends ServiceImpl<OperatorTypeMapper, OperatorType>
        implements OperatorTypeService {
    @AutowireRedis(targetClass = OperatorType.class)
    @Override
    public List<OperatorType> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(OperatorType entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
    
    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(OperatorType entity) {
        return super.save(entity);
    }
}




