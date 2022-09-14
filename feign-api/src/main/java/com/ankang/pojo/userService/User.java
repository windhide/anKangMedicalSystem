package com.ankang.pojo.userService;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user
 */
@TableName(value = "user")
@Data
public class User implements Serializable {
    /**
     *
     */
    @TableId
    private Integer userId;

    /**
     *
     */
    private String userName;

    /**
     *
     */
    private String userSex;

    /**
     *
     */
    private String userPhone;

    /**
     *
     */
    private Integer userLevelTypeId;

    /**
     *
     */
    private UserLevelType userLevelType;

    /**
     *
     */
    private String createTime;
}