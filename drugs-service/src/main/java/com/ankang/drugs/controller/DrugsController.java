package com.ankang.drugs.controller;


import com.ankang.drugs.service.DrugsService;
import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.drugsService.DrugsType;
import com.ankang.pojo.drugsService.DrugsUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("select/list")
    public List<Drugs> queryDrugsForList() {
        List<Drugs> list = drugsService.list();
        Map<Integer, String> drugTypeMap = drugsTypeService.list().stream().collect(Collectors.toMap(DrugsType::getDrugsTypeId, DrugsType::getDrugsTypeName));
        Map<Integer, String> drugUnitMap = drugsUnitService.list().stream().collect(Collectors.toMap(DrugsUnit::getDrugsUnitId, DrugsUnit::getDrugsUnitName));
        for (int i = 0; i < list.size(); i++) {
            // 代码待优化
            DrugsType tempDrugsType = new DrugsType();
            tempDrugsType.setDrugsTypeId(list.get(i).getDrugsTypeId());
            tempDrugsType.setDrugsTypeName(drugTypeMap.get(list.get(i).getDrugsTypeId()));

            DrugsUnit tempDrugsUnit = new DrugsUnit();
            tempDrugsUnit.setDrugsUnitId(list.get(i).getDrugsUnitid());
            tempDrugsUnit.setDrugsUnitName(drugUnitMap.get(list.get(i).getDrugsUnitid()));

            list.get(i).setDrugsType(tempDrugsType);
            list.get(i).setDrugsUnit(tempDrugsUnit);
        }
        return list;
    }
}
