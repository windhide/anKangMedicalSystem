package com.ankang.user.controller;

import com.ankang.clients.DrugsClient;
import com.ankang.clients.StaffClient;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Staff;
import com.ankang.pojo.userService.PurchaseRecord;
import com.ankang.pojo.userService.User;
import com.ankang.user.service.PurchaseRecordService;
import com.ankang.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("purchaseRecord")
public class PurchaseRecordController {
    @Autowired
    PurchaseRecordService purchaseRecordService;

    @Autowired
    DrugsClient drugsClient;

    @Autowired
    StaffClient staffClient;

    @Autowired
    UserService userService;

    Map<Integer,User> userMap;

    Map<Integer, Staff> staffMap;

    Map<Integer, Drugs> drugsMap;

    @RequestMapping("select/list")
    public List<PurchaseRecord> queryPurchaseRecordForList() {
        List<PurchaseRecord> recordList = purchaseRecordService.list();
        userAndDrugsAndStaffInit();
        recordList.replaceAll(this::userAndDrugsAndStaffInit);
        return recordList;
    }

    @RequestMapping("select/{purchaseRecordId}")
    public PurchaseRecord queryPurchaseRecordById(@PathVariable("purchaseRecordId") Integer purchaseRecordId) {
        return userAndDrugsAndStaffInit(purchaseRecordService.getById(purchaseRecordId));
    }

    @RequestMapping("update/{purchaseRecord}")
    public boolean updatePurchaseRecordById(@PathVariable("purchaseRecord") PurchaseRecord purchaseRecord) {
        return purchaseRecordService.updateById(purchaseRecord);
    }

    @RequestMapping("remove/{purchaseRecordId}")
    public boolean deletePurchaseRecordById(@PathVariable("purchaseRecordId") Integer purchaseRecordId) {
        return purchaseRecordService.removeById(purchaseRecordId);
    }

    @RequestMapping("insert/{purchaseRecord}")
    public boolean insertPurchaseRecord(@PathVariable("purchaseRecord") PurchaseRecord purchaseRecord) {
        return purchaseRecordService.save(purchaseRecord);
    }

    /**
     * 载入用户，药品，员工信息
     */
    public void userAndDrugsAndStaffInit() {
        userMap = userService.list().stream().collect(Collectors.toMap(User::getUserId, user -> user));
        staffMap = staffClient.queryStaffForList().stream().collect(Collectors.toMap(Staff::getStaffId, staff -> staff));
        drugsMap = drugsClient.queryDrugsForList().stream().collect(Collectors.toMap(Drugs::getDrugsId, drugs -> drugs));
    }

    /**
     * 植入用户，药品，员工信息
     *
     * @param purchaseRecord
     * @return PurchaseRecord
     */
    public PurchaseRecord userAndDrugsAndStaffInit(PurchaseRecord purchaseRecord) {
        User userTemp = userMap.get(purchaseRecord.getUserId());
        userTemp.setUserUserName(null);
        userTemp.setUserPassWord(null);

        Staff staffTemp = staffMap.get(purchaseRecord.getStaffId());
        staffTemp.setStaffUserName(null);
        staffTemp.setStaffPassWord(null);

        Drugs drugsTemp = drugsMap.get(purchaseRecord.getDrugsId());

        purchaseRecord.setUser(userTemp);
        purchaseRecord.setStaff(staffTemp);
        purchaseRecord.setDrugs(drugsTemp);

        return purchaseRecord;
    }
}
