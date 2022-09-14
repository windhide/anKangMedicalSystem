package com.ankang.pojo.drugsService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName drugs_type
 */
@TableName(value = "drugs_type")
@Data
public class DrugsType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsTypeId;
    /**
     *
     */
    private String drugsTypeName;

    /**
     *
     */
    private String drugsTypeCreatTime;

}