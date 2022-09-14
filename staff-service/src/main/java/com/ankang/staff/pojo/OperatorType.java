package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName operator_type
 */
@TableName(value = "operator_type")
@Data
public class OperatorType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer operatorTypeId;

    /**
     *
     */
    private String operatorTypeName;

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
        OperatorType other = (OperatorType) that;
        return (this.getOperatorTypeId() == null ? other.getOperatorTypeId() == null : this.getOperatorTypeId().equals(other.getOperatorTypeId()))
                && (this.getOperatorTypeName() == null ? other.getOperatorTypeName() == null : this.getOperatorTypeName().equals(other.getOperatorTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperatorTypeId() == null) ? 0 : getOperatorTypeId().hashCode());
        result = prime * result + ((getOperatorTypeName() == null) ? 0 : getOperatorTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operatorTypeId=").append(operatorTypeId);
        sb.append(", operatorTypeName=").append(operatorTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}