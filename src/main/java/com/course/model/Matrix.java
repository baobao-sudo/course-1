package com.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Matrix implements Serializable {
    private Integer matrixId;

    private Integer typeId;

    private Integer courseId;

    private Integer count;

    private Integer firstRequirementId;

    private Integer secondRequirementId;

    private Double weight;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", matrixId=").append(matrixId);
        sb.append(", typeId=").append(typeId);
        sb.append(", courseId=").append(courseId);
        sb.append(", count=").append(count);
        sb.append(", firstRequirementId=").append(firstRequirementId);
        sb.append(", secondRequirementId=").append(secondRequirementId);
        sb.append(", weight=").append(weight);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}