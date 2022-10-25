package com.ankang.warehouse.service.impl;

import com.ankang.pojo.warehouseService.WarehouseType;
import com.ankang.warehouse.annotation.AutowireRedis;
import com.ankang.warehouse.mapper.WarehouseTypeMapper;
import com.ankang.warehouse.service.WarehouseTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WindHide
 * @description 针对表【warehouse_type】的数据库操作Service实现
 * @createDate 2022-09-14 20:09:12
 */
@Service
public class WarehouseTypeServiceImpl extends ServiceImpl<WarehouseTypeMapper, WarehouseType>
        implements WarehouseTypeService {
    @AutowireRedis(targetClass = WarehouseType.class)
    @Override
    public List<WarehouseType> list() {
        return super.list();
    }

    @AutowireRedis(operation = "update")
    @Override
    public boolean updateById(WarehouseType entity) {
        return super.updateById(entity);
    }

    @AutowireRedis(operation = "remove")
    @Override
    public boolean removeById(WarehouseType entity) {
        return super.removeById(entity);
    }

    @AutowireRedis(operation = "insert")
    @Override
    public boolean save(WarehouseType entity) {
        return super.save(entity);
    }
}




