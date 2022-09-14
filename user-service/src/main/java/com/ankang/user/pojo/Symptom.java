package com.ankang.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName symptom
 */
@TableName(value ="symptom")
@Data
public class Symptom implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer symptomid;

    /**
     * 
     */
    private String symptomcontext;

    /**
     * 
     */
    private Integer userid;

    /**
     * 
     */
    private Integer staffid;

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
        Symptom other = (Symptom) that;
        return (this.getSymptomid() == null ? other.getSymptomid() == null : this.getSymptomid().equals(other.getSymptomid()))
            && (this.getSymptomcontext() == null ? other.getSymptomcontext() == null : this.getSymptomcontext().equals(other.getSymptomcontext()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getStaffid() == null ? other.getStaffid() == null : this.getStaffid().equals(other.getStaffid()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSymptomid() == null) ? 0 : getSymptomid().hashCode());
        result = prime * result + ((getSymptomcontext() == null) ? 0 : getSymptomcontext().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getStaffid() == null) ? 0 : getStaffid().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", symptomid=").append(symptomid);
        sb.append(", symptomcontext=").append(symptomcontext);
        sb.append(", userid=").append(userid);
        sb.append(", staffid=").append(staffid);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}