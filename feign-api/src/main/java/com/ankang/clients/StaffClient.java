package com.ankang.clients;

import com.ankang.pojo.staffService.Staff;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "staff-service")
public interface StaffClient {

    @RequestMapping("staff/select/list")
    List<Staff> queryStaffForList();

    @RequestMapping("staff/select/{staffId}")
    Staff queryStaffById(@PathVariable("staffId") Integer staffId);

    @RequestMapping("staff/staffLogin")
    Staff queryStaffByLogin(@RequestBody Staff staff);
}
