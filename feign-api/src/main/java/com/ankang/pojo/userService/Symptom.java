package com.ankang.pojo.userService;

import com.ankang.pojo.staffService.Staff;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName symptom
 */
@TableName(value = "symptom")
@Data
public class Symptom implements Serializable {
    /**
     *
     */
    @TableId
    private Integer symptomId;

    /**
     *
     */
    private String symptomContext;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    @TableField(exist = false)
    private User user;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    @TableField(exist = false)
    private Staff staff;

    /**
     *
     */
    private String createTime;
}