package com.ankang.warehouse.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.warehouseService.WarehouseType;
import com.ankang.warehouse.service.WarehouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("warehouseType")
public class WarehouseTypeController {
    String redisKey = "warehouseType";
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    WarehouseTypeService warehouseTypeService;

    @RequestMapping("select/list")
    public Object queryWarehouseTypeForList() {
        return warehouseTypeService.list();
    }

    @RequestMapping("select/{warehouseTypeId}")
    public WarehouseType queryWarehouseTypeById(@PathVariable("warehouseTypeId") Integer warehouseTypeId) {
        return warehouseTypeService.getById(warehouseTypeId);
    }

    @RequestMapping("update")
    public boolean updateWarehouseTypeById(@RequestBody WarehouseType warehouseType) {
        if (warehouseTypeService.updateById(warehouseType)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteWarehouseTypeById(@RequestBody WarehouseType warehouseType) {
        if (warehouseTypeService.removeById(warehouseType.getWarehouseTypeId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertWarehouseType(@RequestBody WarehouseType warehouseType) {
        if (warehouseTypeService.save(warehouseType)) {
            return true;
        }
        return false;
    }
}
