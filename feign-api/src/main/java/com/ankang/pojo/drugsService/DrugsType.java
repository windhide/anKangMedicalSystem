package com.ankang.pojo.drugsService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName drugs_type
 */
@TableName(value = "drugs_type")
@Data
public class DrugsType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsTypeId;

    /**
     *
     */
    private String drugsTypeName;

    /**
     *
     */
    private String drugsTypeCreatTime;

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
        DrugsType other = (DrugsType) that;
        return (this.getDrugsTypeId() == null ? other.getDrugsTypeId() == null : this.getDrugsTypeId().equals(other.getDrugsTypeId()))
                && (this.getDrugsTypeName() == null ? other.getDrugsTypeName() == null : this.getDrugsTypeName().equals(other.getDrugsTypeName()))
                && (this.getDrugsTypeCreatTime() == null ? other.getDrugsTypeCreatTime() == null : this.getDrugsTypeCreatTime().equals(other.getDrugsTypeCreatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugsTypeId() == null) ? 0 : getDrugsTypeId().hashCode());
        result = prime * result + ((getDrugsTypeName() == null) ? 0 : getDrugsTypeName().hashCode());
        result = prime * result + ((getDrugsTypeCreatTime() == null) ? 0 : getDrugsTypeCreatTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugsTypeId=").append(drugsTypeId);
        sb.append(", drugsTypeName=").append(drugsTypeName);
        sb.append(", drugsTypeCreatTime=").append(drugsTypeCreatTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}