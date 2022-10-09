package com.ankang.warehouse.controller;

import com.ankang.clients.DrugsClient;
import com.ankang.clients.PharmacyClient;
import com.ankang.clients.StaffClient;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.pojo.staffService.Staff;
import com.ankang.pojo.warehouseService.Warehouse;
import com.ankang.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @Autowired
    StaffClient staffClient;

    @Autowired
    DrugsClient drugsClient;

    @Autowired
    PharmacyClient pharmacyClient;

    Map<Integer, Staff> staffMap;

    Map<Integer, Drugs> drugsMap;

    Map<Integer, Pharmacy> pharmacyMap;

    @RequestMapping("select/list")
    public List<Warehouse> queryWarehouseForList() {
        List<Warehouse> warehouseList = warehouseService.list();
        staffAndDrugsAndPharmacyInit();
        warehouseList.replaceAll(this::staffAndDrugsAndPharmacyInit);
        return warehouseList;
    }

    @RequestMapping("select/{warehouseId}")
    public Warehouse queryWarehouseById(@PathVariable("warehouseId") Integer warehouseId) {
        return staffAndDrugsAndPharmacyInit(warehouseService.getById(warehouseId));
    }

    @RequestMapping("update")
    public boolean updateWarehouseById(@RequestBody Warehouse warehouse) {
        return warehouseService.updateById(warehouse);
    }

    @RequestMapping("remove")
    public boolean deleteWarehouseById(@RequestBody Warehouse warehouse) {
        return warehouseService.removeById(warehouse.getWarehouseId());
    }

    @RequestMapping("insert")
    public boolean insertWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }

    /**
     * 载入员工、药品、药房信息
     */
    public void staffAndDrugsAndPharmacyInit() {
        drugsMap = drugsClient.queryDrugsForList().stream().collect(Collectors.toMap(Drugs::getDrugsId,drugs -> drugs));
        pharmacyMap = pharmacyClient.queryPharmacyForList().stream().collect(Collectors.toMap(Pharmacy::getPharmacyId, pharmacy -> pharmacy));
        staffMap = staffClient.queryStaffForList().stream().collect(Collectors.toMap(Staff::getStaffId, staff -> staff));
    }

    /**
     * 植入员工、药品、药房信息
     *
     * @param warehouse
     * @return Warehouse
     */
    public Warehouse staffAndDrugsAndPharmacyInit(Warehouse warehouse) {
        Staff staffTemp = staffMap.get(warehouse.getStaffId());
        staffTemp.setStaffUserName(null);
        staffTemp.setStaffPassWord(null);

        Pharmacy pharmacyTemp = pharmacyMap.get(warehouse.getPharmacyId());

        Drugs drugsTemp = drugsMap.get(warehouse.getDrugsId());

        warehouse.setStaff(staffTemp);
        warehouse.setPharmacy(pharmacyTemp);
        warehouse.setDrugs(drugsTemp);

        return warehouse;
    }

}
