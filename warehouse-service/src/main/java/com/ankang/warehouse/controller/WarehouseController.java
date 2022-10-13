package com.ankang.warehouse.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.clients.DrugsClient;
import com.ankang.clients.PharmacyClient;
import com.ankang.clients.StaffClient;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.pojo.warehouseService.Warehouse;
import com.ankang.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {

    String redisKey = "warehouse";

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    WarehouseService warehouseService;

    @Autowired
    StaffClient staffClient;

    @Autowired
    DrugsClient drugsClient;

    @Autowired
    PharmacyClient pharmacyClient;

    Map<Integer, Drugs> drugsMap;

    Map<Integer, Pharmacy> pharmacyMap;

    @RequestMapping("select/list")
    public Object queryWarehouseForList() {
        Object cacheData = stringRedisTemplate.opsForValue().get(redisKey);
        if (Objects.equals(cacheData, "") || cacheData == null) {
            return cacheReload();
        }
        return cacheData;
    }

    @RequestMapping("select/{warehouseId}")
    public Warehouse queryWarehouseById(@PathVariable("warehouseId") Integer warehouseId) {
        return staffAndDrugsAndPharmacyInit(warehouseService.getById(warehouseId));
    }

    @RequestMapping("update")
    public boolean updateWarehouseById(@RequestBody Warehouse warehouse) {
        if (warehouseService.updateById(warehouse)) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteWarehouseById(@RequestBody Warehouse warehouse) {
        if (warehouseService.removeById(warehouse.getWarehouseId())) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertWarehouse(@RequestBody Warehouse warehouse) {
        if (warehouseService.save(warehouse)) {
            cacheReload();
            return true;
        }
        return false;
    }

    public Object cacheReload() {
        List<Warehouse> warehouseList = warehouseService.list();
        staffAndDrugsAndPharmacyInit();
        warehouseList.replaceAll(this::staffAndDrugsAndPharmacyInit);
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSON(warehouseList).toString(), FullConfig.timeout, TimeUnit.SECONDS);
        return warehouseList;
    }

    /**
     * 载入员工、药品、药房信息
     */
    public void staffAndDrugsAndPharmacyInit() {
        drugsMap = drugsClient.queryDrugsForList().stream().collect(Collectors.toMap(Drugs::getDrugsId, drugs -> drugs));
        pharmacyMap = pharmacyClient.queryPharmacyForList().stream().collect(Collectors.toMap(Pharmacy::getPharmacyId, pharmacy -> pharmacy));
    }

    /**
     * 植入员工、药品、药房信息
     *
     * @param warehouse
     * @return Warehouse
     */
    public Warehouse staffAndDrugsAndPharmacyInit(Warehouse warehouse) {

        Pharmacy pharmacyTemp = pharmacyMap.get(warehouse.getPharmacyId());

        Drugs drugsTemp = drugsMap.get(warehouse.getDrugsId());

        warehouse.setPharmacy(pharmacyTemp);
        warehouse.setDrugs(drugsTemp);

        return warehouse;
    }

}
