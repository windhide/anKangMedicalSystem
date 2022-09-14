package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName operatorType
 */
@TableName(value ="operatorType")
@Data
public class Operatortype implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer operatortypeid;

    /**
     * 
     */
    private String operatortypename;

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
        Operatortype other = (Operatortype) that;
        return (this.getOperatortypeid() == null ? other.getOperatortypeid() == null : this.getOperatortypeid().equals(other.getOperatortypeid()))
            && (this.getOperatortypename() == null ? other.getOperatortypename() == null : this.getOperatortypename().equals(other.getOperatortypename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperatortypeid() == null) ? 0 : getOperatortypeid().hashCode());
        result = prime * result + ((getOperatortypename() == null) ? 0 : getOperatortypename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operatortypeid=").append(operatortypeid);
        sb.append(", operatortypename=").append(operatortypename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}