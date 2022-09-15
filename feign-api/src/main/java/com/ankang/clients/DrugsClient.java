package com.ankang.clients;

import com.ankang.pojo.drugsService.Drugs;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "drugs-service")
public interface DrugsClient {

    @RequestMapping("drugs/select/list")
    List<Drugs> queryDrugsForList();

    @RequestMapping("drugs/select/{drugsId}")
    Drugs queryDrugsById(@PathVariable("drugsId") Integer drugsId);

}
