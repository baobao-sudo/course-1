package com.course.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer stuId;

    private String stuNo;

    private Integer grade;

    private Integer majorId;

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

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo == null ? null : stuNo.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Double getOne() {
        return one;
    }

    public void setOne(Double one) {
        this.one = one;
    }

    public Double getTwo() {
        return two;
    }

    public void setTwo(Double two) {
        this.two = two;
    }

    public Double getThree() {
        return three;
    }

    public void setThree(Double three) {
        this.three = three;
    }

    public Double getFour() {
        return four;
    }

    public void setFour(Double four) {
        this.four = four;
    }

    public Double getFive() {
        return five;
    }

    public void setFive(Double five) {
        this.five = five;
    }

    public Double getSix() {
        return six;
    }

    public void setSix(Double six) {
        this.six = six;
    }

    public Double getSeven() {
        return seven;
    }

    public void setSeven(Double seven) {
        this.seven = seven;
    }

    public Double getEight() {
        return eight;
    }

    public void setEight(Double eight) {
        this.eight = eight;
    }

    public Double getNine() {
        return nine;
    }

    public void setNine(Double nine) {
        this.nine = nine;
    }

    public Double getTen() {
        return ten;
    }

    public void setTen(Double ten) {
        this.ten = ten;
    }

    public Double getEleven() {
        return eleven;
    }

    public void setEleven(Double eleven) {
        this.eleven = eleven;
    }

    public Double getTwelve() {
        return twelve;
    }

    public void setTwelve(Double twelve) {
        this.twelve = twelve;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stuId=").append(stuId);
        sb.append(", stuNo=").append(stuNo);
        sb.append(", grade=").append(grade);
        sb.append(", majorId=").append(majorId);
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