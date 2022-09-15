package com.ankang.staff.controller;

import com.ankang.clients.DrugsClient;
import com.ankang.pojo.staffService.Operator;
import com.ankang.pojo.staffService.OperatorType;
import com.ankang.pojo.staffService.Staff;
import com.ankang.staff.service.OperatorService;
import com.ankang.staff.service.OperatorTypeService;
import com.ankang.staff.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("operator")
public class OperatorController {
    @Autowired
    OperatorService operatorService;

    @Autowired
    StaffService staffService;

    @Autowired
    OperatorTypeService operatorTypeService;

    @Autowired
    DrugsClient drugsClient;

    Map<Integer, Staff> staffMap;
    Map<Integer, OperatorType> operatorTypeMap;

    @RequestMapping("select/list")
    public List<Operator> queryOperatorForList() {
        List<Operator> operatorList = operatorService.list();
        staffAndOperatorTypeInit();
        operatorList.replaceAll(this::staffAndOperatorTypeInit);
        return operatorList;
    }

    @RequestMapping("select/{operatorId}")
    public Operator queryOperatorById(@PathVariable("operatorId") Integer operatorId) {
        staffAndOperatorTypeInit();
        return staffAndOperatorTypeInit(operatorService.getById(operatorId));
    }

    @RequestMapping("update/{operator}")
    public boolean updateOperatorById(@PathVariable("operator") Operator operator) {
        return operatorService.updateById(operator);
    }

    @RequestMapping("remove/{operatorId}")
    public boolean deleteOperatorById(@PathVariable("operatorId") Integer operatorId) {
        return operatorService.removeById(operatorId);
    }

    @RequestMapping("insert/{operator}")
    public boolean insertOperator(@PathVariable("operator") Operator operator) {
        return operatorService.save(operator);
    }

    /**
     * 员工和药品以及操作记录
     */
    public void staffAndOperatorTypeInit() {
        staffMap = staffService.list().stream().collect(Collectors.toMap(Staff::getStaffId, staffMap -> staffMap));
        operatorTypeMap = operatorTypeService.list().stream().collect(Collectors.toMap(OperatorType::getOperatorTypeId, operatorTypeMap -> operatorTypeMap));
    }

    /**
     * 植入员工和药品以及操作记录
     *
     * @param operator
     * @return Operator
     */
    public Operator staffAndOperatorTypeInit(Operator operator) {
        Staff tempStaff = staffMap.get(operator.getStaffId());
        tempStaff.setStaffUserName(null);
        tempStaff.setStaffPassWord(null);

        OperatorType tempOperatorType = operatorTypeMap.get(operator.getOperatorTypeId());

        operator.setDrugs(drugsClient.queryDrugsById(operator.getDrugsId()));
        operator.setStaff(tempStaff);
        operator.setOperatorType(tempOperatorType);

        return operator;
    }

}
