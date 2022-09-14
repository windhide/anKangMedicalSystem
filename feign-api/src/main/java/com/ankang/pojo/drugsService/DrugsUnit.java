package com.ankang.pojo.drugsService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName drugs_unit
 */
@TableName(value = "drugs_unit")
@Data
public class DrugsUnit implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsUnitId;

    /**
     *
     */
    private String drugsUnitName;


}