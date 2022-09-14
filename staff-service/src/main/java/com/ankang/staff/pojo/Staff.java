package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName staff
 */
@TableName(value ="staff")
@Data
public class Staff implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer staffid;

    /**
     * 
     */
    private String staffname;

    /**
     * 
     */
    private String staffsex;

    /**
     * 
     */
    private String staffphone;

    /**
     * 
     */
    private Integer pharmacyid;

    /**
     * 
     */
    private Integer authorityid;

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
        Staff other = (Staff) that;
        return (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getStaffname() == null ? other.getStaffname() == null : this.getStaffname().equals(other.getStaffname()))
            && (this.getStaffsex() == null ? other.getStaffsex() == null : this.getStaffsex().equals(other.getStaffsex()))
            && (this.getStaffphone() == null ? other.getStaffphone() == null : this.getStaffphone().equals(other.getStaffphone()))
            && (this.getPharmacyid() == null ? other.getPharmacyid() == null : this.getPharmacyid().equals(other.getPharmacyid()))
            && (this.getAuthorityid() == null ? other.getAuthorityid() == null : this.getAuthorityid().equals(other.getAuthorityid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getStaffname() == null) ? 0 : getStaffname().hashCode());
        result = prime * result + ((getStaffsex() == null) ? 0 : getStaffsex().hashCode());
        result = prime * result + ((getStaffphone() == null) ? 0 : getStaffphone().hashCode());
        result = prime * result + ((getPharmacyid() == null) ? 0 : getPharmacyid().hashCode());
        result = prime * result + ((getAuthorityid() == null) ? 0 : getAuthorityid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffid=").append(staffid);
        sb.append(", staffname=").append(staffname);
        sb.append(", staffsex=").append(staffsex);
        sb.append(", staffphone=").append(staffphone);
        sb.append(", pharmacyid=").append(pharmacyid);
        sb.append(", authorityid=").append(authorityid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}