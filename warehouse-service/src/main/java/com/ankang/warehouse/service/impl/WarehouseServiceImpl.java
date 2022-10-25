package com.ankang.warehouse.service.impl;

import com.ankang.pojo.warehouseService.Warehouse;
import com.ankang.warehouse.annotation.AutowireRedis;
import com.ankang.warehouse.mapper.WarehouseMapper;
import com.ankang.warehouse.service.WarehouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WindHide
 * @description 针对表【warehouse】的数据库操作Service实现
 * @createDate 2022-09-14 20:34:24
 */
@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse>
    implements WarehouseService{
    @AutowireRedis(targetClass = Warehouse.class)
    @Override
    public List<Warehouse> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(Warehouse entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(Warehouse entity) {
        return super.removeById(entity);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(Warehouse entity) {
        return super.save(entity);
    }
}




