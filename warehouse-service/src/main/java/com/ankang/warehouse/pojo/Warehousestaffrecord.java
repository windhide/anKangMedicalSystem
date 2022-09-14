package com.ankang.warehouse.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName warehouseStaffRecord
 */
@TableName(value ="warehouseStaffRecord")
@Data
public class Warehousestaffrecord implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer warehousestaffrecordid;

    /**
     * 
     */
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
    private Integer warehousetypeid;

    /**
     * 
     */
    private Long drugscount;

    /**
     * 
     */
    private String createtime;

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
        Warehousestaffrecord other = (Warehousestaffrecord) that;
        return (this.getWarehousestaffrecordid() == null ? other.getWarehousestaffrecordid() == null : this.getWarehousestaffrecordid().equals(other.getWarehousestaffrecordid()))
            && (this.getWarehouseid() == null ? other.getWarehouseid() == null : this.getWarehouseid().equals(other.getWarehouseid()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getDrugsid() == null ? other.getDrugsid() == null : this.getDrugsid().equals(other.getDrugsid()))
            && (this.getWarehousetypeid() == null ? other.getWarehousetypeid() == null : this.getWarehousetypeid().equals(other.getWarehousetypeid()))
            && (this.getDrugscount() == null ? other.getDrugscount() == null : this.getDrugscount().equals(other.getDrugscount()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWarehousestaffrecordid() == null) ? 0 : getWarehousestaffrecordid().hashCode());
        result = prime * result + ((getWarehouseid() == null) ? 0 : getWarehouseid().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getDrugsid() == null) ? 0 : getDrugsid().hashCode());
        result = prime * result + ((getWarehousetypeid() == null) ? 0 : getWarehousetypeid().hashCode());
        result = prime * result + ((getDrugscount() == null) ? 0 : getDrugscount().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", warehousestaffrecordid=").append(warehousestaffrecordid);
        sb.append(", warehouseid=").append(warehouseid);
        sb.append(", staffid=").append(staffid);
        sb.append(", drugsid=").append(drugsid);
        sb.append(", warehousetypeid=").append(warehousetypeid);
        sb.append(", drugscount=").append(drugscount);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}