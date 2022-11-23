package com.ankang.warehouse.controller;

import com.ankang.clients.DrugsClient;
import com.ankang.clients.PharmacyClient;
import com.ankang.clients.StaffClient;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Staff;
import com.ankang.pojo.warehouseService.Warehouse;
import com.ankang.pojo.warehouseService.WarehouseStaffRecord;
import com.ankang.pojo.warehouseService.WarehouseType;
import com.ankang.warehouse.service.WarehouseService;
import com.ankang.warehouse.service.WarehouseStaffRecordService;
import com.ankang.warehouse.service.WarehouseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("warehouseStaffRecord")
public class WarehouseStaffRecordController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    WarehouseStaffRecordService warehouseStaffRecordService;

    @Autowired
    WarehouseService warehouseService;

    @Autowired
    WarehouseTypeService warehouseTypeService;

    @Autowired
    StaffClient staffClient;

    @Autowired
    DrugsClient drugsClient;

    @Autowired
    PharmacyClient pharmacyClient;

    Map<Integer, Warehouse> warehouseMap;
    Map<Integer, Staff> staffMap;

    Map<Integer, Drugs> drugsMap;

    Map<Integer, WarehouseType> warehouseTypeMap;


    @RequestMapping("select/list")
    public Object queryWarehouseStaffRecordForList() {
        List<WarehouseStaffRecord> warehouseStaffRecordList = warehouseStaffRecordService.list();
        staffAndDrugsAndPharmacyInit();
        warehouseStaffRecordList.replaceAll(this::staffAndDrugsAndPharmacyInit);
        return warehouseStaffRecordList;
    }

    @RequestMapping("select/{warehouseStaffRecordId}")
    public WarehouseStaffRecord queryWarehouseStaffRecordById(@PathVariable("warehouseStaffRecordId") Integer warehouseStaffRecordId) {
        return staffAndDrugsAndPharmacyInit(warehouseStaffRecordService.getById(warehouseStaffRecordId));
    }

    @RequestMapping("update")
    public boolean updateWarehouseStaffRecordById(@RequestBody WarehouseStaffRecord warehouseStaffRecord) {
        if (warehouseStaffRecordService.updateById(warehouseStaffRecord)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteWarehouseStaffRecordById(@RequestBody WarehouseStaffRecord warehouseStaffRecord) {
        if (warehouseStaffRecordService.removeById(warehouseStaffRecord.getWarehouseStaffRecordId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertWarehouseStaffRecord(@RequestBody WarehouseStaffRecord warehouseStaffRecord) {
        if (warehouseStaffRecordService.save(warehouseStaffRecord)) {
            return true;
        }
        return false;
    }

    /**
     * 载入员工、药品、药房信息 药房,操作信息
     */
    public void staffAndDrugsAndPharmacyInit() {
        drugsMap = drugsClient.queryDrugsForList().stream().collect(Collectors.toMap(Drugs::getDrugsId, drugs -> drugs));
        staffMap = staffClient.queryStaffForList().stream().collect(Collectors.toMap(Staff::getStaffId, staff -> staff));
        warehouseMap = warehouseService.list().stream().collect(Collectors.toMap(Warehouse::getWarehouseId, warehouse -> warehouse));
        warehouseTypeMap = warehouseTypeService.list().stream().collect(Collectors.toMap(WarehouseType::getWarehouseTypeId, warehouseType -> warehouseType));
    }

    /**
     * 植入员工、药品、药房信息 药房,操作信息
     *
     * @param warehouseStaffRecord
     * @return WarehouseStaffRecord
     */
    public WarehouseStaffRecord staffAndDrugsAndPharmacyInit(WarehouseStaffRecord warehouseStaffRecord) {
        Drugs drugsTemp = drugsMap.get(warehouseStaffRecord.getDrugsId());

        Staff staffTemp = staffMap.get(warehouseStaffRecord.getStaffId());
        staffTemp.setStaffUserName(null);
        staffTemp.setStaffPassWord(null);

        Warehouse warehouseTemp = warehouseMap.get(warehouseStaffRecord.getWarehouseId());

        WarehouseType warehouseTypeTemp = warehouseTypeMap.get(warehouseStaffRecord.getWarehouseTypeId());

        warehouseStaffRecord.setDrugs(drugsTemp);
        warehouseStaffRecord.setStaff(staffTemp);
        warehouseStaffRecord.setWarehouse(warehouseTemp);
        warehouseStaffRecord.setWarehouseType(warehouseTypeTemp);

        return warehouseStaffRecord;
    }
}
