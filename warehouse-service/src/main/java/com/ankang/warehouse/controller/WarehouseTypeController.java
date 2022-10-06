package com.ankang.warehouse.controller;

import com.ankang.pojo.warehouseService.WarehouseType;
import com.ankang.warehouse.service.WarehouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("warehouseType")
public class WarehouseTypeController {
    @Autowired
    WarehouseTypeService warehouseTypeService;

    @RequestMapping("select/list")
    public List<WarehouseType> queryWarehouseTypeForList() {
        return warehouseTypeService.list();
    }

    @RequestMapping("select/{warehouseTypeId}")
    public WarehouseType queryWarehouseTypeById(@PathVariable("warehouseTypeId") Integer warehouseTypeId) {
        return warehouseTypeService.getById(warehouseTypeId);
    }

    @RequestMapping("update")
    public boolean updateWarehouseTypeById(@RequestBody WarehouseType warehouseType) {
        return warehouseTypeService.updateById(warehouseType);
    }

    @RequestMapping("remove")
    public boolean deleteWarehouseTypeById(@RequestBody WarehouseType warehouseType) {
        return warehouseTypeService.removeById(warehouseType.getWarehouseTypeId());
    }

    @RequestMapping("insert")
    public boolean insertWarehouseType(@RequestBody WarehouseType warehouseType) {
        return warehouseTypeService.save(warehouseType);
    }
}
