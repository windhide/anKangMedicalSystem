package com.ankang.drugs.controller;


import com.ankang.drugs.service.DrugsService;
import com.ankang.drugs.service.DrugsTypeService;
import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.Drugs;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("list")
    public List<Drugs> queryDrugsForList() {
        List<Drugs> list = drugsService.list();
        for (int i = 0; i < list.size(); i++) {
            // 代码待优化
            list.get(i).setDrugsType(drugsTypeService.getById(list.get(i).getDrugsTypeId()));
            list.get(i).setDrugsUnit(drugsUnitService.getById(list.get(i).getDrugsUnitid()));
        }
        return list;
    }
}
