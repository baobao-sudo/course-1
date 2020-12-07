package com.course.vo;

import com.course.model.SecondRequirement;
import lombok.Data;

import java.util.List;

/**
 * @Description 返回到展示界面的东西
 * @ClassName RequirementVO
 * @Author: baobao
 * @Date: Created in 19:52 2020/12/5
 */
@Data
public class RequirementVO {

    private Integer firstRequirementId;

    private Integer firstRequirementNo;

    private List<RequirementVOAttached> requirementVOAttacheds;
}
