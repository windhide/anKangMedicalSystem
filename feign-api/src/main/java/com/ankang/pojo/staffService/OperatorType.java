package com.ankang.pojo.staffService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName operator_type
 */
@TableName(value = "operator_type")
@Data
public class OperatorType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer operatorTypeId;

    /**
     *
     */
    private String operatorTypeName;
}