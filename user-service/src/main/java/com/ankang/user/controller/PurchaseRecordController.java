package com.ankang.user.controller;

import com.ankang.clients.DrugsClient;
import com.ankang.clients.StaffClient;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Staff;
import com.ankang.pojo.userService.PurchaseRecord;
import com.ankang.pojo.userService.User;
import com.ankang.user.service.PurchaseRecordService;
import com.ankang.user.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
@RequestMapping("purchaseRecord")
public class PurchaseRecordController {
    @Autowired
    PurchaseRecordService purchaseRecordService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    DrugsClient drugsClient;
    @Autowired
    StaffClient staffClient;
    @Autowired
    UserService userService;

    Map<Integer, User> userMap;

    Map<Integer, Staff> staffMap;

    Map<Integer, Drugs> drugsMap;

    @RequestMapping("select/list")
    public Object queryPurchaseRecordForList() {
        List<PurchaseRecord> purchaseRecordList = purchaseRecordService.list();
        userAndDrugsAndStaffInit();
        purchaseRecordList.replaceAll(this::userAndDrugsAndStaffInit);
        return purchaseRecordList;
    }

    @RequestMapping("selectUser")
    public List<PurchaseRecord> queryPurchaseRecordForUser(@RequestBody Map<String,Object> dataMap){
        QueryWrapper<PurchaseRecord> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",dataMap.get("userId").toString());
        List<PurchaseRecord> purchaseRecordList = purchaseRecordService.list(queryWrapper);
        userAndDrugsAndStaffInit();
        purchaseRecordList.replaceAll(this::userAndDrugsAndStaffInit);
        return purchaseRecordList;
    }

    @RequestMapping("select/{purchaseRecordId}")
    public PurchaseRecord queryPurchaseRecordById(@PathVariable("purchaseRecordId") Integer purchaseRecordId) {
        return userAndDrugsAndStaffInit(purchaseRecordService.getById(purchaseRecordId));
    }

    @RequestMapping("update")
    public boolean updatePurchaseRecordById(@RequestBody PurchaseRecord purchaseRecord) {
        if (purchaseRecordService.updateById(purchaseRecord)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deletePurchaseRecordById(@RequestBody PurchaseRecord purchaseRecord) {
        if (purchaseRecordService.removeById(purchaseRecord.getPurchaseRecordId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertPurchaseRecord(@RequestBody PurchaseRecord purchaseRecord) {
        if (purchaseRecordService.save(purchaseRecord)) {
            return true;
        }
        return false;
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


        purchaseRecord.setUser(userTemp);
        purchaseRecord.setStaff(staffTemp);

        return purchaseRecord;
    }
}
