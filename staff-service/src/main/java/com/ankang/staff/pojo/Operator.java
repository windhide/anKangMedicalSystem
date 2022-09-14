package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName operator
 */
@TableName(value ="operator")
@Data
public class Operator implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer operatorid;

    /**
     * 
     */
    private Integer staffid;

    /**
     * 
     */
    private Integer drugsid;

    /**
     * 
     */
    private Integer operatortypeid;

    /**
     * 
     */
    private String operatorcreattime;

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
        Operator other = (Operator) that;
        return (this.getOperatorid() == null ? other.getOperatorid() == null : this.getOperatorid().equals(other.getOperatorid()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getDrugsid() == null ? other.getDrugsid() == null : this.getDrugsid().equals(other.getDrugsid()))
            && (this.getOperatortypeid() == null ? other.getOperatortypeid() == null : this.getOperatortypeid().equals(other.getOperatortypeid()))
            && (this.getOperatorcreattime() == null ? other.getOperatorcreattime() == null : this.getOperatorcreattime().equals(other.getOperatorcreattime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperatorid() == null) ? 0 : getOperatorid().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getDrugsid() == null) ? 0 : getDrugsid().hashCode());
        result = prime * result + ((getOperatortypeid() == null) ? 0 : getOperatortypeid().hashCode());
        result = prime * result + ((getOperatorcreattime() == null) ? 0 : getOperatorcreattime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operatorid=").append(operatorid);
        sb.append(", staffid=").append(staffid);
        sb.append(", drugsid=").append(drugsid);
        sb.append(", operatortypeid=").append(operatortypeid);
        sb.append(", operatorcreattime=").append(operatorcreattime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}