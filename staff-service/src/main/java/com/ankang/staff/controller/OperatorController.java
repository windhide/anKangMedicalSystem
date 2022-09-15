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
        staffAndOperatorTypeMapInit();
        operatorList.replaceAll(this::staffAndOperatorTypeInit);
        return operatorList;
    }

    @RequestMapping("select/{operatorId}")
    public Operator queryOperatorById(@PathVariable("operatorId") Integer operatorId) {
        staffAndOperatorTypeMapInit();
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
    public void staffAndOperatorTypeMapInit() {
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
        Staff tempStaff = new Staff();
        tempStaff.setStaffId(operator.getStaffId());
        tempStaff.setStaffName(staffMap.get(operator.getStaffId()).getStaffName());
        tempStaff.setStaffPhone(staffMap.get(operator.getStaffId()).getStaffPhone());
        tempStaff.setStaffSex(staffMap.get(operator.getStaffId()).getStaffSex());
        tempStaff.setPharmacy(staffMap.get(operator.getStaffId()).getPharmacy());
        tempStaff.setAuthority(staffMap.get(operator.getStaffId()).getAuthority());

        OperatorType tempOperatorType = new OperatorType();
        tempOperatorType.setOperatorTypeId(operator.getOperatorTypeId());
        tempOperatorType.setOperatorTypeName(operatorTypeMap.get(operator.getOperatorId()).getOperatorTypeName());

        operator.setDrugs(drugsClient.queryDrugsById(operator.getDrugsId()));
        operator.setStaff(tempStaff);
        operator.setOperatorType(tempOperatorType);

        return operator;
    }

}
