package com.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private Integer courseId;

    private Integer grade;

    private Integer credit;

    private String major;

    private String name;

    private Integer term;

    private Integer status;

    private Date computeTime;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", courseId=").append(courseId);
        sb.append(", grade=").append(grade);
        sb.append(", credit=").append(credit);
        sb.append(", major=").append(major);
        sb.append(", name=").append(name);
        sb.append(", term=").append(term);
        sb.append(", status=").append(status);
        sb.append(", computeTime=").append(computeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}