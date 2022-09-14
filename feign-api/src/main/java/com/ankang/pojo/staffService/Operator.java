package com.ankang.pojo.staffService;

import com.ankang.pojo.drugsService.Drugs;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName operator
 */
@TableName(value = "operator")
@Data
public class Operator implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer operatorId;

    /**
     *
     */
    private Integer staffId;

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
    private Integer operatorTypeId;

    /**
     *
     */
    private OperatorType operatorType;

    /**
     *
     */
    private String operatorCreatTime;
}