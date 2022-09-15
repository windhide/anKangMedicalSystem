package com.ankang.clients;

import com.ankang.pojo.staffService.Pharmacy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "drugs-service", contextId="pharmacyClient")
public interface PharmacyClient {

    @RequestMapping("pharmacy/select/list")
    List<Pharmacy> queryPharmacyForList();

    @RequestMapping("pharmacy/select/{pharmacyId}")
    Pharmacy queryPharmacyById(@PathVariable("pharmacyId") Integer pharmacyId);
}
