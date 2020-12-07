package com.course.model;

import java.io.Serializable;
import java.util.Date;

public class Plan implements Serializable {
    private Integer planId;

    private Integer majorCourseId;

    private Integer term;

    private String cardId;

    private Integer status;

    private Date computeTime;

    private static final long serialVersionUID = 1L;

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public Integer getMajorCourseId() {
        return majorCourseId;
    }

    public void setMajorCourseId(Integer majorCourseId) {
        this.majorCourseId = majorCourseId;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getComputeTime() {
        return computeTime;
    }

    public void setComputeTime(Date computeTime) {
        this.computeTime = computeTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planId=").append(planId);
        sb.append(", majorCourseId=").append(majorCourseId);
        sb.append(", term=").append(term);
        sb.append(", cardId=").append(cardId);
        sb.append(", status=").append(status);
        sb.append(", computeTime=").append(computeTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}