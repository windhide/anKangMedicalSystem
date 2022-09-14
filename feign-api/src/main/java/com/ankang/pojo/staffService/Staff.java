package com.ankang.pojo.staffService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName staff
 */
@TableName(value = "staff")
@Data
public class Staff implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer staffId;

    /**
     *
     */
    private String staffName;

    /**
     *
     */
    private String staffSex;

    /**
     *
     */
    private String staffPhone;

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
    private Integer authorityId;

    /**
     *
     */
    private Authority authority;

}