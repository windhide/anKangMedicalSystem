package com.ankang.staff.service.impl;

import com.ankang.pojo.staffService.Staff;
import com.ankang.staff.annotation.AutowireRedis;
import com.ankang.staff.mapper.StaffMapper;
import com.ankang.staff.service.StaffService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
* @author WindHide
* @description 针对表【staff】的数据库操作Service实现
* @createDate 2022-09-15 18:57:43
*/
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff> implements StaffService{
    @AutowireRedis(targetClass = Staff.class)
    @Override
    public List<Staff> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Staff entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Staff entity) {
        return super.save(entity);
    }
}




