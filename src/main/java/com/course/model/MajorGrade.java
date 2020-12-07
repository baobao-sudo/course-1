package com.course.model;

import java.io.Serializable;

public class MajorGrade implements Serializable {
    private Integer majorGradeId;

    private Integer majorId;

    private Integer grade;

    private static final long serialVersionUID = 1L;

    public Integer getMajorGradeId() {
        return majorGradeId;
    }

    public void setMajorGradeId(Integer majorGradeId) {
        this.majorGradeId = majorGradeId;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", majorGradeId=").append(majorGradeId);
        sb.append(", majorId=").append(majorId);
        sb.append(", grade=").append(grade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}