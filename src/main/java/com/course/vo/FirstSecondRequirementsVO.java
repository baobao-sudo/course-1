package com.course.vo;

import com.course.model.SecondRequirement;
import lombok.Data;

import java.util.List;

/**
 * @Description TODO
 * @ClassName FirstSecondRequirements
 * @Author: baobao
 * @Date: Created in 20:07 2020/11/8
 */
@Data
public class FirstSecondRequirementsVO {
    private Integer firstRequirementId;

    private Integer firstRequirementNo;

    private String detail;

    private String description;

    private Integer majorId;

    List<SecondRequirementVO> secondRequirementVOS;
}
