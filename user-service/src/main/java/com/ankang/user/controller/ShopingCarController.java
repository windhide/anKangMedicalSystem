package com.ankang.user.controller;

import com.alibaba.fastjson.JSON;
import com.ankang.pojo.userService.ShopingCar;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shopingCar")
public class ShopingCarController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("select")
    public String selectShopingCar(@RequestBody String userKey){
        userKey = userKey.replaceAll("\\{\"userKey\":\"","").replaceAll("\"\\}","");
        System.out.println("userKey ==========+>"+ userKey);
        String redisData = stringRedisTemplate.opsForValue().get(userKey);
        System.out.println("redisData =======>" + redisData);
        return redisData == null || redisData.equals("") ? "" : redisData;
    }

    @RequestMapping("insert")
    public boolean addShopingCar(@RequestBody Map<String, Object> dataMap){
        String userKey = StringEscapeUtils.unescapeHtml(dataMap.get("userKey").toString());
        String redisData = stringRedisTemplate.opsForValue().get(userKey);
        boolean state = false;
        ShopingCar inputShopingCar = (ShopingCar) JSON.parseObject(JSON.toJSONString(dataMap.get("shopingCar")), ShopingCar.class);
        if(redisData == null || redisData.equals("")){
            try {
                List<ShopingCar> list = new ArrayList<>();
                list.add(inputShopingCar);
                stringRedisTemplate.opsForValue().set(userKey,JSON.toJSONString(list));
                state = true;
            }catch (Exception e){
                state = false;
            }
        }else{
            try {
                List<ShopingCar> list = JSON.parseArray(redisData, ShopingCar.class);
                List<ShopingCar> collect = null;
                if(list.stream().anyMatch(shoppingCar -> shoppingCar.getDrugs().getDrugsId() == inputShopingCar.getDrugs().getDrugsId()? true : false)){
                    collect = list.stream().filter(shoppingCar -> {
                        if (shoppingCar.getDrugs().getDrugsId() == inputShopingCar.getDrugs().getDrugsId()) {
                            shoppingCar.setCount(shoppingCar.getCount()+inputShopingCar.getCount());
                            return true;
                        }
                        return true;
                    }).collect(Collectors.toList());
                    stringRedisTemplate.opsForValue().set(userKey,JSON.toJSONString(collect));
                }else{
                    list.add(inputShopingCar);
                    stringRedisTemplate.opsForValue().set(userKey,JSON.toJSONString(list));
                }
                state = true;
            }catch (Exception e){
                state = false;
            }
        }
        return state;
    }

    @RequestMapping("remove")
    public boolean removeShopingCar(@RequestBody Map<String, Object> dataMap){
        List<ShopingCar> shopingCarList = JSON.parseArray(stringRedisTemplate.opsForValue().get(dataMap.get("userKey")), ShopingCar.class);
        List<ShopingCar> afterList = shopingCarList.stream().filter(shopingCar -> shopingCar.getDrugs().getDrugsId() != dataMap.get("drugsId")).collect(Collectors.toList());
        boolean state = false;
        try{
            stringRedisTemplate.opsForValue().set(dataMap.get("userKey").toString(),JSON.toJSONString(afterList));
            state = true;
        }catch (Exception e){
            state = false;
        }
        return state;
    }

    @RequestMapping("update")
    public boolean updateShopingCar(@RequestBody Map<String, Object> dataMap){
        ShopingCar inputShopingCar = (ShopingCar) JSON.parseObject(JSON.toJSONString(dataMap.get("shopingCar")), ShopingCar.class);
        List<ShopingCar> shopingCarList = JSON.parseArray(stringRedisTemplate.opsForValue().get(dataMap.get("userKey")), ShopingCar.class);
        List<ShopingCar> afterList = shopingCarList.stream().filter(shopingCar -> {
            if(shopingCar.getDrugs().getDrugsId() == inputShopingCar.getDrugs().getDrugsId()){
                shopingCar.setCount(inputShopingCar.getCount());
            }
            return true;
        }).collect(Collectors.toList());
        boolean state = false;
        try{
            stringRedisTemplate.opsForValue().set(dataMap.get("userKey").toString(),JSON.toJSONString(afterList));
            state = true;
        }catch (Exception e){
            state = false;
        }
        return state;
    }
}
