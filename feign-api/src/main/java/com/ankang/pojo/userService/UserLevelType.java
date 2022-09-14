package com.ankang.pojo.userService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user_level_type
 */
@TableName(value = "user_level_type")
@Data
public class UserLevelType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer userLevelTypeId;

    /**
     *
     */
    private String userLevelTypeName;


}