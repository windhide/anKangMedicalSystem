package com.ankang.drugs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName drugsUnit
 */
@TableName(value ="drugsUnit")
@Data
public class Drugsunit implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsunitid;

    /**
     * 
     */
    private String drugsunitname;

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
        Drugsunit other = (Drugsunit) that;
        return (this.getDrugsunitid() == null ? other.getDrugsunitid() == null : this.getDrugsunitid().equals(other.getDrugsunitid()))
            && (this.getDrugsunitname() == null ? other.getDrugsunitname() == null : this.getDrugsunitname().equals(other.getDrugsunitname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugsunitid() == null) ? 0 : getDrugsunitid().hashCode());
        result = prime * result + ((getDrugsunitname() == null) ? 0 : getDrugsunitname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugsunitid=").append(drugsunitid);
        sb.append(", drugsunitname=").append(drugsunitname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}