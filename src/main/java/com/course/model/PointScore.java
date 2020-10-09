package com.course.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class PointScore implements Serializable {
    private Integer pointScoreId;

    private Integer majorCourseId;

    private String studentNo;

    private Integer secondRequirementId;

    private BigDecimal pointScore;

    private static final long serialVersionUID = 1L;

    public Integer getPointScoreId() {
        return pointScoreId;
    }

    public void setPointScoreId(Integer pointScoreId) {
        this.pointScoreId = pointScoreId;
    }

    public Integer getMajorCourseId() {
        return majorCourseId;
    }

    public void setMajorCourseId(Integer majorCourseId) {
        this.majorCourseId = majorCourseId;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo == null ? null : studentNo.trim();
    }

    public Integer getSecondRequirementId() {
        return secondRequirementId;
    }

    public void setSecondRequirementId(Integer secondRequirementId) {
        this.secondRequirementId = secondRequirementId;
    }

    public BigDecimal getPointScore() {
        return pointScore;
    }

    public void setPointScore(BigDecimal pointScore) {
        this.pointScore = pointScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pointScoreId=").append(pointScoreId);
        sb.append(", majorCourseId=").append(majorCourseId);
        sb.append(", studentNo=").append(studentNo);
        sb.append(", secondRequirementId=").append(secondRequirementId);
        sb.append(", pointScore=").append(pointScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}