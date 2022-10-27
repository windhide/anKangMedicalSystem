package com.ankang.staff.controller;

import com.ankang.pojo.staffService.Authority;
import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.pojo.staffService.Staff;
import com.ankang.staff.service.AuthorityService;
import com.ankang.staff.service.PharmacyService;
import com.ankang.staff.service.StaffService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("staff")
public class StaffController {
    @Autowired
    StaffService staffService;

    @Autowired
    PharmacyService pharmacyService;

    @Autowired
    AuthorityService authorityService;

    Map<Integer, Pharmacy> pharmacyMap;
    Map<Integer, Authority> authorityMap;

    @RequestMapping("select/list")
    public List<Staff> queryStaffForList() {
        List<Staff> staffList = staffService.list();
        pharmacyAndAuthorityInit();
        staffList.replaceAll(this::pharmacyAndAuthorityInit);
        return staffList;
    }

    @RequestMapping("select/{staffId}")
    public Staff queryStaffById(@PathVariable("staffId") Integer staffId) {
        pharmacyAndAuthorityInit();
        return pharmacyAndAuthorityInit(staffService.getById(staffId));
    }

    @RequestMapping("staffLogin")
    public Staff queryStaffByLogin(@RequestBody Staff staff){
        QueryWrapper<Staff> wrapper = new QueryWrapper<>();
        wrapper.eq("staffUserName",staff.getStaffUserName());
        wrapper.eq("staffPassWord",staff.getStaffPassWord());
        return staffService.getOne(new QueryWrapper<>(staff));
    }

    @RequestMapping("update")
    public boolean updateStaffById(@RequestBody Staff staff) {
        if(staff.getStaffPassWord() == ""){
            staff.setStaffPassWord(null);
        }
        return staffService.updateById(staff);
    }

    @RequestMapping("remove")
    public boolean deleteStaffById(@RequestBody Staff staff) {
        return staffService.removeById(staff.getStaffId());
    }

    @RequestMapping("insert")
    public boolean insertStaff(@RequestBody Staff staff) {
        return staffService.save(staff);
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
