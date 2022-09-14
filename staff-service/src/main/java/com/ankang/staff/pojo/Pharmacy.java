package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName pharmacy
 */
@TableName(value = "pharmacy")
@Data
public class Pharmacy implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer pharmacyId;

    /**
     *
     */
    private String pharmacyName;

    /**
     *
     */
    private String pharmacyPhone;

    /**
     *
     */
    private String pharmacyAddress;

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
        Pharmacy other = (Pharmacy) that;
        return (this.getPharmacyId() == null ? other.getPharmacyId() == null : this.getPharmacyId().equals(other.getPharmacyId()))
                && (this.getPharmacyName() == null ? other.getPharmacyName() == null : this.getPharmacyName().equals(other.getPharmacyName()))
                && (this.getPharmacyPhone() == null ? other.getPharmacyPhone() == null : this.getPharmacyPhone().equals(other.getPharmacyPhone()))
                && (this.getPharmacyAddress() == null ? other.getPharmacyAddress() == null : this.getPharmacyAddress().equals(other.getPharmacyAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPharmacyId() == null) ? 0 : getPharmacyId().hashCode());
        result = prime * result + ((getPharmacyName() == null) ? 0 : getPharmacyName().hashCode());
        result = prime * result + ((getPharmacyPhone() == null) ? 0 : getPharmacyPhone().hashCode());
        result = prime * result + ((getPharmacyAddress() == null) ? 0 : getPharmacyAddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pharmacyId=").append(pharmacyId);
        sb.append(", pharmacyName=").append(pharmacyName);
        sb.append(", pharmacyPhone=").append(pharmacyPhone);
        sb.append(", pharmacyAddress=").append(pharmacyAddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}