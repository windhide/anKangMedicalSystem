package com.ankang.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName userLevelType
 */
@TableName(value ="userLevelType")
@Data
public class Userleveltype implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer userleveltypeid;

    /**
     * 
     */
    private String userleveltypename;

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
        Userleveltype other = (Userleveltype) that;
        return (this.getUserleveltypeid() == null ? other.getUserleveltypeid() == null : this.getUserleveltypeid().equals(other.getUserleveltypeid()))
            && (this.getUserleveltypename() == null ? other.getUserleveltypename() == null : this.getUserleveltypename().equals(other.getUserleveltypename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserleveltypeid() == null) ? 0 : getUserleveltypeid().hashCode());
        result = prime * result + ((getUserleveltypename() == null) ? 0 : getUserleveltypename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userleveltypeid=").append(userleveltypeid);
        sb.append(", userleveltypename=").append(userleveltypename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}