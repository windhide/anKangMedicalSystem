package com.ankang.pojo.warehouseService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName warehouse_type
 */
@TableName(value = "warehouse_type")
@Data
public class WarehouseType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer warehouseTypeId;

    /**
     *
     */
    private String warehouseTypeName;
}