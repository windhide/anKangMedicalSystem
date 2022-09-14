package com.ankang.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName purchaseRecord
 */
@TableName(value ="purchaseRecord")
@Data
public class Purchaserecord implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer purchaserecordid;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private Integer drugid;

    /**
     * 
     */
    private Integer staffid;

    /**
     * 
     */
    private Long purchasecount;

    /**
     * 
     */
    private String createtime;

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
        Purchaserecord other = (Purchaserecord) that;
        return (this.getPurchaserecordid() == null ? other.getPurchaserecordid() == null : this.getPurchaserecordid().equals(other.getPurchaserecordid()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getDrugid() == null ? other.getDrugid() == null : this.getDrugid().equals(other.getDrugid()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getPurchasecount() == null ? other.getPurchasecount() == null : this.getPurchasecount().equals(other.getPurchasecount()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPurchaserecordid() == null) ? 0 : getPurchaserecordid().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getDrugid() == null) ? 0 : getDrugid().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getPurchasecount() == null) ? 0 : getPurchasecount().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", purchaserecordid=").append(purchaserecordid);
        sb.append(", userid=").append(userid);
        sb.append(", drugid=").append(drugid);
        sb.append(", staffid=").append(staffid);
        sb.append(", purchasecount=").append(purchasecount);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}