package com.ankang.staff.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.staffService.OperatorType;
import com.ankang.staff.service.OperatorTypeService;
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
@RequestMapping("operatorType")
public class OperatorTypeController {

    String redisKey = "operatorType";
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    OperatorTypeService operatorTypeService;

    @RequestMapping("select/list")
    public Object queryOperatorTypeForList() {
        return operatorTypeService.list();
    }

    @RequestMapping("select/{operatorTypeId}")
    public OperatorType queryOperatorTypeById(@PathVariable("operatorTypeId") Integer operatorTypeId) {
        return operatorTypeService.getById(operatorTypeId);
    }

    @RequestMapping("update")
    public boolean updateOperatorTypeById(@RequestBody OperatorType operatorType) {
        if (operatorTypeService.updateById(operatorType)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteOperatorTypeById(@RequestBody OperatorType operatorType) {
        if (operatorTypeService.removeById(operatorType.getOperatorTypeId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertOperatorType(@RequestBody OperatorType operatorType) {
        if (operatorTypeService.save(operatorType)) {
            return true;
        }
        return false;
    }
}
