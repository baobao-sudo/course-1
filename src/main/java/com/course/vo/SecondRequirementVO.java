package com.course.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 二级指标点返回
 * @ClassName SecondRequirementVO
 * @Author: baobao
 * @Date: Created in 10:33 2020/10/11
 */
@Data
public class SecondRequirementVO implements Serializable {
    private static final long serialVersionUID = 8496610703985262024L;
    
    private Integer secondRequirementId;

    private String secondRequirementSequence;

    private String description;
}
