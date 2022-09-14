package com.ankang.user.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName symptom
 */
@TableName(value = "symptom")
@Data
public class Symptom implements Serializable {
    /**
     *
     */
    @TableId
    private Integer symptomId;

    /**
     *
     */
    private String symptomContext;

    /**
     *
     */
    private Integer userId;

    /**
     *
     */
    private Integer staffId;

    /**
     *
     */
    private String createTime;

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
        return (this.getSymptomId() == null ? other.getSymptomId() == null : this.getSymptomId().equals(other.getSymptomId()))
                && (this.getSymptomContext() == null ? other.getSymptomContext() == null : this.getSymptomContext().equals(other.getSymptomContext()))
                && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
                && (this.getStaffId() == null ? other.getStaffId() == null : this.getStaffId().equals(other.getStaffId()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSymptomId() == null) ? 0 : getSymptomId().hashCode());
        result = prime * result + ((getSymptomContext() == null) ? 0 : getSymptomContext().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getStaffId() == null) ? 0 : getStaffId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", symptomId=").append(symptomId);
        sb.append(", symptomContext=").append(symptomContext);
        sb.append(", userId=").append(userId);
        sb.append(", staffId=").append(staffId);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}