package com.course.service;


import com.course.form.SecondRequirementForm;
import com.course.form.SecondRequirementUpdateFrom;
import com.course.vo.ResultVO;


/**
 * @Description 二级指标标点的操作
 * @ClassName SecondRequirementService
 * @Author: baobao
 * @Date: Created in 16:17 2020/10/9
 */
public interface SecondRequirementService {

    /**
     * 新增二级指标点
     * @param secondRequirementForm
     * @return
     */
    ResultVO addSecondRequirement(SecondRequirementForm secondRequirementForm);

    /**
     * 编辑二级指标点
     * @param secondRequirementUpdateFrom
     * @return
     */
    ResultVO editSecondRequirement(SecondRequirementUpdateFrom secondRequirementUpdateFrom);

    /**
     * 删除二级指标点
     * @param secondRequirementId 二级指标点ID
     * @return 删除
     */
    ResultVO deleteSecondRequirement(Integer secondRequirementId);


    /**
     * 返回所有二级指标点
     * @param firstRequirementId 一级指标点ID
     * @return 返回所有一级下的二级指标点
     */
    ResultVO findAllSecondRequirement(Integer firstRequirementId);


}
