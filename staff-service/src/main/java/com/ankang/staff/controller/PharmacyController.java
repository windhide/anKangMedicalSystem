package com.ankang.staff.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.staff.service.PharmacyService;
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
@RequestMapping("pharmacy")

public class PharmacyController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    PharmacyService pharmacyService;

    @RequestMapping("select/list")
    public Object queryPharmacyForList() {
        return pharmacyService.list();
    }

    @RequestMapping("select/{pharmacyId}")
    public Pharmacy queryPharmacyById(@PathVariable("pharmacyId") Integer pharmacyId) {
        return pharmacyService.getById(pharmacyId);
    }

    @RequestMapping("update")
    public boolean updatePharmacyById(@RequestBody Pharmacy pharmacy) {
        if (pharmacyService.updateById(pharmacy)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deletePharmacyById(@RequestBody Pharmacy pharmacy) {
        if (pharmacyService.removeById(pharmacy.getPharmacyId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertPharmacy(@RequestBody Pharmacy pharmacy) {
        if (pharmacyService.save(pharmacy)) {
            return true;
        }
        return false;
    }
}
