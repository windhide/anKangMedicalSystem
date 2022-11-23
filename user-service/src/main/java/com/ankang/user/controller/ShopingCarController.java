package com.ankang.user.controller;

import com.alibaba.fastjson.JSON;
import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.userService.PurchaseRecord;
import com.ankang.pojo.userService.ShopingCar;
import com.ankang.user.service.PurchaseRecordService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shopingCar")
public class ShopingCarController {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    PurchaseRecordService purchaseRecordService;

    @RequestMapping("select")
    public String selectShopingCar(@RequestBody String userKey) {
        userKey = userKey.replaceAll("\\{\"userKey\":\"", "").replaceAll("\"\\}", "");
        System.out.println("userKey ==========+>" + userKey);
        String redisData = stringRedisTemplate.opsForValue().get(userKey);
        System.out.println("redisData =======>" + redisData);
        return redisData == null || redisData.equals("") ? "" : redisData;
    }

    @RequestMapping("insert")
    public boolean addShopingCar(@RequestBody Map<String, Object> dataMap) {
        String userKey = StringEscapeUtils.unescapeHtml(dataMap.get("userKey").toString());
        String redisData = stringRedisTemplate.opsForValue().get(userKey);
        boolean state;
        ShopingCar inputShopingCar = JSON.parseObject(JSON.toJSONString(dataMap.get("shopingCar")), ShopingCar.class);
        if (redisData == null || redisData.equals("")) {
            try {
                List<ShopingCar> list = new ArrayList<>();
                list.add(inputShopingCar);
                stringRedisTemplate.opsForValue().set(userKey, JSON.toJSONString(list));
                state = true;
            } catch (Exception e) {
                state = false;
            }
        } else {
            try {
                List<ShopingCar> list = JSON.parseArray(redisData, ShopingCar.class);
                List<ShopingCar> collect = null;
                if (list.stream().anyMatch(shoppingCar -> Objects.equals(shoppingCar.getDrugs().getDrugsId(), inputShopingCar.getDrugs().getDrugsId()))) {
                    collect = list.stream().filter(shoppingCar -> {
                        if (shoppingCar.getDrugs().getDrugsId() == inputShopingCar.getDrugs().getDrugsId()) {
                            shoppingCar.setCount(shoppingCar.getCount() + inputShopingCar.getCount());
                            return true;
                        }
                        return true;
                    }).collect(Collectors.toList());
                    stringRedisTemplate.opsForValue().set(userKey, JSON.toJSONString(collect));
                } else {
                    list.add(inputShopingCar);
                    stringRedisTemplate.opsForValue().set(userKey, JSON.toJSONString(list));
                }
                state = true;
            } catch (Exception e) {
                state = false;
            }
        }
        return state;
    }

    @RequestMapping("remove")
    public boolean removeShopingCar(@RequestBody Map<String, Object> dataMap) {
        List<ShopingCar> shopingCarList = JSON.parseArray(stringRedisTemplate.opsForValue().get(dataMap.get("userKey")), ShopingCar.class);
        List<ShopingCar> afterList = shopingCarList.stream().filter(shopingCar -> shopingCar.getDrugs().getDrugsId() != dataMap.get("drugsId")).collect(Collectors.toList());
        boolean state = false;
        try {
            stringRedisTemplate.opsForValue().set(dataMap.get("userKey").toString(), JSON.toJSONString(afterList));
            state = true;
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    @RequestMapping("update")
    public boolean updateShopingCar(@RequestBody Map<String, Object> dataMap) {
        ShopingCar inputShopingCar = (ShopingCar) JSON.parseObject(JSON.toJSONString(dataMap.get("shopingCar")), ShopingCar.class);
        List<ShopingCar> shopingCarList = JSON.parseArray(stringRedisTemplate.opsForValue().get(dataMap.get("userKey")), ShopingCar.class);
        List<ShopingCar> afterList = shopingCarList.stream().filter(shopingCar -> {
            if (shopingCar.getDrugs().getDrugsId() == inputShopingCar.getDrugs().getDrugsId()) {
                shopingCar.setCount(inputShopingCar.getCount());
            }
            return true;
        }).collect(Collectors.toList());
        boolean state = false;
        try {
            stringRedisTemplate.opsForValue().set(dataMap.get("userKey").toString(), JSON.toJSONString(afterList));
            state = true;
        } catch (Exception e) {
            state = false;
        }
        return state;
    }
// 𝔀ℐ𝓃𝓭ℋℐ𝓭ℯ

    @RequestMapping("removeAll")
    public boolean removaAllShopingCar(@RequestBody Map<String, Object> dataMap) {
        boolean state;
        try {
            stringRedisTemplate.delete(dataMap.get("userKey").toString());
            state = true;
        } catch (Exception e) {
            state = false;
        }
        return state;
    }

    @RequestMapping("Pay")
    public boolean PayShopingCar(@RequestBody Map<String,Object> dataMap) {
        boolean state = false;
        // 前端给的
        List<ShopingCar> checkList = JSON.parseArray(JSON.toJSONString(dataMap.get("shopingCar")), ShopingCar.class);
        // redis的购物车
        List<ShopingCar> shopingCarList = JSON.parseArray(stringRedisTemplate.opsForValue().get(dataMap.get("userKey").toString()), ShopingCar.class);
        // 此处为缓存
        List<ShopingCar> cacheCarList = shopingCarList;

        List<Integer> idsList = checkList.stream().map(ShopingCar::getDrugs).collect(Collectors.toList()).stream().map(Drugs::getDrugsId).collect(Collectors.toList());

        try {
            shopingCarList = shopingCarList.stream().filter(redisShopingCar -> !idsList.contains(redisShopingCar.getDrugs().getDrugsId())).collect(Collectors.toList());
            stringRedisTemplate.opsForValue().set(dataMap.get("userKey").toString(), JSON.toJSONString(shopingCarList));
            PurchaseRecord purchaseRecord = new PurchaseRecord();
            purchaseRecord.setPurchaseRecordId(null);
            purchaseRecord.setUserId(Integer.parseInt(dataMap.get("userKey").toString().split("-")[0]));
            purchaseRecord.setCreateTime(dataMap.get("nowTime").toString());
            purchaseRecord.setStaffId(9999);
            if (dataMap.get("staffId") != null) {
                purchaseRecord.setStaffId((Integer) dataMap.get("staffId"));
            }
            purchaseRecord.setDrugsJson(JSON.toJSONString(checkList));
            state = purchaseRecordService.save(purchaseRecord);
        } catch (Exception e) {
            System.out.println(e);
            stringRedisTemplate.opsForValue().set(dataMap.get("userKey").toString(), JSON.toJSONString(cacheCarList));
        }
        return state;
    }


}
