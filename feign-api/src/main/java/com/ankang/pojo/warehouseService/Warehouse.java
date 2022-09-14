package com.ankang.pojo.warehouseService;

import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Pharmacy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName warehouse
 */
@TableName(value = "warehouse")
@Data
public class Warehouse implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer warehouseId;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    private Staff staff;
    /**
     *
     */
    private Integer drugsId;

    /**
     *
     */
    private Drugs drugs;
    /**
     *
     */
    private Integer pharmacyId;

    /**
     *
     */
    private Pharmacy pharmacy;

    /**
     *
     */
    private Long drugsCount;

    /**
     *
     */
    private Integer warehouseTypeId;

    /**
     *
     */
    private WarehouseType warehouseType;
}