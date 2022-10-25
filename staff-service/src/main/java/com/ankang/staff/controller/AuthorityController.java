package com.ankang.staff.controller;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import com.ankang.pojo.staffService.Authority;
import com.ankang.staff.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("authority")
public class AuthorityController {

    String redisKey = "authority";
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    AuthorityService authorityService;

    @RequestMapping("select/list")
    public Object queryAuthorityForList() {
        Object cacheData = stringRedisTemplate.opsForValue().get(redisKey);
        if (Objects.equals(cacheData, "") || cacheData == null) {
            return cacheReload();
        }
        return cacheData;
    }

    @RequestMapping("select/{authorityId}")
    public Authority queryAuthorityById(@PathVariable("authorityId") Integer authorityId) {
        return authorityService.getById(authorityId);
    }

    @RequestMapping("update")
    public boolean updateAuthorityById(@RequestBody Authority authority) {
        if (authorityService.updateById(authority)) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("remove")
    public boolean deleteAuthorityById(@RequestBody Authority authority) {
        if (authorityService.removeById(authority.getAuthorityId())) {
            cacheReload();
            return true;
        }
        return false;
    }

    @RequestMapping("insert")
    public boolean insertAuthority(@RequestBody Authority authority) {
        if (authorityService.save(authority)) {
            cacheReload();
            return true;
        }
        return false;
    }

    public Object cacheReload() {
        List<Authority> authorityList = authorityService.list();
        stringRedisTemplate.opsForValue().set(redisKey, JSON.toJSON(authorityList).toString(), FullConfig.timeout, TimeUnit.SECONDS);
        return authorityList;
    }
}
