package com.ankang.drugs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName drugs
 */
@TableName(value ="drugs")
@Data
public class Drugs implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer drugsid;

    /**
     * 
     */
    private String drugsname;

    /**
     * 
     */
    private Integer drugstypeid;

    /**
     * 
     */
    private String drugsspecifications;

    /**
     * 
     */
    private Integer drugsunitid;

    /**
     * 
     */
    private String drugsplace;

    /**
     * 
     */
    private String drugsoriginprice;

    /**
     * 
     */
    private String drugsretailprice;

    /**
     * 
     */
    private String drugscreattime;

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
        return (this.getDrugsid() == null ? other.getDrugsid() == null : this.getDrugsid().equals(other.getDrugsid()))
            && (this.getDrugsname() == null ? other.getDrugsname() == null : this.getDrugsname().equals(other.getDrugsname()))
            && (this.getDrugstypeid() == null ? other.getDrugstypeid() == null : this.getDrugstypeid().equals(other.getDrugstypeid()))
            && (this.getDrugsspecifications() == null ? other.getDrugsspecifications() == null : this.getDrugsspecifications().equals(other.getDrugsspecifications()))
            && (this.getDrugsunitid() == null ? other.getDrugsunitid() == null : this.getDrugsunitid().equals(other.getDrugsunitid()))
            && (this.getDrugsplace() == null ? other.getDrugsplace() == null : this.getDrugsplace().equals(other.getDrugsplace()))
            && (this.getDrugsoriginprice() == null ? other.getDrugsoriginprice() == null : this.getDrugsoriginprice().equals(other.getDrugsoriginprice()))
            && (this.getDrugsretailprice() == null ? other.getDrugsretailprice() == null : this.getDrugsretailprice().equals(other.getDrugsretailprice()))
            && (this.getDrugscreattime() == null ? other.getDrugscreattime() == null : this.getDrugscreattime().equals(other.getDrugscreattime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugsid() == null) ? 0 : getDrugsid().hashCode());
        result = prime * result + ((getDrugsname() == null) ? 0 : getDrugsname().hashCode());
        result = prime * result + ((getDrugstypeid() == null) ? 0 : getDrugstypeid().hashCode());
        result = prime * result + ((getDrugsspecifications() == null) ? 0 : getDrugsspecifications().hashCode());
        result = prime * result + ((getDrugsunitid() == null) ? 0 : getDrugsunitid().hashCode());
        result = prime * result + ((getDrugsplace() == null) ? 0 : getDrugsplace().hashCode());
        result = prime * result + ((getDrugsoriginprice() == null) ? 0 : getDrugsoriginprice().hashCode());
        result = prime * result + ((getDrugsretailprice() == null) ? 0 : getDrugsretailprice().hashCode());
        result = prime * result + ((getDrugscreattime() == null) ? 0 : getDrugscreattime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugsid=").append(drugsid);
        sb.append(", drugsname=").append(drugsname);
        sb.append(", drugstypeid=").append(drugstypeid);
        sb.append(", drugsspecifications=").append(drugsspecifications);
        sb.append(", drugsunitid=").append(drugsunitid);
        sb.append(", drugsplace=").append(drugsplace);
        sb.append(", drugsoriginprice=").append(drugsoriginprice);
        sb.append(", drugsretailprice=").append(drugsretailprice);
        sb.append(", drugscreattime=").append(drugscreattime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}