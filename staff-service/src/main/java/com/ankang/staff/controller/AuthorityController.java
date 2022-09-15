package com.ankang.staff.controller;

import com.ankang.pojo.staffService.Authority;
import com.ankang.staff.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("authority")
public class AuthorityController {
    @Autowired
    AuthorityService authorityService;

    @RequestMapping("select/list")
    public List<Authority> queryAuthorityForList() {
        return authorityService.list();
    }

    @RequestMapping("select/{authorityId}")
    public Authority queryAuthorityById(@PathVariable("authorityId") Integer authorityId) {
        return authorityService.getById(authorityId);
    }

    @RequestMapping("update/{authority}")
    public boolean updateAuthorityById(@PathVariable("authority") Authority authority) {
        return authorityService.updateById(authority);
    }

    @RequestMapping("remove/{authorityId}")
    public boolean deleteAuthorityById(@PathVariable("authorityId") Integer authorityId) {
        return authorityService.removeById(authorityId);
    }

    @RequestMapping("insert/{authority}")
    public boolean insertAuthority(@PathVariable("authority") Authority authority) {
        return authorityService.save(authority);
    }
}
