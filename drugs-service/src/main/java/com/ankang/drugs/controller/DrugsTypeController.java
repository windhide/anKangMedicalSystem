package com.ankang.drugs.controller;

import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.pojo.drugsService.DrugsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("drugsType")
public class DrugsTypeController {

    @Autowired
    DrugsTypeService drugsTypeService;

    @RequestMapping("select/list")
    public List<DrugsType> queryDrugsTypeForList() {
        return drugsTypeService.list();
    }

    @RequestMapping("select/{drugsTypeId}")
    public DrugsType queryDrugsTypeById(@PathVariable("drugsTypeId") Integer drugsTypeId) {
        return drugsTypeService.getById(drugsTypeId);
    }

    @RequestMapping("update/{drugsType}")
    public boolean updateDrugsTypeById(@PathVariable("drugsType") DrugsType drugsType) {
        return drugsTypeService.updateById(drugsType);
    }

    @RequestMapping("remove/{drugsTypeId}")
    public boolean deleteDrugsTypeById(@PathVariable("drugsTypeId") Integer drugsTypeId) {
        return drugsTypeService.removeById(drugsTypeId);
    }

    @RequestMapping("insert/{drugsType}")
    public boolean insertDrugsType(@PathVariable("drugsType") DrugsType drugsType) {
        return drugsTypeService.save(drugsType);
    }

}
