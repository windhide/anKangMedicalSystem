package com.ankang.staff.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ankang.staff.pojo.Staff;
import com.ankang.staff.service.StaffService;
import com.ankang.staff.mapper.StaffMapper;
import org.springframework.stereotype.Service;

/**
* @author WindHide
* @description 针对表【staff】的数据库操作Service实现
* @createDate 2022-09-14 18:57:29
*/
@Service
public class StaffServiceImpl extends ServiceImpl<StaffMapper, Staff>
    implements StaffService{

}




