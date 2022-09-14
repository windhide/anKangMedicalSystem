package com.ankang.warehouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName warehouse
 */
@TableName(value ="warehouse")
@Data
public class Warehouse implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer warehouseId;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    private Integer drugsId;

    /**
     *
     */
    private Integer pharmacyId;

    /**
     *
     */
    private Long drugsCount;

    /**
     *
     */
    private Integer warehouseTypeId;

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
        Warehouse other = (Warehouse) that;
        return (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
                && (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getDrugsId() == null ? other.getDrugsId() == null : this.getDrugsId().equals(other.getDrugsId()))
                && (this.getPharmacyId() == null ? other.getPharmacyId() == null : this.getPharmacyId().equals(other.getPharmacyId()))
                && (this.getDrugsCount() == null ? other.getDrugsCount() == null : this.getDrugsCount().equals(other.getDrugsCount()))
                && (this.getWarehouseTypeId() == null ? other.getWarehouseTypeId() == null : this.getWarehouseTypeId().equals(other.getWarehouseTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getDrugsId() == null) ? 0 : getDrugsId().hashCode());
        result = prime * result + ((getPharmacyId() == null) ? 0 : getPharmacyId().hashCode());
        result = prime * result + ((getDrugsCount() == null) ? 0 : getDrugsCount().hashCode());
        result = prime * result + ((getWarehouseTypeId() == null) ? 0 : getWarehouseTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", staffId=").append(staffId);
        sb.append(", drugsId=").append(drugsId);
        sb.append(", pharmacyId=").append(pharmacyId);
        sb.append(", drugsCount=").append(drugsCount);
        sb.append(", warehouseTypeId=").append(warehouseTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}