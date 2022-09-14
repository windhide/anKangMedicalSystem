package com.ankang.pojo.warehouseService;

import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Staff;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName warehouse_staff_record
 */
@TableName(value = "warehouse_staff_record")
@Data
public class WarehouseStaffRecord implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer warehouseStaffRecordId;

    /**
     *
     */
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
    private Integer warehouseTypeId;

    /**
     *
     */
    private WarehouseType warehouseType;

    /**
     *
     */
    private Long drugsCount;

    /**
     *
     */
    private String createTime;
}