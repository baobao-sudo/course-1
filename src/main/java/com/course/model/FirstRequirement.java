package com.course.model;

import java.io.Serializable;

public class FirstRequirement implements Serializable {
    private Integer firstRequirementId;

    private Integer firstRequirementNo;

    private String detail;

    private String description;

    private Integer majorId;

    private static final long serialVersionUID = 1L;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", firstRequirementId=").append(firstRequirementId);
        sb.append(", firstRequirementNo=").append(firstRequirementNo);
        sb.append(", detail=").append(detail);
        sb.append(", description=").append(description);
        sb.append(", majorId=").append(majorId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}