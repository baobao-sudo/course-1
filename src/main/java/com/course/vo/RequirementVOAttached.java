package com.course.vo;

import lombok.Data;

/**
 * @Description 展示所具有的二级指标点
 * @ClassName RequirementVOAttached
 * @Author: baobao
 * @Date: Created in 21:29 2020/12/5
 */
@Data
public class RequirementVOAttached {

    private Integer secondRequirementId;

    private Integer firstRequirementId;

    private String secondRequirementNumber;
}
