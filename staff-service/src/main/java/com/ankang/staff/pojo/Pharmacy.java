package com.ankang.staff.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName pharmacy
 */
@TableName(value ="pharmacy")
@Data
public class Pharmacy implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer pharmacyid;

    /**
     * 
     */
    private String pharmacyname;

    /**
     * 
     */
    private String pharmacyphone;

    /**
     * 
     */
    private String pharmacyaddress;

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
        return (this.getPharmacyid() == null ? other.getPharmacyid() == null : this.getPharmacyid().equals(other.getPharmacyid()))
            && (this.getPharmacyname() == null ? other.getPharmacyname() == null : this.getPharmacyname().equals(other.getPharmacyname()))
            && (this.getPharmacyphone() == null ? other.getPharmacyphone() == null : this.getPharmacyphone().equals(other.getPharmacyphone()))
            && (this.getPharmacyaddress() == null ? other.getPharmacyaddress() == null : this.getPharmacyaddress().equals(other.getPharmacyaddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPharmacyid() == null) ? 0 : getPharmacyid().hashCode());
        result = prime * result + ((getPharmacyname() == null) ? 0 : getPharmacyname().hashCode());
        result = prime * result + ((getPharmacyphone() == null) ? 0 : getPharmacyphone().hashCode());
        result = prime * result + ((getPharmacyaddress() == null) ? 0 : getPharmacyaddress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pharmacyid=").append(pharmacyid);
        sb.append(", pharmacyname=").append(pharmacyname);
        sb.append(", pharmacyphone=").append(pharmacyphone);
        sb.append(", pharmacyaddress=").append(pharmacyaddress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}