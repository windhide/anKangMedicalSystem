package com.ankang.drugs.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.DrugsUnit;
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
@RequestMapping("drugsUnit")
public class DrugsUnitController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    DrugsUnitService drugsUnitService;

    @RequestMapping("select/list")
    public Object queryDrugsUnitForList() {
        return drugsUnitService.list();
    }

    @RequestMapping("select/{drugsUnitId}")
    public DrugsUnit queryDrugsUnitById(@PathVariable("drugsUnitId") Integer drugsUnitId) {
        return drugsUnitService.getById(drugsUnitId);
    }

    @RequestMapping("update")
    public boolean updateDrugsById(@RequestBody DrugsUnit drugsUnit) {
        if (drugsUnitService.updateById(drugsUnit)) {
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteDrugsById(@RequestBody DrugsUnit drugsUnit) {
        if (drugsUnitService.removeById(drugsUnit.getDrugsUnitId())) {
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertDrugs(@RequestBody DrugsUnit drugsUnit) {
        if (drugsUnitService.save(drugsUnit)) {
            return true;
        }
        return false;
    }
}
