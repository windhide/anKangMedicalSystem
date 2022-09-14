package com.ankang.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user_level_type
 */
@TableName(value = "user_level_type")
@Data
public class UserLevelType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer userLevelTypeId;

    /**
     *
     */
    private String userLevelTypeName;

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
        UserLevelType other = (UserLevelType) that;
        return (this.getUserLevelTypeId() == null ? other.getUserLevelTypeId() == null : this.getUserLevelTypeId().equals(other.getUserLevelTypeId()))
                && (this.getUserLevelTypeName() == null ? other.getUserLevelTypeName() == null : this.getUserLevelTypeName().equals(other.getUserLevelTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserLevelTypeId() == null) ? 0 : getUserLevelTypeId().hashCode());
        result = prime * result + ((getUserLevelTypeName() == null) ? 0 : getUserLevelTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userLevelTypeId=").append(userLevelTypeId);
        sb.append(", userLevelTypeName=").append(userLevelTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}