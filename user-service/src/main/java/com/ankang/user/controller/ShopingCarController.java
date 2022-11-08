package com.ankang.user.controller;

import com.ankang.pojo.userService.ShopingCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("shopingCar")
public class ShopingCarController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("select")
    public String selectShopingCar(@RequestBody String userId){
        return null;
    }

    @RequestMapping("insert")
    public boolean addShopingCar(@RequestBody Map<String, Object> dataMap){
        System.out.println("keys=======>"+ dataMap.get("shopingCar").toString());
        System.out.println("keys=======>"+ dataMap.get("userKey"));

        return false;
    }

    @RequestMapping("remove")
    public boolean removeShopingCar(@RequestBody Integer DrgusId){
        return false;
    }

    @RequestMapping("update")
    public boolean updateShopingCar(@RequestBody String ShopingJson){
        return false;
    }



}
