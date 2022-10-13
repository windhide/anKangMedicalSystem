package com.ankang.staff.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.staffService.Authority;
import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.pojo.staffService.Staff;
import com.ankang.staff.service.AuthorityService;
import com.ankang.staff.service.PharmacyService;
import com.ankang.staff.service.StaffService;
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
@RequestMapping("staff")
public class StaffController {

    String redisKey = "staff";
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    StaffService staffService;

    @Autowired
    PharmacyService pharmacyService;

    @Autowired
    AuthorityService authorityService;

    Map<Integer, Pharmacy> pharmacyMap;
    Map<Integer, Authority> authorityMap;

    @RequestMapping("select/list")
    public Object queryStaffForList() {
        Object cacheData = stringRedisTemplate.opsForValue().get(redisKey);
        if (Objects.equals(cacheData, "") || cacheData == null) {
            return cacheReload();
        }
        return cacheData;
    }

    @RequestMapping("select/{staffId}")
    public Staff queryStaffById(@PathVariable("staffId") Integer staffId) {
        pharmacyAndAuthorityInit();
        return pharmacyAndAuthorityInit(staffService.getById(staffId));
    }

    @RequestMapping("update")
    public boolean updateStaffById(@RequestBody Staff staff) {
        if (staffService.updateById(staff)) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteStaffById(@RequestBody Staff staff) {
        if (staffService.removeById(staff.getStaffId())) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertStaff(@RequestBody Staff staff) {
        if (staffService.save(staff)) {
            cacheReload();
            return true;
        }
        return false;
    }

    public Object cacheReload() {
        List<Staff> staffList = staffService.list();
        pharmacyAndAuthorityInit();
        staffList.replaceAll(this::pharmacyAndAuthorityInit);
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSON(staffList).toString(), FullConfig.timeout, TimeUnit.SECONDS);
        return staffList;
    }

    /**
     * 加载药店和权限的Map
     */
    public void pharmacyAndAuthorityInit() {
        pharmacyMap = pharmacyService.list().stream().collect(Collectors.toMap(Pharmacy::getPharmacyId, pharmacy -> pharmacy));
        authorityMap = authorityService.list().stream().collect(Collectors.toMap(Authority::getAuthorityId, authority -> authority));
    }

    /**
     * 植入药店和权限
     *
     * @param staff
     * @return
     */
    public Staff pharmacyAndAuthorityInit(Staff staff) {
        Pharmacy tempPharmacy = pharmacyMap.get(staff.getPharmacyId());

        Authority tempAuthority = authorityMap.get(staff.getAuthorityId());

        staff.setPharmacy(tempPharmacy);
        staff.setAuthority(tempAuthority);

        return staff;
    }
}
