package com.ankang.drugs.controller;


import com.alibaba.fastjson2.JSON;
import com.ankang.cache.ListCache;
import com.ankang.drugs.service.DrugsService;
import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.drugsService.DrugsType;
import com.ankang.pojo.drugsService.DrugsUnit;
import com.ankang.utils.SeparatePageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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

    Map<Integer, DrugsType> drugsTypeMap;
    Map<Integer, DrugsUnit> drugsUnitMap;

    @RequestMapping("select/list/{page}")
    public Map<String, Object> queryDrugsForList(@PathVariable("page") Integer page) {
        List<Drugs> list = null;
        Map<String,Object> map = new HashMap<>();
        if (ListCache.getListCache("drugs") == null) {
            list = drugsService.list();
            drugsTypeAndUnitInit();
            list.replaceAll(this::drugsTypeAndUnitInit);
            ListCache.setListCache("drugs", list);
        }

        map.put("data", JSON.toJSON(SeparatePageUtil.getSeparatePageData(ListCache.getListCache("drugs"), page)));
        map.put("size",SeparatePageUtil.dataCount);
        map.put("total",ListCache.getListCache("drugs").size());
        map.put("nowSize",SeparatePageUtil.getSeparatePageData(ListCache.getListCache("drugs"), page).size());

        return map;
    }

    @RequestMapping("select/list")
    public List<Drugs> queryDrugsForList() {
        List<Drugs> list = null;
        if (ListCache.getListCache("drugs") == null) {
            list = drugsService.list();
            drugsTypeAndUnitInit();
            list.replaceAll(this::drugsTypeAndUnitInit);
            ListCache.setListCache("drugs", list);
        }

        return (List<Drugs>) ListCache.getListCache("drugs");
    }

    @RequestMapping("select/{drugsId}")
    public Drugs queryDrugsById(@PathVariable("drugsId") Integer drugsId) {
        drugsTypeAndUnitInit();
        Drugs drugs = drugsService.getById(drugsId);
        return drugsTypeAndUnitInit(drugs);
    }

    @RequestMapping("update/{drugs}")
    public boolean updateDrugsById(@PathVariable("drugs") Drugs drugs) {
        return drugsService.updateById(drugs);
    }

    @RequestMapping("remove/{drugsId}")
    public boolean deleteDrugsById(@PathVariable("drugsId") Integer drugsId) {
        ListCache.setListCache("drugs",null);
        return drugsService.removeById(drugsId);
    }

    @RequestMapping("insert/{drugs}")
    public boolean insertDrugs(@PathVariable("drugs") Drugs drugs) {
        return drugsService.save(drugs);
    }

    /**
     * 加载药品类型和单位的Map
     */
    public void drugsTypeAndUnitInit() {
        drugsTypeMap = drugsTypeService.list().stream().collect(Collectors.toMap(DrugsType::getDrugsTypeId, drugsType -> drugsType));
        drugsUnitMap = drugsUnitService.list().stream().collect(Collectors.toMap(DrugsUnit::getDrugsUnitId, drugsUnit -> drugsUnit));
    }

    /**
     * 植入药品类型和单位
     *
     * @param drugs
     * @return
     */
    public Drugs drugsTypeAndUnitInit(Drugs drugs) {
        DrugsType tempDrugsType = drugsTypeMap.get(drugs.getDrugsTypeId());

        DrugsUnit tempDrugsUnit = drugsUnitMap.get(drugs.getDrugsUnitid());

        drugs.setDrugsUnit(tempDrugsUnit);
        drugs.setDrugsType(tempDrugsType);
        return drugs;
    }

}
