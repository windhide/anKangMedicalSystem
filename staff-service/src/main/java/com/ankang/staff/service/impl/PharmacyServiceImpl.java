package com.ankang.staff.service.impl;

import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.staff.annotation.AutowireRedis;
import com.ankang.staff.mapper.PharmacyMapper;
import com.ankang.staff.service.PharmacyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【pharmacy】的数据库操作Service实现
 * @createDate 2022-09-14 20:07:57
 */
@Service
public class PharmacyServiceImpl extends ServiceImpl<PharmacyMapper, Pharmacy>
    implements PharmacyService{
    @AutowireRedis(targetClass = Pharmacy.class)
    @Override
    public List<Pharmacy> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Pharmacy entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Pharmacy entity) {
        return super.save(entity);
    }
}




