package com.ankang.warehouse.service.impl;

import com.ankang.pojo.warehouseService.WarehouseStaffRecord;
import com.ankang.warehouse.annotation.AutowireRedis;
import com.ankang.warehouse.mapper.WarehouseStaffRecordMapper;
import com.ankang.warehouse.service.WarehouseStaffRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author WindHide
 * @description 针对表【warehouse_staff_record】的数据库操作Service实现
 * @createDate 2022-09-14 20:09:12
 */
@Service
public class WarehouseStaffRecordServiceImpl extends ServiceImpl<WarehouseStaffRecordMapper, WarehouseStaffRecord>
        implements WarehouseStaffRecordService {
    @AutowireRedis(targetClass = WarehouseStaffRecord.class)
    @Override
    public List<WarehouseStaffRecord> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(WarehouseStaffRecord entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(WarehouseStaffRecord entity) {
        return super.save(entity);
    }
}




