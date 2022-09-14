package com.ankang.drugs.controller;

import com.ankang.drugs.service.DrugsUnitService;
import com.ankang.pojo.drugsService.DrugsUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("drugsUnit")
public class DrugsUnitController {

    @Autowired
    DrugsUnitService drugsUnitService;

    @RequestMapping("list")
    public List<DrugsUnit> queryDrugsUnitForList() {
        return drugsUnitService.list();
    }

    @RequestMapping("{drugsUnitId}")
    public DrugsUnit queryDrugsUnitById(@PathVariable("drugsUnitId") Integer drugsUnitId) {
        return drugsUnitService.getById(drugsUnitId);
    }

}
