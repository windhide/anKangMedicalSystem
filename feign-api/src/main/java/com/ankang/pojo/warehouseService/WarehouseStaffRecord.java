package com.ankang.pojo.warehouseService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName warehouse_staff_record
 */
@TableName(value = "warehouse_staff_record")
@Data
public class WarehouseStaffRecord implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer warehouseStaffRecordId;

    /**
     *
     */
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
    private Integer warehouseTypeId;

    /**
     *
     */
    private Long drugsCount;

    /**
     *
     */
    private String createTime;

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
        WarehouseStaffRecord other = (WarehouseStaffRecord) that;
        return (this.getWarehouseStaffRecordId() == null ? other.getWarehouseStaffRecordId() == null : this.getWarehouseStaffRecordId().equals(other.getWarehouseStaffRecordId()))
                && (this.getWarehouseId() == null ? other.getWarehouseId() == null : this.getWarehouseId().equals(other.getWarehouseId()))
                && (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getDrugsId() == null ? other.getDrugsId() == null : this.getDrugsId().equals(other.getDrugsId()))
                && (this.getWarehouseTypeId() == null ? other.getWarehouseTypeId() == null : this.getWarehouseTypeId().equals(other.getWarehouseTypeId()))
                && (this.getDrugsCount() == null ? other.getDrugsCount() == null : this.getDrugsCount().equals(other.getDrugsCount()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehouseStaffRecordId() == null) ? 0 : getWarehouseStaffRecordId().hashCode());
        result = prime * result + ((getWarehouseId() == null) ? 0 : getWarehouseId().hashCode());
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getDrugsId() == null) ? 0 : getDrugsId().hashCode());
        result = prime * result + ((getWarehouseTypeId() == null) ? 0 : getWarehouseTypeId().hashCode());
        result = prime * result + ((getDrugsCount() == null) ? 0 : getDrugsCount().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehouseStaffRecordId=").append(warehouseStaffRecordId);
        sb.append(", warehouseId=").append(warehouseId);
        sb.append(", staffId=").append(staffId);
        sb.append(", drugsId=").append(drugsId);
        sb.append(", warehouseTypeId=").append(warehouseTypeId);
        sb.append(", drugsCount=").append(drugsCount);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}