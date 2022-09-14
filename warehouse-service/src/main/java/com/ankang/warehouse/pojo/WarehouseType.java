package com.ankang.warehouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName warehouse_type
 */
@TableName(value = "warehouse_type")
@Data
public class WarehouseType implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer warehouseTypeId;

    /**
     *
     */
    private String warehouseTypeName;

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
        WarehouseType other = (WarehouseType) that;
        return (this.getWarehouseTypeId() == null ? other.getWarehouseTypeId() == null : this.getWarehouseTypeId().equals(other.getWarehouseTypeId()))
                && (this.getWarehouseTypeName() == null ? other.getWarehouseTypeName() == null : this.getWarehouseTypeName().equals(other.getWarehouseTypeName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehouseTypeId() == null) ? 0 : getWarehouseTypeId().hashCode());
        result = prime * result + ((getWarehouseTypeName() == null) ? 0 : getWarehouseTypeName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehouseTypeId=").append(warehouseTypeId);
        sb.append(", warehouseTypeName=").append(warehouseTypeName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}