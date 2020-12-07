package com.course.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Score implements Serializable {
    private String stuNo;

    private Integer majorCourseId;

    private BigDecimal totalScore;

    private static final long serialVersionUID = 1L;

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public Integer getMajorCourseId() {
        return majorCourseId;
    }

    public void setMajorCourseId(Integer majorCourseId) {
        this.majorCourseId = majorCourseId;
    }

    public BigDecimal getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(BigDecimal totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuNo=").append(stuNo);
        sb.append(", majorCourseId=").append(majorCourseId);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}