package com.ankang.pojo.userService;

import com.ankang.pojo.drugsService.Drugs;
import lombok.Data;

@Data
public class ShopingCar {
    private Integer count;
    private String createTime;
    private Drugs drugs;
}
