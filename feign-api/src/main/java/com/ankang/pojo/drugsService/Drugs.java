package com.ankang.pojo.drugsService;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName drugs
 */
@TableName(value = "drugs")
@Data
public class Drugs implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsId;

    /**
     *
     */
    private String drugsName;

    /**
     *
     */
    private Integer drugsTypeId;

    /**
     *
     */
    private String drugsSpecifications;

    /**
     *
     */
    private Integer drugsUnitid;

    /**
     *
     */
    private String drugsPlace;

    /**
     *
     */
    private String drugsOriginPrice;

    /**
     *
     */
    private String drugsRetailPrice;

    /**
     *
     */
    private String drugsCreatTime;

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
        Drugs other = (Drugs) that;
        return (this.getDrugsId() == null ? other.getDrugsId() == null : this.getDrugsId().equals(other.getDrugsId()))
                && (this.getDrugsName() == null ? other.getDrugsName() == null : this.getDrugsName().equals(other.getDrugsName()))
                && (this.getDrugsTypeId() == null ? other.getDrugsTypeId() == null : this.getDrugsTypeId().equals(other.getDrugsTypeId()))
                && (this.getDrugsSpecifications() == null ? other.getDrugsSpecifications() == null : this.getDrugsSpecifications().equals(other.getDrugsSpecifications()))
                && (this.getDrugsUnitid() == null ? other.getDrugsUnitid() == null : this.getDrugsUnitid().equals(other.getDrugsUnitid()))
                && (this.getDrugsPlace() == null ? other.getDrugsPlace() == null : this.getDrugsPlace().equals(other.getDrugsPlace()))
                && (this.getDrugsOriginPrice() == null ? other.getDrugsOriginPrice() == null : this.getDrugsOriginPrice().equals(other.getDrugsOriginPrice()))
                && (this.getDrugsRetailPrice() == null ? other.getDrugsRetailPrice() == null : this.getDrugsRetailPrice().equals(other.getDrugsRetailPrice()))
                && (this.getDrugsCreatTime() == null ? other.getDrugsCreatTime() == null : this.getDrugsCreatTime().equals(other.getDrugsCreatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugsId() == null) ? 0 : getDrugsId().hashCode());
        result = prime * result + ((getDrugsName() == null) ? 0 : getDrugsName().hashCode());
        result = prime * result + ((getDrugsTypeId() == null) ? 0 : getDrugsTypeId().hashCode());
        result = prime * result + ((getDrugsSpecifications() == null) ? 0 : getDrugsSpecifications().hashCode());
        result = prime * result + ((getDrugsUnitid() == null) ? 0 : getDrugsUnitid().hashCode());
        result = prime * result + ((getDrugsPlace() == null) ? 0 : getDrugsPlace().hashCode());
        result = prime * result + ((getDrugsOriginPrice() == null) ? 0 : getDrugsOriginPrice().hashCode());
        result = prime * result + ((getDrugsRetailPrice() == null) ? 0 : getDrugsRetailPrice().hashCode());
        result = prime * result + ((getDrugsCreatTime() == null) ? 0 : getDrugsCreatTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugsId=").append(drugsId);
        sb.append(", drugsName=").append(drugsName);
        sb.append(", drugsTypeId=").append(drugsTypeId);
        sb.append(", drugsSpecifications=").append(drugsSpecifications);
        sb.append(", drugsUnitid=").append(drugsUnitid);
        sb.append(", drugsPlace=").append(drugsPlace);
        sb.append(", drugsOriginPrice=").append(drugsOriginPrice);
        sb.append(", drugsRetailPrice=").append(drugsRetailPrice);
        sb.append(", drugsCreatTime=").append(drugsCreatTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}