package com.ankang.drugs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName drugs_unit
 */
@TableName(value = "drugs_unit")
@Data
public class DrugsUnit implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsUnitId;

    /**
     *
     */
    private String drugsUnitName;

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
        DrugsUnit other = (DrugsUnit) that;
        return (this.getDrugsUnitId() == null ? other.getDrugsUnitId() == null : this.getDrugsUnitId().equals(other.getDrugsUnitId()))
                && (this.getDrugsUnitName() == null ? other.getDrugsUnitName() == null : this.getDrugsUnitName().equals(other.getDrugsUnitName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugsUnitId() == null) ? 0 : getDrugsUnitId().hashCode());
        result = prime * result + ((getDrugsUnitName() == null) ? 0 : getDrugsUnitName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugsUnitId=").append(drugsUnitId);
        sb.append(", drugsUnitName=").append(drugsUnitName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}