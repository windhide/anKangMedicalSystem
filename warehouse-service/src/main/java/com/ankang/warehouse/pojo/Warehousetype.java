package com.ankang.warehouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName warehouseType
 */
@TableName(value ="warehouseType")
@Data
public class Warehousetype implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer warehousetypeid;

    /**
     * 
     */
    private String warehousetypename;

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
        Warehousetype other = (Warehousetype) that;
        return (this.getWarehousetypeid() == null ? other.getWarehousetypeid() == null : this.getWarehousetypeid().equals(other.getWarehousetypeid()))
            && (this.getWarehousetypename() == null ? other.getWarehousetypename() == null : this.getWarehousetypename().equals(other.getWarehousetypename()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehousetypeid() == null) ? 0 : getWarehousetypeid().hashCode());
        result = prime * result + ((getWarehousetypename() == null) ? 0 : getWarehousetypename().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehousetypeid=").append(warehousetypeid);
        sb.append(", warehousetypename=").append(warehousetypename);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}