package com.ankang.user.controller;

import com.ankang.clients.StaffClient;
import com.ankang.pojo.staffService.Staff;
import com.ankang.pojo.userService.Symptom;
import com.ankang.pojo.userService.User;
import com.ankang.user.service.SymptomService;
import com.ankang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("symptom")
public class SymptomController {
    @Autowired
    SymptomService symptomService;

    @Autowired
    UserService userService;
    @Autowired
    StaffClient staffClient;

    Map<Integer, Staff> staffMap;

    Map<Integer, User> userMap;


    @RequestMapping("select/list")

    public List<Symptom> querySymptomForList() {
        List<Symptom> symptomList = symptomService.list();
        userAndStaffInit();
        symptomList.replaceAll(this::userAndStaffInit);
        return symptomList;
    }

    @RequestMapping("select/{symptomId}")
    public Symptom querySymptomById(@PathVariable("symptomId") Integer symptomId) {
        return userAndStaffInit(symptomService.getById(symptomId));
    }

    @RequestMapping("update")
    public boolean updateSymptomById(@RequestBody Symptom symptom) {
        return symptomService.updateById(symptom);
    }

    @RequestMapping("remove")
    public boolean deleteSymptomById(@RequestBody Symptom symptom) {
        return symptomService.removeById(symptom.getSymptomId());
    }

    @RequestMapping("insert")
    public boolean insertSymptom(@RequestBody Symptom symptom) {
        return symptomService.save(symptom);
    }

    /**
     * 载入用户，员工信息
     */
    public void userAndStaffInit() {
        userMap = userService.list().stream().collect(Collectors.toMap(User::getUserId, user -> user));
        staffMap = staffClient.queryStaffForList().stream().collect(Collectors.toMap(Staff::getStaffId, staff -> staff));
    }

    /**
     * 植入用户，员工信息
     *
     * @param symptom
     * @return Symptom
     */
    public Symptom userAndStaffInit(Symptom symptom) {
        User userTemp = userMap.get(symptom.getUserId());
        userTemp.setUserUserName(null);
        userTemp.setUserPassWord(null);

        Staff staffTemp = staffMap.get(symptom.getStaffId());
        staffTemp.setStaffUserName(null);
        staffTemp.setStaffPassWord(null);

        symptom.setUser(userTemp);
        symptom.setStaff(staffTemp);

        return symptom;
    }
}
