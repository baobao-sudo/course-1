package com.course.model;

import java.io.Serializable;

public class Matrix implements Serializable {
    private Integer matrixId;

    private Integer majorCourseId;

    private Integer count;

    private Integer firstRequirementNo;

    private Integer secondRequirementNo;

    private Double weight;

    private static final long serialVersionUID = 1L;

    public Integer getMatrixId() {
        return matrixId;
    }

    public void setMatrixId(Integer matrixId) {
        this.matrixId = matrixId;
    }

    public Integer getMajorCourseId() {
        return majorCourseId;
    }

    public void setMajorCourseId(Integer majorCourseId) {
        this.majorCourseId = majorCourseId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", matrixId=").append(matrixId);
        sb.append(", majorCourseId=").append(majorCourseId);
        sb.append(", count=").append(count);
        sb.append(", firstRequirementNo=").append(firstRequirementNo);
        sb.append(", secondRequirementNo=").append(secondRequirementNo);
        sb.append(", weight=").append(weight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}