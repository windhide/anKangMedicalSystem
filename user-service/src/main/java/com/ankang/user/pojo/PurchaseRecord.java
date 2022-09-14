package com.ankang.user.pojo;

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
    private Integer drugId;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    private Long purchaseCount;

    /**
     *
     */
    private String createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PurchaseRecord other = (PurchaseRecord) that;
        return (this.getPurchaseRecordId() == null ? other.getPurchaseRecordId() == null : this.getPurchaseRecordId().equals(other.getPurchaseRecordId()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getDrugId() == null ? other.getDrugId() == null : this.getDrugId().equals(other.getDrugId()))
                && (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getPurchaseCount() == null ? other.getPurchaseCount() == null : this.getPurchaseCount().equals(other.getPurchaseCount()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPurchaseRecordId() == null) ? 0 : getPurchaseRecordId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDrugId() == null) ? 0 : getDrugId().hashCode());
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getPurchaseCount() == null) ? 0 : getPurchaseCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaseRecordId=").append(purchaseRecordId);
        sb.append(", userId=").append(userId);
        sb.append(", drugId=").append(drugId);
        sb.append(", staffId=").append(staffId);
        sb.append(", purchaseCount=").append(purchaseCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}