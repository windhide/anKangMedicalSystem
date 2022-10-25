package com.ankang.drugs.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.pojo.drugsService.DrugsType;
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
@RequestMapping("drugsType")
public class DrugsTypeController {
    String redisKey = "drugsType";
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    DrugsTypeService drugsTypeService;

    @RequestMapping("select/list")
    public Object queryDrugsTypeForList() {
        Object cacheData = stringRedisTemplate.opsForValue().get(redisKey);
        if (Objects.equals(cacheData, "") || cacheData == null) {
            return cacheReload();
        }
        return cacheData;
    }

    @RequestMapping("select/{drugsTypeId}")
    public DrugsType queryDrugsTypeById(@PathVariable("drugsTypeId") Integer drugsTypeId) {
        return drugsTypeService.getById(drugsTypeId);
    }

    @RequestMapping("update")
    public boolean updateDrugsTypeById(@RequestBody DrugsType drugsType) {
        if (drugsTypeService.updateById(drugsType)) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteDrugsTypeById(@RequestBody DrugsType drugsType) {
        if (drugsTypeService.removeById(drugsType.getDrugsTypeId())) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertDrugsType(@RequestBody DrugsType drugsType) {
        if (drugsTypeService.save(drugsType)) {
            cacheReload();
            return true;
        }
        return false;
    }


    public Object cacheReload() {
        List<DrugsType> drugsTypeList = drugsTypeService.list();
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSON(drugsTypeList).toString(), FullConfig.timeout, TimeUnit.SECONDS);
        return drugsTypeList;
    }

}
