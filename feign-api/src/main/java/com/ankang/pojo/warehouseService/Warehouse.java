package com.ankang.pojo.warehouseService;

import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Pharmacy;
import com.ankang.pojo.staffService.Staff;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
    @TableField(exist = false)
    private Staff staff;

    /**
     *
     */
    private Integer drugsId;

    /**
     *
     */
    @TableField(exist = false)
    private Drugs drugs;
    /**
     *
     */
    private Integer pharmacyId;

    /**
     *
     */
    @TableField(exist = false)
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
    @TableField(exist = false)
    private WarehouseType warehouseType;
}