package com.course.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private Integer stuId;

    private Integer stuNo;

    private Integer grade;

    private String major;

    private String name;

    private String phone;

    private String email;

    private Double one;

    private Double two;

    private Double three;

    private Double four;

    private Double five;

    private Double six;

    private Double seven;

    private Double eight;

    private Double nine;

    private Double ten;

    private Double eleven;

    private Double twelve;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuId=").append(stuId);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", grade=").append(grade);
        sb.append(", major=").append(major);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", one=").append(one);
        sb.append(", two=").append(two);
        sb.append(", three=").append(three);
        sb.append(", four=").append(four);
        sb.append(", five=").append(five);
        sb.append(", six=").append(six);
        sb.append(", seven=").append(seven);
        sb.append(", eight=").append(eight);
        sb.append(", nine=").append(nine);
        sb.append(", ten=").append(ten);
        sb.append(", eleven=").append(eleven);
        sb.append(", twelve=").append(twelve);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}