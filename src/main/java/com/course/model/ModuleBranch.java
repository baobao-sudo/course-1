package com.course.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ModuleBranch implements Serializable {
    private Integer moduleBranchId;

    private Integer moduleId;

    private String branchName;

    private BigDecimal partition;

    private Integer secondRequirementId;

    private Integer moduleBranchSequence;

    private static final long serialVersionUID = 1L;

    public Integer getModuleBranchId() {
        return moduleBranchId;
    }

    public void setModuleBranchId(Integer moduleBranchId) {
        this.moduleBranchId = moduleBranchId;
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public BigDecimal getPartition() {
        return partition;
    }

    public void setPartition(BigDecimal partition) {
        this.partition = partition;
    }

    public Integer getSecondRequirementId() {
        return secondRequirementId;
    }

    public void setSecondRequirementId(Integer secondRequirementId) {
        this.secondRequirementId = secondRequirementId;
    }

    public Integer getModuleBranchSequence() {
        return moduleBranchSequence;
    }

    public void setModuleBranchSequence(Integer moduleBranchSequence) {
        this.moduleBranchSequence = moduleBranchSequence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", moduleBranchId=").append(moduleBranchId);
        sb.append(", moduleId=").append(moduleId);
        sb.append(", branchName=").append(branchName);
        sb.append(", partition=").append(partition);
        sb.append(", secondRequirementId=").append(secondRequirementId);
        sb.append(", moduleBranchSequence=").append(moduleBranchSequence);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}