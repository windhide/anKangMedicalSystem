package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName operator
 */
@TableName(value = "operator")
@Data
public class Operator implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer operatorId;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    private Integer drugsId;

    /**
     *
     */
    private Integer operatorTypeId;

    /**
     *
     */
    private String operatorCreatTime;

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
        return (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
                && (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getDrugsId() == null ? other.getDrugsId() == null : this.getDrugsId().equals(other.getDrugsId()))
                && (this.getOperatorTypeId() == null ? other.getOperatorTypeId() == null : this.getOperatorTypeId().equals(other.getOperatorTypeId()))
                && (this.getOperatorCreatTime() == null ? other.getOperatorCreatTime() == null : this.getOperatorCreatTime().equals(other.getOperatorCreatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getDrugsId() == null) ? 0 : getDrugsId().hashCode());
        result = prime * result + ((getOperatorTypeId() == null) ? 0 : getOperatorTypeId().hashCode());
        result = prime * result + ((getOperatorCreatTime() == null) ? 0 : getOperatorCreatTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operatorId=").append(operatorId);
        sb.append(", staffId=").append(staffId);
        sb.append(", drugsId=").append(drugsId);
        sb.append(", operatorTypeId=").append(operatorTypeId);
        sb.append(", operatorCreatTime=").append(operatorCreatTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}