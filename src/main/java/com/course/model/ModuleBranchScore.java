package com.course.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ModuleBranchScore implements Serializable {
    private Integer moduleBranchScoreId;

    private String stuNo;

    private Integer moduleBranchId;

    private BigDecimal point;

    private static final long serialVersionUID = 1L;

    public Integer getModuleBranchScoreId() {
        return moduleBranchScoreId;
    }

    public void setModuleBranchScoreId(Integer moduleBranchScoreId) {
        this.moduleBranchScoreId = moduleBranchScoreId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public Integer getModuleBranchId() {
        return moduleBranchId;
    }

    public void setModuleBranchId(Integer moduleBranchId) {
        this.moduleBranchId = moduleBranchId;
    }

    public BigDecimal getPoint() {
        return point;
    }

    public void setPoint(BigDecimal point) {
        this.point = point;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moduleBranchScoreId=").append(moduleBranchScoreId);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", moduleBranchId=").append(moduleBranchId);
        sb.append(", point=").append(point);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}