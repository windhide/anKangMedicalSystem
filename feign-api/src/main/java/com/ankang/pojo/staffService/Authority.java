package com.ankang.pojo.staffService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName authority
 */
@TableName(value = "authority")
@Data
public class Authority implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer authorityId;
    /**
     *
     */
    private String authorityName;
}