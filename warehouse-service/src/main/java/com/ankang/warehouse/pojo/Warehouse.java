package com.ankang.warehouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

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
    private Integer warehouseid;

    /**
     * 
     */
    private Integer staffid;

    /**
     * 
     */
    private Integer drugsid;

    /**
     * 
     */
    private Integer pharmacyid;

    /**
     * 
     */
    private Long drugscount;

    /**
     * 
     */
    private Integer warehousetypeid;

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
        return (this.getWarehouseid() == null ? other.getWarehouseid() == null : this.getWarehouseid().equals(other.getWarehouseid()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getDrugsid() == null ? other.getDrugsid() == null : this.getDrugsid().equals(other.getDrugsid()))
            && (this.getPharmacyid() == null ? other.getPharmacyid() == null : this.getPharmacyid().equals(other.getPharmacyid()))
            && (this.getDrugscount() == null ? other.getDrugscount() == null : this.getDrugscount().equals(other.getDrugscount()))
            && (this.getWarehousetypeid() == null ? other.getWarehousetypeid() == null : this.getWarehousetypeid().equals(other.getWarehousetypeid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehouseid() == null) ? 0 : getWarehouseid().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getDrugsid() == null) ? 0 : getDrugsid().hashCode());
        result = prime * result + ((getPharmacyid() == null) ? 0 : getPharmacyid().hashCode());
        result = prime * result + ((getDrugscount() == null) ? 0 : getDrugscount().hashCode());
        result = prime * result + ((getWarehousetypeid() == null) ? 0 : getWarehousetypeid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehouseid=").append(warehouseid);
        sb.append(", staffid=").append(staffid);
        sb.append(", drugsid=").append(drugsid);
        sb.append(", pharmacyid=").append(pharmacyid);
        sb.append(", drugscount=").append(drugscount);
        sb.append(", warehousetypeid=").append(warehousetypeid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}