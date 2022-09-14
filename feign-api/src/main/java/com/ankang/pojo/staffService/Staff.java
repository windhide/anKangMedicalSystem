package com.ankang.pojo.staffService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName staff
 */
@TableName(value = "staff")
@Data
public class Staff implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer staffId;

    /**
     *
     */
    private String staffName;

    /**
     *
     */
    private String staffSex;

    /**
     *
     */
    private String staffPhone;

    /**
     *
     */
    private Integer pharmacyId;

    /**
     *
     */
    private Integer authorityId;

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
        return (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getStaffName() == null ? other.getStaffName() == null : this.getStaffName().equals(other.getStaffName()))
                && (this.getStaffSex() == null ? other.getStaffSex() == null : this.getStaffSex().equals(other.getStaffSex()))
                && (this.getStaffPhone() == null ? other.getStaffPhone() == null : this.getStaffPhone().equals(other.getStaffPhone()))
                && (this.getPharmacyId() == null ? other.getPharmacyId() == null : this.getPharmacyId().equals(other.getPharmacyId()))
                && (this.getAuthorityId() == null ? other.getAuthorityId() == null : this.getAuthorityId().equals(other.getAuthorityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getStaffName() == null) ? 0 : getStaffName().hashCode());
        result = prime * result + ((getStaffSex() == null) ? 0 : getStaffSex().hashCode());
        result = prime * result + ((getStaffPhone() == null) ? 0 : getStaffPhone().hashCode());
        result = prime * result + ((getPharmacyId() == null) ? 0 : getPharmacyId().hashCode());
        result = prime * result + ((getAuthorityId() == null) ? 0 : getAuthorityId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", staffId=").append(staffId);
        sb.append(", staffName=").append(staffName);
        sb.append(", staffSex=").append(staffSex);
        sb.append(", staffPhone=").append(staffPhone);
        sb.append(", pharmacyId=").append(pharmacyId);
        sb.append(", authorityId=").append(authorityId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}