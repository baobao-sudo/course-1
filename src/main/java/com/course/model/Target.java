package com.course.model;

import java.io.Serializable;

public class Target implements Serializable {
    private Integer targetId;

    private Integer planId;

    private Integer order;

    private String description;

    private String targetName;

    private Integer secondRequirementId;

    private static final long serialVersionUID = 1L;

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName == null ? null : targetName.trim();
    }

    public Integer getSecondRequirementId() {
        return secondRequirementId;
    }

    public void setSecondRequirementId(Integer secondRequirementId) {
        this.secondRequirementId = secondRequirementId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", targetId=").append(targetId);
        sb.append(", planId=").append(planId);
        sb.append(", order=").append(order);
        sb.append(", description=").append(description);
        sb.append(", targetName=").append(targetName);
        sb.append(", secondRequirementId=").append(secondRequirementId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}