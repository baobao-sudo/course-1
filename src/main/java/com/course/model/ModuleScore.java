package com.course.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ModuleScore implements Serializable {
    private Integer moduleScoreId;

    private String stuNo;

    private Integer moduleId;

    private BigDecimal point;

    private Integer moduleScoreStatus;

    private static final long serialVersionUID = 1L;

    public Integer getModuleScoreId() {
        return moduleScoreId;
    }

    public void setModuleScoreId(Integer moduleScoreId) {
        this.moduleScoreId = moduleScoreId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    public Integer getModuleScoreStatus() {
        return moduleScoreStatus;
    }

    public void setModuleScoreStatus(Integer moduleScoreStatus) {
        this.moduleScoreStatus = moduleScoreStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moduleScoreId=").append(moduleScoreId);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", point=").append(point);
        sb.append(", moduleScoreStatus=").append(moduleScoreStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}