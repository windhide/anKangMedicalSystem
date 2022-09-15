package com.ankang.drugs.controller;


import com.ankang.drugs.service.DrugsService;
import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.drugsService.DrugsType;
import com.ankang.pojo.drugsService.DrugsUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("drugs")
public class DrugsController {
    @Autowired
    DrugsService drugsService;

    @Autowired
    DrugsTypeService drugsTypeService;

    @Autowired
    DrugsUnitService drugsUnitService;

    Map<Integer, String> drugTypeMap;
    Map<Integer, String> drugUnitMap;

    @RequestMapping("select/list")
    public List<Drugs> queryDrugsForList() {
        List<Drugs> list = drugsService.list();
        typeAndUnitMapInit();
        for (int i = 0; i < list.size(); i++) {
            list.set(i,drugsTypeAndUnitInit(list.get(i)));
        }
        return list;
    }

    @RequestMapping("select/{drugsId}")
    public Drugs queryDrugsById(@PathVariable("drugsId") Integer drugsId) {
        typeAndUnitMapInit();
        Drugs drugs = drugsService.getById(drugsId);
        return drugsTypeAndUnitInit(drugs);
    }

    @RequestMapping("update/{drugs}")
    public boolean updateDrugsById(@PathVariable("drugs") Drugs drugs) {
        return drugsService.updateById(drugs);
    }

    @RequestMapping("remove/{drugsId}")
    public boolean deleteDrugsById(@PathVariable("drugsId") Integer drugsId) {
        return drugsService.removeById(drugsId);
    }

    @RequestMapping("insert/{drugs}")
    public boolean insertDrugs(@PathVariable("drugs") Drugs drugs) {
        return drugsService.save(drugs);
    }

    public void typeAndUnitMapInit(){
        drugTypeMap = drugsTypeService.list().stream().collect(Collectors.toMap(DrugsType::getDrugsTypeId, DrugsType::getDrugsTypeName));
        drugUnitMap = drugsUnitService.list().stream().collect(Collectors.toMap(DrugsUnit::getDrugsUnitId, DrugsUnit::getDrugsUnitName));
    }

    public Drugs drugsTypeAndUnitInit(Drugs drugs){
        DrugsType tempDrugsType = new DrugsType();
        tempDrugsType.setDrugsTypeId(drugs.getDrugsTypeId());
        tempDrugsType.setDrugsTypeName(drugTypeMap.get(drugs.getDrugsTypeId()));

        DrugsUnit tempDrugsUnit = new DrugsUnit();
        tempDrugsUnit.setDrugsUnitId(drugs.getDrugsUnitid());
        tempDrugsUnit.setDrugsUnitName(drugUnitMap.get(drugs.getDrugsUnitid()));

        drugs.setDrugsUnit(tempDrugsUnit);
        drugs.setDrugsType(tempDrugsType);
        return drugs;
    }

}
