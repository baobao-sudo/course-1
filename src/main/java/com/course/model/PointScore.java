package com.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointScore implements Serializable {
    private Integer pointScoreId;

    private Integer courseId;

    private Integer studentNo;

    private Integer secondRequirementId;

    private Double pointScore;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pointScoreId=").append(pointScoreId);
        sb.append(", courseId=").append(courseId);
        sb.append(", studentNo=").append(studentNo);
        sb.append(", secondRequirementId=").append(secondRequirementId);
        sb.append(", pointScore=").append(pointScore);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}