package com.ankang.staff.controller;

import com.ankang.pojo.staffService.OperatorType;
import com.ankang.staff.service.OperatorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("operatorType")
public class OperatorTypeController {
    @Autowired
    OperatorTypeService operatorTypeService;

    @RequestMapping("select/list")
    public List<OperatorType> queryOperatorTypeForList() {
        return operatorTypeService.list();
    }

    @RequestMapping("select/{operatorTypeId}")
    public OperatorType queryOperatorTypeById(@PathVariable("operatorTypeId") Integer operatorTypeId) {
        return operatorTypeService.getById(operatorTypeId);
    }

    @RequestMapping("update")
    public boolean updateOperatorTypeById(@RequestBody OperatorType operatorType) {
        return operatorTypeService.updateById(operatorType);
    }

    @RequestMapping("remove")
    public boolean deleteOperatorTypeById(@RequestBody OperatorType operatorType) {
        return operatorTypeService.removeById(operatorType.getOperatorTypeId());
    }

    @RequestMapping("insert")
    public boolean insertOperatorType(@RequestBody OperatorType operatorType) {
        return operatorTypeService.save(operatorType);
    }
}
