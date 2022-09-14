package com.ankang.pojo.userService;

import com.ankang.pojo.drugsService.Drugs;
import com.ankang.pojo.staffService.Staff;
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
    private User user;

    /**
     *
     */
    private Integer drugId;

    /**
     *
     */
    private Drugs drugs;

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
    private Long purchaseCount;

    /**
     *
     */
    private String createTime;
}