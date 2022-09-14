package com.ankang.pojo.userService;

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
    private User user;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    private Staff staff;

    /**
     *
     */
    private String createTime;
}