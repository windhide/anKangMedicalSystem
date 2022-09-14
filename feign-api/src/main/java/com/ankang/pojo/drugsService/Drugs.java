package com.ankang.pojo.drugsService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName drugs
 */
@TableName(value = "drugs")
@Data
public class Drugs implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsId;

    /**
     *
     */
    private String drugsName;

    /**
     *
     */
    private Integer drugsTypeId;

    /**
     *
     */
    private DrugsType drugsType;

    /**
     *
     */
    private String drugsSpecifications;

    /**
     *
     */
    private Integer drugsUnitid;

    /**
     *
     */
    private DrugsUnit drugsUnit;

    /**
     *
     */
    private String drugsPlace;

    /**
     *
     */
    private String drugsOriginPrice;

    /**
     *
     */
    private String drugsRetailPrice;

    /**
     *
     */
    private String drugsCreatTime;


}