package com.ankang.drugs.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName drugsType
 */
@TableName(value ="drugsType")
@Data
public class Drugstype implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer drugstypeid;

    /**
     * 
     */
    private String drugstypename;

    /**
     * 
     */
    private String drugstypecreattime;

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
        Drugstype other = (Drugstype) that;
        return (this.getDrugstypeid() == null ? other.getDrugstypeid() == null : this.getDrugstypeid().equals(other.getDrugstypeid()))
            && (this.getDrugstypename() == null ? other.getDrugstypename() == null : this.getDrugstypename().equals(other.getDrugstypename()))
            && (this.getDrugstypecreattime() == null ? other.getDrugstypecreattime() == null : this.getDrugstypecreattime().equals(other.getDrugstypecreattime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDrugstypeid() == null) ? 0 : getDrugstypeid().hashCode());
        result = prime * result + ((getDrugstypename() == null) ? 0 : getDrugstypename().hashCode());
        result = prime * result + ((getDrugstypecreattime() == null) ? 0 : getDrugstypecreattime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", drugstypeid=").append(drugstypeid);
        sb.append(", drugstypename=").append(drugstypename);
        sb.append(", drugstypecreattime=").append(drugstypecreattime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}