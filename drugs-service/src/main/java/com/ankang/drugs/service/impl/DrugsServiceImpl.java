package com.ankang.drugs.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ankang.drugs.pojo.Drugs;
import com.ankang.drugs.service.DrugsService;
import com.ankang.drugs.mapper.DrugsMapper;
import org.springframework.stereotype.Service;

/**
* @author WindHide
* @description 针对表【drugs】的数据库操作Service实现
* @createDate 2022-09-14 18:55:09
*/
@Service
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs>
    implements DrugsService{

}




