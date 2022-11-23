package com.ankang.drugs.controller;

import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.pojo.drugsService.DrugsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("drugsType")
public class DrugsTypeController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    DrugsTypeService drugsTypeService;

    @RequestMapping("select/list")
    public Object queryDrugsTypeForList() {
        return drugsTypeService.list();
    }

    @RequestMapping("select/{drugsTypeId}")
    public DrugsType queryDrugsTypeById(@PathVariable("drugsTypeId") Integer drugsTypeId) {
        return drugsTypeService.getById(drugsTypeId);
    }

    @RequestMapping("update")
    public boolean updateDrugsTypeById(@RequestBody DrugsType drugsType) {
        if (drugsTypeService.updateById(drugsType)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteDrugsTypeById(@RequestBody DrugsType drugsType) {
        if (drugsTypeService.removeById(drugsType.getDrugsTypeId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertDrugsType(@RequestBody DrugsType drugsType) {
        if (drugsTypeService.save(drugsType)) {
            return true;
        }
        return false;
    }
}
