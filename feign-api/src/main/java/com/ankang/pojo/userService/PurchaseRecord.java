package com.ankang.pojo.userService;

import com.ankang.pojo.staffService.Staff;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName purchase_record
 */
@TableName(value = "purchase_record")
@Data
public class PurchaseRecord implements Serializable {
    /**
     *
     */
    @TableId
    private Integer purchaseRecordId;

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
    private String drugsJson;

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