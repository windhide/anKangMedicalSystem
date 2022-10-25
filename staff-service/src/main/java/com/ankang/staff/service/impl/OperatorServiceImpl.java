package com.ankang.staff.service.impl;

import com.ankang.pojo.staffService.Operator;
import com.ankang.staff.annotation.AutowireRedis;
import com.ankang.staff.mapper.OperatorMapper;
import com.ankang.staff.service.OperatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WindHide
 * @description 针对表【operator】的数据库操作Service实现
 * @createDate 2022-09-14 20:07:57
 */
@Service
public class OperatorServiceImpl extends ServiceImpl<OperatorMapper, Operator>
    implements OperatorService{
    @AutowireRedis(targetClass = Operator.class)
    @Override
    public List<Operator> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Operator entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Operator entity) {
        return super.removeById(entity);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Operator entity) {
        return super.save(entity);
    }
}




