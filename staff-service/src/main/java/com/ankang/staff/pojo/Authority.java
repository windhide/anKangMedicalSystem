package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName authority
 */
@TableName(value ="authority")
@Data
public class Authority implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer authorityid;

    /**
     * 
     */
    private String authorityname;

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
        Authority other = (Authority) that;
        return (this.getAuthorityid() == null ? other.getAuthorityid() == null : this.getAuthorityid().equals(other.getAuthorityid()))
            && (this.getAuthorityname() == null ? other.getAuthorityname() == null : this.getAuthorityname().equals(other.getAuthorityname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAuthorityid() == null) ? 0 : getAuthorityid().hashCode());
        result = prime * result + ((getAuthorityname() == null) ? 0 : getAuthorityname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", authorityid=").append(authorityid);
        sb.append(", authorityname=").append(authorityname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}