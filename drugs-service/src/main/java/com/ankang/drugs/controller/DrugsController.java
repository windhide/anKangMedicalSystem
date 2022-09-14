package com.ankang.drugs.controller;


import com.ankang.drugs.service.DrugsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/drugs")
public class DrugsController {
    @Autowired
    DrugsService drugsService;


}
