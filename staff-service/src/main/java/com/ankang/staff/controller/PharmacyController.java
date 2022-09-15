package com.ankang.staff.controller;

import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.staff.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pharmacy")
public class PharmacyController {
    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping("select/list")
    public List<Pharmacy> queryPharmacyForList() {
        return pharmacyService.list();
    }

    @RequestMapping("select/{pharmacyId}")
    public Pharmacy queryPharmacyById(@PathVariable("pharmacyId") Integer pharmacyId) {
        return pharmacyService.getById(pharmacyId);
    }

    @RequestMapping("update/{pharmacy}")
    public boolean updatePharmacyById(@PathVariable("pharmacy") Pharmacy pharmacy) {
        return pharmacyService.updateById(pharmacy);
    }

    @RequestMapping("remove/{pharmacyId}")
    public boolean deletePharmacyById(@PathVariable("pharmacyId") Integer pharmacyId) {
        return pharmacyService.removeById(pharmacyId);
    }

    @RequestMapping("insert/{pharmacy}")
    public boolean insertPharmacy(@PathVariable("pharmacy") Pharmacy pharmacy) {
        return pharmacyService.save(pharmacy);
    }
}
