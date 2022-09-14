package com.ankang.pojo.staffService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName pharmacy
 */
@TableName(value = "pharmacy")
@Data
public class Pharmacy implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer pharmacyId;

    /**
     *
     */
    private String pharmacyName;

    /**
     *
     */
    private String pharmacyPhone;

    /**
     *
     */
    private String pharmacyAddress;
}