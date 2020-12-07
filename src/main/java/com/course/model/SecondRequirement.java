package com.course.model;

import java.io.Serializable;

public class SecondRequirement implements Serializable {
    private Integer secondRequirementId;

    private Integer firstRequirementId;

    private Integer firstRequirementNo;

    private Integer secondRequirementNo;

    private String description;

    private static final long serialVersionUID = 1L;

    public Integer getSecondRequirementId() {
        return secondRequirementId;
    }

    public void setSecondRequirementId(Integer secondRequirementId) {
        this.secondRequirementId = secondRequirementId;
    }

    public Integer getFirstRequirementId() {
        return firstRequirementId;
    }

    public void setFirstRequirementId(Integer firstRequirementId) {
        this.firstRequirementId = firstRequirementId;
    }

    public Integer getFirstRequirementNo() {
        return firstRequirementNo;
    }

    public void setFirstRequirementNo(Integer firstRequirementNo) {
        this.firstRequirementNo = firstRequirementNo;
    }

    public Integer getSecondRequirementNo() {
        return secondRequirementNo;
    }

    public void setSecondRequirementNo(Integer secondRequirementNo) {
        this.secondRequirementNo = secondRequirementNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", secondRequirementId=").append(secondRequirementId);
        sb.append(", firstRequirementId=").append(firstRequirementId);
        sb.append(", firstRequirementNo=").append(firstRequirementNo);
        sb.append(", secondRequirementNo=").append(secondRequirementNo);
        sb.append(", description=").append(description);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}